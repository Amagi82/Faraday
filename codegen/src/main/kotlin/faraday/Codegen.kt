package faraday

import java.io.File
import kotlin.Unit
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty


fun buildUnits(block: UnitsWithConversions.() -> Unit) = UnitsWithConversions().apply(block).generate()

data class UnitsWithConversions(
    private val units: MutableList<UnitType> = mutableListOf(),
    val conversions: MutableList<UnitConversion> = mutableListOf(),
    private val constants: MutableList<Constant> = mutableListOf()
) {
    fun generate() {
        val baseDir = File("codegen/build/generated/kotlin/faraday").apply(File::mkdirs)

        File(baseDir, "Units.kt").also(File::createNewFile).writeText(
            """
            package faraday
            
            interface Units<T : Units<T>> : Comparable<T> {
                operator fun plus(other: T): T
                operator fun minus(other: T): T
                operator fun times(factor: Number): T
                operator fun div(factor: Number): T
            }
            """.trimIndent()
        )

        units.forEach { unitType ->
            val (unitName, baseUnit, subUnits, constants, createNumberExtension) = unitType
            File(baseDir, "$unitName.kt").also(File::createNewFile).writeText(
                buildString {
                    appendLine("package faraday")
                    appendLine()
                    appendLine("import kotlin.jvm.JvmInline")
                    appendLine()
                    appendLine("@JvmInline")
                    appendLine("value class $unitName(val $baseUnit: Double) : Units<$unitName> {")
                    subUnits.forEach { appendLine("\tval ${it.name} get() = $baseUnit / ${it.factor}") }
                    appendLine()
                    appendLine("\toverride fun plus(other: $unitName) = $unitName($baseUnit = $baseUnit + other.$baseUnit)")
                    appendLine("\toverride fun minus(other: $unitName) = $unitName($baseUnit = $baseUnit - other.$baseUnit)")
                    appendLine("\toverride fun times(factor: Number) = $unitName($baseUnit = $baseUnit * factor.toDouble())")
                    appendLine("\toverride fun div(factor: Number) = $unitName($baseUnit = $baseUnit / factor.toDouble())")
                    appendLine("\toverride fun compareTo(other: $unitName): Int = $baseUnit.compareTo(other.$baseUnit)")

                    val unitConversions = conversions.flatMap { it.generateOperators(unitName) }
                    if (unitConversions.isNotEmpty()) {
                        appendLine()
                        unitConversions.forEach { conversion ->
                            appendLine(conversion)
                        }
                    }

                    if (constants.isNotEmpty()) {
                        appendLine()
                        appendLine("\tcompanion object {")
                        constants.forEach {
                            appendLine("\t\tconst val ${it.name} = ${it.value}")
                        }
                        appendLine("\t}")
                    }
                    appendLine("}")
                    if (createNumberExtension) {
                        appendLine()
                        appendLine("val Number.$baseUnit get() = $unitName($baseUnit = toDouble())")
                        subUnits.forEach {
                            if (it.createNumberExtension) {
                                appendLine("val Number.${it.name} get() = $unitName($baseUnit = toDouble() * ${it.factor})")
                            }
                        }
                    }
                }
            )
        }
    }

    fun unit(base: String, enableExtensions: Boolean, block: UnitType.() -> Unit = {}) = PropertyDelegateProvider { _: Any?, property ->
        check(base.isNotEmpty()) { "base unit missing for ${property.name}" }
        check(property.name.isNotEmpty()) { "Property name missing for $base" }
        val unit = UnitType(name = property.name.replaceFirstChar(Char::uppercaseChar), baseUnit = base, enableExtensions = enableExtensions).apply(block)
            .also(units::add)
        ReadOnlyProperty<Any?, UnitType> { _, _ -> unit }
    }

    fun constant(value: Double) = PropertyDelegateProvider { _: Any?, property ->
        val constant = Constant(name = property.name.uppercase(), value = value).also(constants::add)
        ReadOnlyProperty<Any?, Constant> { _, _ -> constant }
    }

    infix fun UnitType.equalTo(other: ConversionsExpression) = UnitConversion(this, other)
}

/**
 * [name] e.g. Distance
 * [baseUnit] e.g. meters
 * [subUnits] e.g. millimeters, centimeters, kilometers, etc
 * [constants] e.g. LIGHT_YEAR
 */
