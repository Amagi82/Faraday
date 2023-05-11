package faraday.derived.mechanical

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Spectral intensity is the radiant intensity per unit frequency or wavelength, depending on whether
 * the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Radiant_intensity)
 */
@JvmInline
value class SpectralIntensity(val wattsPerSteradianMeter: Double) : Units<SpectralIntensity> {
    override fun plus(other: SpectralIntensity) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter + other.wattsPerSteradianMeter)
    override fun minus(other: SpectralIntensity) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter - other.wattsPerSteradianMeter)
    override fun times(factor: Number) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter * factor.toDouble())
    override fun div(factor: Number) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter / factor.toDouble())
    override fun compareTo(other: SpectralIntensity): Int = wattsPerSteradianMeter.compareTo(other.wattsPerSteradianMeter)
}
