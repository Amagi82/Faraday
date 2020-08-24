package konvert.derived.mechanical

import konvert.Units

/**
 * Spectral radiance is the radiance of a surface per unit frequency or wavelength, depending
 * on whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Radiance
 * */
inline class SpectralRadiance(val wattsPerSteradianCubicMeter: Double) : Units<SpectralRadiance> {
    override val value: Double get() = wattsPerSteradianCubicMeter
    override fun plus(other: SpectralRadiance): SpectralRadiance = SpectralRadiance(wattsPerSteradianCubicMeter + other.wattsPerSteradianCubicMeter)
    override fun minus(other: SpectralRadiance): SpectralRadiance = SpectralRadiance(wattsPerSteradianCubicMeter - other.wattsPerSteradianCubicMeter)
    override fun times(factor: Number): SpectralRadiance = SpectralRadiance(wattsPerSteradianCubicMeter * factor.toDouble())
    override fun div(factor: Number): SpectralRadiance = SpectralRadiance(wattsPerSteradianCubicMeter / factor.toDouble())
}