data class UnitType(
    val name: String,
    val baseUnit: String,
    val subUnits: MutableList<UnitSubtype> = mutableListOf(),
    val constants: MutableList<UnitConstant> = mutableListOf(),
    val enableExtensions: Boolean
) {
    fun unit(unit: String, factor: Number, createNumberExtension: Boolean = false) = unit(unit, UnitValue(factor.toDouble()), createNumberExtension)
    fun unit(unit: String, factor: Factor, createNumberExtension: Boolean = false) {
        subUnits.add(UnitSubtype(name = unit, factor = factor, createNumberExtension = createNumberExtension))
    }

    fun constant(name: String, value: Number) = UnitConstant(name = name, unitTypeName = this.name, value = value.toDouble()).also(constants::add)

    operator fun times(other: UnitType) = ConversionsExpression.Multiplier(a = this, b = other)

    operator fun div(other: UnitType) = ConversionsExpression.Divider(numerator = this, denominator = other)
}

data class UnitSubtype(val name: String, val factor: Factor, val createNumberExtension: Boolean)
data class UnitConstant(val name: String, val unitTypeName: String, override val value: Double) : Factor {
    override fun toString(): String = "$unitTypeName.$name"
}

data class UnitValue(override val value: Double) : Factor {
    override fun toString(): String = "$value"
}

data class Constant(val name: String, override val value: Double) : Factor {
    override fun toString(): String = "Constants.$name"
}

sealed interface Factor {
    val value: Double
}

data class UnitConversion(val result: UnitType, val expression: ConversionsExpression) {
    fun generateOperators(unitName: String): List<String> = when (expression) {
        is ConversionsExpression.Multiplier -> {
            // r / b = a
            // r / a = b
            // a * b = r
            // b * a = r
            when (unitName) {
                result.name -> listOf(
                    divOperator(n = result, d = expression.b, r = expression.a),
                    divOperator(n = result, d = expression.a, r = expression.b)
                )

                expression.a.name -> listOf(timesOperator(a = expression.a, b = expression.b, r = result))
                expression.b.name -> listOf(timesOperator(a = expression.b, b = expression.a, r = result))
                else -> listOf()
            }
        }

        is ConversionsExpression.Divider -> {
            // r * d = n
            // n / d = r
            // n / r = d
            // d * r = n
            when (unitName) {
                result.name -> listOf(timesOperator(a = result, b = expression.denominator, r = expression.numerator))
                expression.numerator.name -> listOf(
                    divOperator(n = expression.numerator, d = expression.denominator, r = result),
                    divOperator(n = expression.numerator, d = result, r = expression.denominator)
                )

                expression.denominator.name -> listOf(timesOperator(a = expression.denominator, b = result, r = expression.numerator))
                else -> listOf()
            }
        }
    }

    private fun timesOperator(a: UnitType, b: UnitType, r: UnitType) =
        "\toperator fun times(${b.name.replaceFirstChar(Char::lowercaseChar)}: ${b.name}) = ${r.name}(${r.baseUnit} = ${a.baseUnit} * ${b.name.replaceFirstChar(Char::lowercaseChar)}.${b.baseUnit})"

    private fun divOperator(n: UnitType, d: UnitType, r: UnitType) =
        "\toperator fun div(${d.name.replaceFirstChar(Char::lowercaseChar)}: ${d.name}) = ${r.name}(${r.baseUnit} = ${n.baseUnit} * ${d.name.replaceFirstChar(Char::lowercaseChar)}.${d.baseUnit})"
}

sealed interface ConversionsExpression {
    data class Multiplier(val a: UnitType, val b: UnitType) : ConversionsExpression {
        override fun contains(unit: UnitType): Boolean = unit == a || unit == b
    }

    data class Divider(val numerator: UnitType, val denominator: UnitType) : ConversionsExpression {
        override fun contains(unit: UnitType): Boolean = unit == numerator || unit == denominator
    }

    operator fun contains(unit: UnitType): Boolean

    fun equalTo(other: UnitType) = UnitConversion(result = other, expression = this)
}

/**
 * Copy all the documentation over from the cage units
 */
fun copyDocs(){
    val copyDir = File("codegen/src/main/kotlin/faraday/docs/").apply(File::mkdirs)
    File("cage/src/commonMain/kotlin/faraday").walkTopDown().forEach {file ->
        if(file.isDirectory) return@forEach
        file.bufferedReader().use {
            val comment = it.readText().substringAfter("/**").substringBefore("*/")
            if(comment.isNotBlank()){
                val output = File(copyDir, file.name).apply(File::createNewFile)
                output.writeText("/**$comment*/")
            }
        }
    }
}