package faraday.base

import faraday.Constants
import faraday.Units
import faraday.derived.Catalysis
import kotlin.jvm.JvmInline


/**
 * In chemistry, the amount of substance in a given sample of matter is defined as the number of
 * discrete atomic-scale particles in it divided by the Avogadro constant NA. In a truly atomistic
 * view, the amount of substance is simply the number of particles that constitute the substance.
 * The particles or entities may be molecules, atoms, ions, electrons, or other, depending on the
 * context. The value of the Avogadro constant NA has been defined as 6.02214076×1023 mol−1. In
 * the truly atomistic view, 1 mol = 6.02214076×1023 particles (the Avogadro number) and therefore
 * the conversion constant is simply NA = 1. The amount of substance is sometimes referred to as
 * the chemical amount.
 *
 * The mole (symbol: mol) is a unit of amount of substance in the International System of Units,
 * defined (since 2019) by fixing the Avogadro constant at the given value. Historically, the mole
 * was defined as the amount of substance in 12 grams of the carbon-12 isotope. As a consequence,
 * the mass of one mole of a chemical compound, in grams, is numerically equal (for all practical
 * purposes) to the mass of one molecule of the compound, in daltons, and the molar mass of an
 * isotope in grams per mole is equal to the mass number. For example, a molecule of water has a
 * mass of about 18.015 daltons on average, whereas a mole of water (which contains 6.02214076×1023
 * water molecules) has a total mass of about 18.015 grams.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Amount_of_substance)
 */
@JvmInline
value class ChemicalAmount(val moles: Double) : Units<ChemicalAmount> {
    override fun plus(other: ChemicalAmount) = ChemicalAmount(moles = moles + other.moles)
    override fun minus(other: ChemicalAmount) = ChemicalAmount(moles = moles - other.moles)
    override fun times(factor: Number) = ChemicalAmount(moles = moles * factor.toDouble())
    override fun div(factor: Number) = ChemicalAmount(moles = moles / factor.toDouble())
    override fun compareTo(other: ChemicalAmount): Int = moles.compareTo(other.moles)

    operator fun div(time: Time) = Catalysis(katals = moles / time.seconds)

    companion object {
        val AVOGADRO_CONSTANT get() = Constants.AVOGADRO_CONSTANT
    }
}

val Number.moles get() = ChemicalAmount(moles = toDouble())
