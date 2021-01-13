package faraday.derived.mechanical

import faraday.Units

/**
 * Spectral intensity is the radiant intensity per unit frequency or wavelength, depending on whether
 * the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_intensity
 * */
inline class SpectralIntensity(val wattsPerSteradianMeter: Double) : Units<SpectralIntensity> {
    override fun plus(other: SpectralIntensity) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter + other.wattsPerSteradianMeter)
    override fun minus(other: SpectralIntensity) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter - other.wattsPerSteradianMeter)
    override fun times(factor: Number) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter * factor.toDouble())
    override fun div(factor: Number) = SpectralIntensity(wattsPerSteradianMeter = wattsPerSteradianMeter / factor.toDouble())
    override fun compareTo(other: SpectralIntensity): Int = wattsPerSteradianMeter.compareTo(other.wattsPerSteradianMeter)
}
