package konvert.derived.molar

import konvert.Units

/**
 * In chemistry, the molar mass is defined as the mass of a sample of that compound divided by the
 * amount of substance in that sample, measured in moles. The molar mass is a bulk, not molecular,
 * property of a substance. The molar mass is an average of many instances of the compound, which
 * often vary in mass due to the presence of isotopes. Most commonly, the molar mass is computed
 * from the standard atomic weights and is thus a terrestrial average and a function of the relative
 * abundance of the isotopes of the constituent atoms on earth. The molar mass is appropriate for
 * converting between the mass of a substance and the amount of a substance for bulk quantities.
 *
 * @see https://en.wikipedia.org/wiki/Molar_mass
 * */
inline class MolarMass(val kilogramsPerMole: Double) : Units<MolarMass> {
    override val value: Double get() = kilogramsPerMole
    override fun plus(other: MolarMass): MolarMass = MolarMass(kilogramsPerMole + other.kilogramsPerMole)
    override fun minus(other: MolarMass): MolarMass = MolarMass(kilogramsPerMole - other.kilogramsPerMole)
    override fun times(factor: Number): MolarMass = MolarMass(kilogramsPerMole * factor.toDouble())
    override fun div(factor: Number): MolarMass = MolarMass(kilogramsPerMole / factor.toDouble())
}
