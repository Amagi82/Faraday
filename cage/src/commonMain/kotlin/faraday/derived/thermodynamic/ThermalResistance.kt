package faraday.derived.thermodynamic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Thermal resistance is a heat property and a measurement of a temperature difference by
 * which an object or material resists a heat flow. Thermal resistance is the reciprocal
 * of thermal conductance.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Thermal_resistance)
 */
@JvmInline
value class ThermalResistance(val kelvinsPerWatt: Double) : Units<ThermalResistance> {
    override fun plus(other: ThermalResistance) = ThermalResistance(kelvinsPerWatt = kelvinsPerWatt + other.kelvinsPerWatt)
    override fun minus(other: ThermalResistance) = ThermalResistance(kelvinsPerWatt = kelvinsPerWatt - other.kelvinsPerWatt)
    override fun times(factor: Number) = ThermalResistance(kelvinsPerWatt = kelvinsPerWatt * factor.toDouble())
    override fun div(factor: Number) = ThermalResistance(kelvinsPerWatt = kelvinsPerWatt / factor.toDouble())
    override fun compareTo(other: ThermalResistance): Int = kelvinsPerWatt.compareTo(other.kelvinsPerWatt)
}
