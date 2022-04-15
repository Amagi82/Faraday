package faraday.derived.molar

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Molality, also called molal concentration, is a measure of the concentration of a solute in a
 * solution in terms of amount of substance in a specified amount of mass of the solvent. This
 * contrasts with the definition of molarity which is based on a specified volume of solution.
 *
 * @see https://en.wikipedia.org/wiki/Molality
 * */
@JvmInline
value class Molality(val molesPerKilogram: Double) : Units<Molality> {
    override fun plus(other: Molality) = Molality(molesPerKilogram = molesPerKilogram + other.molesPerKilogram)
    override fun minus(other: Molality) = Molality(molesPerKilogram = molesPerKilogram - other.molesPerKilogram)
    override fun times(factor: Number) = Molality(molesPerKilogram = molesPerKilogram * factor.toDouble())
    override fun div(factor: Number) = Molality(molesPerKilogram = molesPerKilogram / factor.toDouble())
    override fun compareTo(other: Molality): Int = molesPerKilogram.compareTo(other.molesPerKilogram)
}
