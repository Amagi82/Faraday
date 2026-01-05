package faraday

import kotlin.jvm.JvmInline

/**
 * In radiometry, radiant exposure or fluence is the radiant energy received by a surface per unit
 * area, or equivalently the irradiance of a surface, integrated over time of irradiation, and
 * spectral exposure is the radiant exposure per unit frequency or wavelength, depending on whether
 * the spectrum is taken as a function of frequency or of wavelength.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiant_exposure)
 */
@JvmInline
value class RadiantExposure(val joulesPerSquareMeter: Double) : Units<RadiantExposure> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = RadiantExposure(value)
}
