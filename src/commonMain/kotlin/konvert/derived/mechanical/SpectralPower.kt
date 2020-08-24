package konvert.derived.mechanical

import konvert.Units

/**
 * In radiometry, radiant flux or radiant power is the radiant energy emitted, reflected,
 * transmitted or received, per unit time, and spectral flux or spectral power is the radiant
 * flux per unit frequency or wavelength, depending on whether the spectrum is taken as a
 * function of frequency or of wavelength.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_flux
 * */
inline class SpectralPower(val wattsPerMeter: Double) : Units<SpectralPower> {
    override val value: Double get() = wattsPerMeter
    override fun plus(other: SpectralPower): SpectralPower = SpectralPower(wattsPerMeter + other.wattsPerMeter)
    override fun minus(other: SpectralPower): SpectralPower = SpectralPower(wattsPerMeter - other.wattsPerMeter)
    override fun times(factor: Number): SpectralPower = SpectralPower(wattsPerMeter * factor.toDouble())
    override fun div(factor: Number): SpectralPower = SpectralPower(wattsPerMeter / factor.toDouble())
}
