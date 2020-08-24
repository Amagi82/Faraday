package konvert.derived.mechanical

import konvert.Units

/**
 * Spectral irradiance is the irradiance of a surface per unit frequency or wavelength, depending on
 * whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Irradiance
 * */
inline class SpectralIrradiance(val wattsPerCubicMeter: Double) : Units<SpectralIrradiance> {
    override val value: Double get() = wattsPerCubicMeter
    override fun plus(other: SpectralIrradiance): SpectralIrradiance = SpectralIrradiance(wattsPerCubicMeter + other.wattsPerCubicMeter)
    override fun minus(other: SpectralIrradiance): SpectralIrradiance = SpectralIrradiance(wattsPerCubicMeter - other.wattsPerCubicMeter)
    override fun times(factor: Number): SpectralIrradiance = SpectralIrradiance(wattsPerCubicMeter * factor.toDouble())
    override fun div(factor: Number): SpectralIrradiance = SpectralIrradiance(wattsPerCubicMeter / factor.toDouble())
}
