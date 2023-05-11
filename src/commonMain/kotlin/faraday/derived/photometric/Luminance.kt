package faraday.derived.photometric

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Luminance is a photometric measure of the luminous intensity per unit area of light travelling
 * in a given direction. It describes the amount of light that passes through, is emitted from, or
 * is reflected from a particular area, and falls within a given solid angle.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Luminance)
 */
@JvmInline
value class Luminance(val candelasPerSquareMeter: Double) : Units<Luminance> {
    override fun plus(other: Luminance): Luminance = Luminance(candelasPerSquareMeter + other.candelasPerSquareMeter)
    override fun minus(other: Luminance): Luminance = Luminance(candelasPerSquareMeter - other.candelasPerSquareMeter)
    override fun times(factor: Number): Luminance = Luminance(candelasPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): Luminance = Luminance(candelasPerSquareMeter / factor.toDouble())
    override fun compareTo(other: Luminance): Int = candelasPerSquareMeter.compareTo(other.candelasPerSquareMeter)
}
