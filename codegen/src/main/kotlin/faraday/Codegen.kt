package faraday

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File
import kotlin.Unit
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
    buildAll()
}

fun buildAll() {
    buildUnits {
        val mass by unit(name = "Mass", baseUnit = "kilograms") {
            val carat = constant(name = "CARAT", value = 2e-4)
            val pound = constant(name = "POUND", value = 0.45359237)
            unit("grams", unitModifier = Multiplier(1000), createNumberExtension = true)
            unit("pounds", unitModifier = Divisor(pound.value), createNumberExtension = true)
        }
        val volume by unit(name = "Volume", baseUnit = "cubicMeters")
        val density by unit(name = "Density", baseUnit = "kilogramsPerCubicMeter")

        conversion(density.equalTo(volume / mass))
    }
}

fun buildUnits(block: UnitsWithConversions.() -> Unit) = UnitsWithConversions().apply(block).generate()

data class UnitsWithConversions(val units: MutableList<UnitType> = mutableListOf(), val conversions: MutableList<UnitConversion> = mutableListOf()) {
    fun generate() {
        val baseDir = File("codegen/build/generated/kotlin/faraday").apply(File::mkdirs)

        val unitsInterface = ClassName("faraday", "Units")
        val t = TypeVariableName("T")
        val baseUnitsInterface = TypeSpec.interfaceBuilder(unitsInterface.simpleName)
            .addTypeVariable(TypeVariableName("T", unitsInterface.parameterizedBy(t)))
            .addSuperinterface(Comparable::class.asClassName().parameterizedBy(t))
            .addFunction(
                FunSpec.builder("plus")
                    .addModifiers(KModifier.OPERATOR, KModifier.ABSTRACT)
                    .addParameter("other", t)
                    .returns(t)
                    .build()
            )
            .addFunction(
                FunSpec.builder("minus")
                    .addModifiers(KModifier.OPERATOR, KModifier.ABSTRACT)
                    .addParameter("other", t)
                    .returns(t)
                    .build()
            )
            .addFunction(
                FunSpec.builder("times")
                    .addModifiers(KModifier.OPERATOR, KModifier.ABSTRACT)
                    .addParameter("other", Number::class)
                    .returns(t)
                    .build()
            )
            .addFunction(
                FunSpec.builder("div")
                    .addModifiers(KModifier.OPERATOR, KModifier.ABSTRACT)
                    .addParameter("other", Number::class)
                    .returns(t)
                    .build()
            )
            .build()
        FileSpec.builder(unitsInterface.packageName, unitsInterface.simpleName)
            .addType(baseUnitsInterface)
            .build()
            .writeTo(baseDir)

        units.forEach { unit ->
            val unitClass = ClassName("faraday", unit.name)
            FileSpec.builder(unitClass.packageName, unit.name)
                .addType(
                    TypeSpec.valueClassBuilder(unit.name)
                        .addAnnotation(JvmInline::class)
                        .primaryConstructor(
                            FunSpec.constructorBuilder()
                                .addParameter(unit.baseUnit, Double::class)
                                .build()
                        )
                        .addSuperinterface(unitsInterface.parameterizedBy(unitClass))
                        .addProperty(
                            PropertySpec.builder(unit.baseUnit, Double::class)
                                .initializer(unit.baseUnit)
                                .build()
                        )
                        .addProperties(
                            unit.units.map {
                                PropertySpec.builder(it.name, Double::class)
                                    .getter(
                                        FunSpec.getterBuilder()
                                            .addStatement("return %S", "${unit.baseUnit} / ${it.modifier.factor}")
                                            .build()
                                    )
                                    .build()
                            }
                        )
                        .addFunction(
                            FunSpec.builder("plus")
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("other", unitClass)
                                .addStatement("return %T(${unit.baseUnit} = ${unit.baseUnit} + other.${unit.baseUnit})", unitClass)
                                .build()
                        )
                        .addFunction(
                            FunSpec.builder("minus")
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("other", unitClass)
                                .addStatement("return %T(${unit.baseUnit} = ${unit.baseUnit} - other.${unit.baseUnit})", unitClass)
                                .build()
                        )
                        .addFunction(
                            FunSpec.builder("times")
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("factor", Number::class)
                                .addStatement("return %T(${unit.baseUnit} = ${unit.baseUnit} * factor.toDouble())", unitClass)
                                .build()
                        )
                        .addFunction(
                            FunSpec.builder("div")
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("factor", Number::class)
                                .addStatement("return %T(${unit.baseUnit} = ${unit.baseUnit} / factor.toDouble())", unitClass)
                                .build()
                        )
                        .addFunction(
                            FunSpec.builder("compareTo")
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("other", unitClass)
                                .returns(Int::class)
                                .addStatement("return ${unit.baseUnit}.compareTo(other.${unit.baseUnit})")
                                .build()
                        )
                        .build()
                )
                .build()
                .writeTo(baseDir)


//            file.bufferedWriter().use { out ->
//                out.write("package faraday")
//            }
        }
    }
}

data class UnitType(
    val name: String,
    val baseUnit: String,
    val units: MutableList<UnitSubtype> = mutableListOf(),
    val constants: MutableList<UnitConstant> = mutableListOf()
) {
    fun unit(unit: String, unitModifier: UnitModifier, createNumberExtension: Boolean = false) {
        units.add(UnitSubtype(name = unit, modifier = unitModifier, createNumberExtension = createNumberExtension))
    }

    fun constant(name: String, value: Number) = UnitConstant(name = name, value = value).also(constants::add)

    operator fun times(other: UnitType) = ConversionsExpression.Multiplier(a = this, b = other)

    operator fun div(other: UnitType) = ConversionsExpression.Divider(numerator = this, denominator = other)

    fun equalTo(other: ConversionsExpression) = UnitConversion(unit = this, expression = other)
}

data class UnitSubtype(val name: String, val modifier: UnitModifier, val createNumberExtension: Boolean)
data class UnitConstant(val name: String, val value: Number)

sealed interface UnitModifier {
    val factor: Number
}

data class Multiplier(override val factor: Number) : UnitModifier
data class Divisor(override val factor: Number) : UnitModifier

data class UnitConversion(val unit: UnitType, val expression: ConversionsExpression)

sealed interface ConversionsExpression {
    data class Multiplier(val a: UnitType, val b: UnitType) : ConversionsExpression
    data class Divider(val numerator: UnitType, val denominator: UnitType) : ConversionsExpression

    fun equalTo(other: UnitType) = UnitConversion(unit = other, expression = this)
}

fun UnitsWithConversions.unit(name: String, baseUnit: String, block: UnitType.() -> Unit = {}) = object : ReadOnlyProperty<Any?, UnitType> {
    val unit = UnitType(name = name, baseUnit = baseUnit).apply(block).also(units::add)

    override fun getValue(thisRef: Any?, property: KProperty<*>) = unit
}

fun UnitsWithConversions.conversion(conversion: UnitConversion) = object : ReadOnlyProperty<Any?, UnitConversion> {
    val conversion = conversion.also(conversions::add)

    override fun getValue(thisRef: Any?, property: KProperty<*>) = conversion
}
