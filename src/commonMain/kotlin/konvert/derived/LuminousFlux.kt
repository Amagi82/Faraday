package konvert.derived

import konvert.Units

/**
 * In photometry, luminous flux or luminous power is the measure of the perceived power of
 * light. It differs from radiant flux, the measure of the total power of electromagnetic
 * radiation (including infrared, ultraviolet, and visible light), in that luminous flux
 * is adjusted to reflect the varying sensitivity of the human eye to different wavelengths
 * of light.
 *
 * @see https://en.wikipedia.org/wiki/Luminous_flux
 * */
inline class LuminousFlux(val lumens: Double) : Units<LuminousFlux> {
    override val value: Double get() = lumens
    override fun plus(other: LuminousFlux): LuminousFlux = LuminousFlux(lumens + other.lumens)
    override fun minus(other: LuminousFlux): LuminousFlux = LuminousFlux(lumens - other.lumens)
    override fun times(factor: Number): LuminousFlux = LuminousFlux(lumens * factor.toDouble())
    override fun div(factor: Number): LuminousFlux = LuminousFlux(lumens / factor.toDouble())
}

val Number.lumens: LuminousFlux get() = LuminousFlux(toDouble())
