package konvert.derived.thermodynamic

import konvert.Units

/**
 * Thermal resistance is a heat property and a measurement of a temperature difference by
 * which an object or material resists a heat flow. Thermal resistance is the reciprocal
 * of thermal conductance.
 *
 * @see https://en.wikipedia.org/wiki/Thermal_resistance
 * */
inline class ThermalResistance(val kelvinsPerWatt: Double) : Units<ThermalResistance> {
    override val value: Double get() = kelvinsPerWatt
    override fun plus(other: ThermalResistance): ThermalResistance = ThermalResistance(kelvinsPerWatt + other.kelvinsPerWatt)
    override fun minus(other: ThermalResistance): ThermalResistance = ThermalResistance(kelvinsPerWatt - other.kelvinsPerWatt)
    override fun times(factor: Number): ThermalResistance = ThermalResistance(kelvinsPerWatt * factor.toDouble())
    override fun div(factor: Number): ThermalResistance = ThermalResistance(kelvinsPerWatt / factor.toDouble())
}
