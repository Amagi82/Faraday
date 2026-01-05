package faraday

import kotlin.jvm.JvmInline

/**
 * In chemistry, the mass fraction of a substance within a mixture is the ratio of the mass
 * of that substance to the total mass of the mixture. Mass fraction can also be expressed,
 * with a denominator of 100, as percentage by mass. It is one way of expressing the
 * composition of a mixture in a dimensionless size; mole fraction (percentage by moles,
 * mol%) and volume fraction (percentage by volume, vol%) are others.
 *
 * When the prevalences of interest are those of individual chemical elements, rather than
 * of compounds or other substances, the term mass fraction can also refer to the ratio of
 * the mass of an element to the total mass of a sample. In these contexts an alternative
 * term is mass percent composition. The mass fraction of an element in a compound can be
 * calculated from the compound's empirical formula or its chemical formula.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Mass_fraction_(chemistry)
 */
@JvmInline
value class MassFraction(val ppm: Double) : Units<MassFraction> {
    val percent get() = ppm / 10_000

    @InternalUnitApi
    override val rawValue: Double get() = ppm

    @InternalUnitApi
    override fun create(value: Double) = MassFraction(value)
}
