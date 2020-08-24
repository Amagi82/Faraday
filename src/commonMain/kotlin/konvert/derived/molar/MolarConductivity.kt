package konvert.derived.molar

import konvert.Units

/**
 * The molar conductivity of an electrolyte solution is defined as its conductivity divided by
 * its molar concentration.
 *
 * @see https://en.wikipedia.org/wiki/Molar_conductivity
 * */
inline class MolarConductivity(val siemensSquareMetersPerMole: Double) : Units<MolarConductivity> {
    override val value: Double get() = siemensSquareMetersPerMole
    override fun plus(other: MolarConductivity): MolarConductivity = MolarConductivity(siemensSquareMetersPerMole + other.siemensSquareMetersPerMole)
    override fun minus(other: MolarConductivity): MolarConductivity = MolarConductivity(siemensSquareMetersPerMole - other.siemensSquareMetersPerMole)
    override fun times(factor: Number): MolarConductivity = MolarConductivity(siemensSquareMetersPerMole * factor.toDouble())
    override fun div(factor: Number): MolarConductivity = MolarConductivity(siemensSquareMetersPerMole / factor.toDouble())
}
