package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In photometry, luminous flux or luminous power is the measure of the perceived power of light. It differs from radiant flux, the measure of the total power of electromagnetic radiation (including infrared, ultraviolet, and visible light), in that luminous flux is adjusted to reflect the varying sensitivity of the human eye to different wavelengths of light.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminous_flux)
 */
@JvmInline
value class LuminousFlux(val lumens: Double) : Units<LuminousFlux> {
    @InternalUnitApi
    override val rawValue: Double get() = lumens

    @InternalUnitApi
    override fun create(value: Double) = LuminousFlux(value)
}

val Number.lumens get() = LuminousFlux(toDouble())