package faraday

import kotlin.jvm.JvmInline

/**
 * Thermal resistance is a heat property and a measurement of a temperature difference by
 * which an object or material resists a heat flow. Thermal resistance is the reciprocal
 * of thermal conductance.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Thermal_resistance)
 */
@JvmInline
value class ThermalResistivity(val kelvinMetersPerWatt: Double) : Units<ThermalResistivity> {
    @InternalUnitApi
    override val rawValue: Double get() = kelvinMetersPerWatt

    @InternalUnitApi
    override fun create(value: Double) = ThermalResistivity(value)
}
