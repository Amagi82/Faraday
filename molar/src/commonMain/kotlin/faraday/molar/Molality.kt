package faraday.molar

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Molality, also called molal concentration, is a measure of the concentration of a solute in a solution in terms of amount of substance in a specified amount of mass of the solvent. This contrasts with the definition of molarity which is based on a specified volume of solution.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Molality)
 */
@JvmInline
value class Molality(val molesPerKilogram: Double) : Units<Molality> {
    @InternalUnitApi
    override val rawValue: Double get() = molesPerKilogram

    @InternalUnitApi
    override fun create(value: Double) = Molality(value)
}
