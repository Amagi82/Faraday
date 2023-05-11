package faraday.derived.molar

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The molar heat capacity of a chemical substance is the amount of energy that must be added, in
 * the form of heat, to one mole of the substance in order to cause an increase of one unit in its
 * temperature. Alternatively, it is the heat capacity of a sample of the substance divided by the
 * amount of substance of the sample; or also the specific heat capacity of the substance times
 * its molar mass.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Molar_heat_capacity)
 */
@JvmInline
value class MolarHeatCapacity(val joulesPerKelvinMole: Double) : Units<MolarHeatCapacity> {
    override fun plus(other: MolarHeatCapacity) = MolarHeatCapacity(joulesPerKelvinMole = joulesPerKelvinMole + other.joulesPerKelvinMole)
    override fun minus(other: MolarHeatCapacity) = MolarHeatCapacity(joulesPerKelvinMole = joulesPerKelvinMole - other.joulesPerKelvinMole)
    override fun times(factor: Number) = MolarHeatCapacity(joulesPerKelvinMole = joulesPerKelvinMole * factor.toDouble())
    override fun div(factor: Number) = MolarHeatCapacity(joulesPerKelvinMole = joulesPerKelvinMole / factor.toDouble())
    override fun compareTo(other: MolarHeatCapacity): Int = joulesPerKelvinMole.compareTo(other.joulesPerKelvinMole)
}
