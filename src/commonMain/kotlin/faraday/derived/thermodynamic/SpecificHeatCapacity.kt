package faraday.derived.thermodynamic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The specific heat capacity,(symbol Cp) of a substance is the heat capacity of a sample of the
 * substance divided by the mass of the sample. Informally, it is the amount of energy that must
 * be added, in the form of heat, to one unit of mass of the substance in order to cause an
 * increase of one unit in its temperature.
 *
 * @see https://en.wikipedia.org/wiki/Specific_heat_capacity
 * */
@JvmInline
value class SpecificHeatCapacity(val joulesPerKilogramKelvin: Double) : Units<SpecificHeatCapacity> {
    override fun plus(other: SpecificHeatCapacity) = SpecificHeatCapacity(joulesPerKilogramKelvin = joulesPerKilogramKelvin + other.joulesPerKilogramKelvin)
    override fun minus(other: SpecificHeatCapacity) = SpecificHeatCapacity(joulesPerKilogramKelvin = joulesPerKilogramKelvin - other.joulesPerKilogramKelvin)
    override fun times(factor: Number) = SpecificHeatCapacity(joulesPerKilogramKelvin = joulesPerKilogramKelvin * factor.toDouble())
    override fun div(factor: Number) = SpecificHeatCapacity(joulesPerKilogramKelvin = joulesPerKilogramKelvin / factor.toDouble())
    override fun compareTo(other: SpecificHeatCapacity): Int = joulesPerKilogramKelvin.compareTo(other.joulesPerKilogramKelvin)
}
