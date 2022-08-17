package faraday

import kotlin.Unit
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

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

fun buildUnits(block: UnitsWithConversions.() -> Unit) = UnitsWithConversions().apply(block)

data class UnitsWithConversions(val units: MutableList<UnitType> = mutableListOf(), val conversions: MutableList<UnitConversion> = mutableListOf())

fun UnitsWithConversions.unit(name: String, baseUnit: String, block: UnitType.() -> Unit = {}) = object : ReadOnlyProperty<Any?, UnitType> {
    val unit = UnitType(name = name, baseUnit = baseUnit).apply(block).also(units::add)

    override fun getValue(thisRef: Any?, property: KProperty<*>) = unit
}

fun UnitsWithConversions.conversion(conversion: UnitConversion) = object : ReadOnlyProperty<Any?, UnitConversion> {
    val conversion = conversion.also(conversions::add)

    override fun getValue(thisRef: Any?, property: KProperty<*>) = conversion
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

sealed interface UnitModifier
data class Multiplier(val factor: Number) : UnitModifier
data class Divisor(val factor: Number) : UnitModifier

data class UnitConversion(val unit: UnitType, val expression: ConversionsExpression)

sealed interface ConversionsExpression {
    data class Multiplier(val a: UnitType, val b: UnitType) : ConversionsExpression
    data class Divider(val numerator: UnitType, val denominator: UnitType) : ConversionsExpression

    fun equalTo(other: UnitType) = UnitConversion(unit = other, expression = this)
}
