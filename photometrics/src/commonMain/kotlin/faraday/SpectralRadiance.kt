package faraday

import kotlin.jvm.JvmInline

/**
 * Spectral radiance is the radiance of a surface per unit frequency or wavelength, depending
 * on whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiance)
 */
@JvmInline
value class SpectralRadiance(val wattsPerSteradianCubicMeter: Double) : Units<SpectralRadiance> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerSteradianCubicMeter

    @InternalUnitApi
    override fun create(value: Double) = SpectralRadiance(value)
}
