package faraday.derived.molar

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Molar concentration (also called molarity, amount concentration or substance concentration) is a
 * measure of the concentration of a chemical species, in particular of a solute in a solution, in
 * terms of amount of substance per unit volume of solution. In chemistry, the most commonly used
 * unit for molarity is the number of moles per litre, having the unit symbol mol/L or mol⋅dm−3 in SI
 * unit. A solution with a concentration of 1 mol/L is said to be 1 molar, commonly designated as
 * 1 M. To avoid confusion with SI prefix mega, which has the same abbreviation, small caps ᴍ or
 * italicized M are also used in journals and textbooks.
 *
 * @see https://en.wikipedia.org/wiki/Molar_concentration
 * */
@JvmInline
value class Molarity(val molesPerCubicMeter: Double) : Units<Molarity> {
    override fun plus(other: Molarity) = Molarity(molesPerCubicMeter = molesPerCubicMeter + other.molesPerCubicMeter)
    override fun minus(other: Molarity) = Molarity(molesPerCubicMeter = molesPerCubicMeter - other.molesPerCubicMeter)
    override fun times(factor: Number) = Molarity(molesPerCubicMeter = molesPerCubicMeter * factor.toDouble())
    override fun div(factor: Number) = Molarity(molesPerCubicMeter = molesPerCubicMeter / factor.toDouble())
    override fun compareTo(other: Molarity): Int = molesPerCubicMeter.compareTo(other.molesPerCubicMeter)
}
typealias MolarConcentration = Molarity
