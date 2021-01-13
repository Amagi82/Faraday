package faraday.derived.mechanical

import faraday.Units

/**
 * In radiometry, radiant flux or radiant power is the radiant energy emitted, reflected,
 * transmitted or received, per unit time, and spectral flux or spectral power is the radiant
 * flux per unit frequency or wavelength, depending on whether the spectrum is taken as a
 * function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_flux
 * */
inline class SpectralPower(val wattsPerMeter: Double) : Units<SpectralPower> {
    override fun plus(other: SpectralPower) = SpectralPower(wattsPerMeter = wattsPerMeter + other.wattsPerMeter)
    override fun minus(other: SpectralPower) = SpectralPower(wattsPerMeter = wattsPerMeter - other.wattsPerMeter)
    override fun times(factor: Number) = SpectralPower(wattsPerMeter = wattsPerMeter * factor.toDouble())
    override fun div(factor: Number) = SpectralPower(wattsPerMeter = wattsPerMeter / factor.toDouble())
    override fun compareTo(other: SpectralPower): Int = wattsPerMeter.compareTo(other.wattsPerMeter)
}
