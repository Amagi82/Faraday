package konvert.derived.molar

import konvert.Units

/**
 * Molality, also called molal concentration, is a measure of the concentration of a solute in a
 * solution in terms of amount of substance in a specified amount of mass of the solvent. This
 * contrasts with the definition of molarity which is based on a specified volume of solution.
 *
 * @see https://en.wikipedia.org/wiki/Molality
 * */
inline class Molality(val molesPerKilogram: Double) : Units<Molality> {
    override val value: Double get() = molesPerKilogram
    override fun plus(other: Molality): Molality = Molality(molesPerKilogram + other.molesPerKilogram)
    override fun minus(other: Molality): Molality = Molality(molesPerKilogram - other.molesPerKilogram)
    override fun times(factor: Number): Molality = Molality(molesPerKilogram * factor.toDouble())
    override fun div(factor: Number): Molality = Molality(molesPerKilogram / factor.toDouble())
}
