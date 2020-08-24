package konvert.derived.mechanical

import konvert.Units

/**
 * In radiometry, radiant exposure or fluence is the radiant energy received by a surface per unit
 * area, or equivalently the irradiance of a surface, integrated over time of irradiation, and
 * spectral exposure is the radiant exposure per unit frequency or wavelength, depending on whether
 * the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_exposure
 * */
inline class RadiantExposure(val joulesPerSquareMeter: Double) : Units<RadiantExposure> {
    override val value: Double get() = joulesPerSquareMeter
    override fun plus(other: RadiantExposure): RadiantExposure = RadiantExposure(joulesPerSquareMeter + other.joulesPerSquareMeter)
    override fun minus(other: RadiantExposure): RadiantExposure = RadiantExposure(joulesPerSquareMeter - other.joulesPerSquareMeter)
    override fun times(factor: Number): RadiantExposure = RadiantExposure(joulesPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): RadiantExposure = RadiantExposure(joulesPerSquareMeter / factor.toDouble())
}
