package konvert.derived.thermodynamic

import konvert.Units

/**
 * Heat capacity or thermal capacity is a physical property of matter, defined as the amount of heat
 * to be supplied to a given mass of a material to produce a unit change in its temperature.
 *
 * @see https://en.wikipedia.org/wiki/Heat_capacity
 * */
inline class HeatCapacity(val joulesPerKelvin: Double) : Units<HeatCapacity> {
    override val value: Double get() = joulesPerKelvin
    override fun plus(other: HeatCapacity): HeatCapacity = HeatCapacity(joulesPerKelvin + other.joulesPerKelvin)
    override fun minus(other: HeatCapacity): HeatCapacity = HeatCapacity(joulesPerKelvin - other.joulesPerKelvin)
    override fun times(factor: Number): HeatCapacity = HeatCapacity(joulesPerKelvin * factor.toDouble())
    override fun div(factor: Number): HeatCapacity = HeatCapacity(joulesPerKelvin / factor.toDouble())
}
