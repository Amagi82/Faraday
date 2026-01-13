package faraday.molar

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In the field of biochemistry, the specificity constant (also called kinetic efficiency) is a measure of how efficiently an enzyme converts substrates into products. A comparison of specificity constants can also be used as a measure of the preference of an enzyme for different substrates (i.e., substrate specificity). The higher the specificity constant, the more the enzyme "prefers" that substrate.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Specificity_constant)
 */
@JvmInline
value class KineticEfficiency(val cubicMetersPerMoleSecond: Double) : Units<KineticEfficiency> {
    @InternalUnitApi
    override val rawValue: Double get() = cubicMetersPerMoleSecond

    @InternalUnitApi
    override fun create(value: Double) = KineticEfficiency(value)
}
