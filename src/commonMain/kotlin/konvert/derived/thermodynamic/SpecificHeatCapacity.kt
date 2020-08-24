package konvert.derived.thermodynamic

import konvert.Units

/**
 * The specific heat capacity,(symbol Cp) of a substance is the heat capacity of a sample of the
 * substance divided by the mass of the sample. Informally, it is the amount of energy that must
 * be added, in the form of heat, to one unit of mass of the substance in order to cause an
 * increase of one unit in its temperature.
 *
 * @see https://en.wikipedia.org/wiki/Specific_heat_capacity
 * */
inline class SpecificHeatCapacity(val joulesPerKilogramKelvin: Double) : Units<SpecificHeatCapacity> {
    override val value: Double get() = joulesPerKilogramKelvin
    override fun plus(other: SpecificHeatCapacity): SpecificHeatCapacity = SpecificHeatCapacity(joulesPerKilogramKelvin + other.joulesPerKilogramKelvin)
    override fun minus(other: SpecificHeatCapacity): SpecificHeatCapacity = SpecificHeatCapacity(joulesPerKilogramKelvin - other.joulesPerKilogramKelvin)
    override fun times(factor: Number): SpecificHeatCapacity = SpecificHeatCapacity(joulesPerKilogramKelvin * factor.toDouble())
    override fun div(factor: Number): SpecificHeatCapacity = SpecificHeatCapacity(joulesPerKilogramKelvin / factor.toDouble())
}
