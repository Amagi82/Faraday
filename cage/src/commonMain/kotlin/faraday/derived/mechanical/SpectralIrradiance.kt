package faraday.derived.mechanical

import faraday.Units

/**
 * Spectral irradiance is the irradiance of a surface per unit frequency or wavelength, depending on
 * whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Irradiance
 * */
inline class SpectralIrradiance(val wattsPerCubicMeter: Double) : Units<SpectralIrradiance> {
    override fun plus(other: SpectralIrradiance) = SpectralIrradiance(wattsPerCubicMeter = wattsPerCubicMeter + other.wattsPerCubicMeter)
    override fun minus(other: SpectralIrradiance) = SpectralIrradiance(wattsPerCubicMeter = wattsPerCubicMeter - other.wattsPerCubicMeter)
    override fun times(factor: Number) = SpectralIrradiance(wattsPerCubicMeter = wattsPerCubicMeter * factor.toDouble())
    override fun div(factor: Number) = SpectralIrradiance(wattsPerCubicMeter = wattsPerCubicMeter / factor.toDouble())
    override fun compareTo(other: SpectralIrradiance): Int = wattsPerCubicMeter.compareTo(other.wattsPerCubicMeter)
}
