package konvert.derived.photometric

import konvert.Units

/**
 * Luminance is a photometric measure of the luminous intensity per unit area of light travelling
 * in a given direction. It describes the amount of light that passes through, is emitted from, or
 * is reflected from a particular area, and falls within a given solid angle.
 *
 * @see https://en.wikipedia.org/wiki/Luminance
 * */
inline class Luminance(val candelasPerSquareMeter: Double) : Units<Luminance> {
    override val value: Double get() = candelasPerSquareMeter
    override fun plus(other: Luminance): Luminance = Luminance(candelasPerSquareMeter + other.candelasPerSquareMeter)
    override fun minus(other: Luminance): Luminance = Luminance(candelasPerSquareMeter - other.candelasPerSquareMeter)
    override fun times(factor: Number): Luminance = Luminance(candelasPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): Luminance = Luminance(candelasPerSquareMeter / factor.toDouble())
}
