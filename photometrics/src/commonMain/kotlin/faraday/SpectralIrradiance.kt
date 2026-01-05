package faraday

import kotlin.jvm.JvmInline

/**
 * Spectral irradiance is the irradiance of a surface per unit frequency or wavelength, depending on
 * whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Irradiance)
 */
@JvmInline
value class SpectralIrradiance(val wattsPerCubicMeter: Double) : Units<SpectralIrradiance> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerCubicMeter

    @InternalUnitApi
    override fun create(value: Double) = SpectralIrradiance(value)
}
