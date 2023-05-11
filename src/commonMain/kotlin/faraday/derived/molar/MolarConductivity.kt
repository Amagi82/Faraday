package faraday.derived.molar

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The molar conductivity of an electrolyte solution is defined as its conductivity divided by
 * its molar concentration.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Molar_conductivity)
 */
@JvmInline
value class MolarConductivity(val siemensSquareMetersPerMole: Double) : Units<MolarConductivity> {
    override fun plus(other: MolarConductivity) = MolarConductivity(siemensSquareMetersPerMole = siemensSquareMetersPerMole + other.siemensSquareMetersPerMole)
    override fun minus(other: MolarConductivity) = MolarConductivity(siemensSquareMetersPerMole = siemensSquareMetersPerMole - other.siemensSquareMetersPerMole)
    override fun times(factor: Number) = MolarConductivity(siemensSquareMetersPerMole = siemensSquareMetersPerMole * factor.toDouble())
    override fun div(factor: Number) = MolarConductivity(siemensSquareMetersPerMole = siemensSquareMetersPerMole / factor.toDouble())
    override fun compareTo(other: MolarConductivity): Int = siemensSquareMetersPerMole.compareTo(other.siemensSquareMetersPerMole)
}
