package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In radiometry, radiant flux or radiant power is the radiant energy emitted, reflected, transmitted or received, per unit time, and spectral flux or spectral power is the radiant flux per unit frequency or wavelength, depending on whether the spectrum is taken as a function of frequency or of wavelength.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiant_flux)
 */
@JvmInline
value class SpectralPower(val wattsPerMeter: Double) : Units<SpectralPower> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = SpectralPower(value)
}
