package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In photometry, luminous intensity is a measure of the wavelength-weighted power emitted by a light source in a particular direction per unit solid angle, based on the luminosity function, a standardized model of the sensitivity of the human eye. The SI unit of luminous intensity is the candela (cd), an SI base unit.
 *
 * Photometry deals with the measurement of visible light as perceived by human eyes. The human eye can only see light in the visible spectrum and has different sensitivities to light of different wavelengths within the spectrum. When adapted for bright conditions (photopic vision), the eye is most sensitive to greenish-yellow light at 555 nm. Light with the same radiant intensity at other wavelengths has a lower luminous intensity. The curve which measures the response of the human eye to light is a defined standard, known as the luminosity function. This curve, denoted V(λ), is based on an average of widely differing experimental data from scientists using different measurement techniques.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminous_intensity)
 */
@JvmInline
value class LuminousIntensity(val candelas: Double) : Units<LuminousIntensity> {
    @InternalUnitApi
    override val rawValue: Double get() = candelas

    @InternalUnitApi
    override fun create(value: Double) = LuminousIntensity(value)
}

val Number.candelas get() = LuminousIntensity(candelas = toDouble())
