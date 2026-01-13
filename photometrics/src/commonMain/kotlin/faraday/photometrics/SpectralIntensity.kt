package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Spectral intensity is the radiant intensity per unit frequency or wavelength, depending on whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiant_intensity)
 */
@JvmInline
value class SpectralIntensity(val wattsPerSteradianMeter: Double) : Units<SpectralIntensity> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerSteradianMeter

    @InternalUnitApi
    override fun create(value: Double) = SpectralIntensity(value)
}
