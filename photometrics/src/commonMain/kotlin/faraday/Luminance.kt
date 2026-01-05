package faraday

import kotlin.jvm.JvmInline

/**
 * Luminance is a photometric measure of the luminous intensity per unit area of light travelling
 * in a given direction. It describes the amount of light that passes through, is emitted from, or
 * is reflected from a particular area, and falls within a given solid angle.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminance)
 */
@JvmInline
value class Luminance(val candelasPerSquareMeter: Double) : Units<Luminance> {
    @InternalUnitApi
    override val rawValue: Double get() = candelasPerSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = Luminance(value)
}
