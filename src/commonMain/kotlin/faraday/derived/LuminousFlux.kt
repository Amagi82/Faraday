package faraday.derived

import faraday.Units
import faraday.base.LuminousIntensity
import faraday.base.Time
import faraday.derived.mechanical.Area
import faraday.derived.photometric.LuminousEfficacy
import faraday.derived.photometric.LuminousEnergy
import kotlin.jvm.JvmInline

/**
 * In photometry, luminous flux or luminous power is the measure of the perceived power of
 * light. It differs from radiant flux, the measure of the total power of electromagnetic
 * radiation (including infrared, ultraviolet, and visible light), in that luminous flux
 * is adjusted to reflect the varying sensitivity of the human eye to different wavelengths
 * of light.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminous_flux)
 */
@JvmInline
value class LuminousFlux(val lumens: Double) : Units<LuminousFlux> {
    override fun plus(other: LuminousFlux) = LuminousFlux(lumens = lumens + other.lumens)
    override fun minus(other: LuminousFlux) = LuminousFlux(lumens = lumens - other.lumens)
    override fun times(factor: Number) = LuminousFlux(lumens = lumens * factor.toDouble())
    override fun div(factor: Number) = LuminousFlux(lumens = lumens / factor.toDouble())
    override fun compareTo(other: LuminousFlux): Int = lumens.compareTo(other.lumens)

    operator fun times(time: Time) = LuminousEnergy(lumenSeconds = lumens * time.seconds)
    operator fun div(intensity: LuminousIntensity) = SolidAngle(steradians = lumens / intensity.candelas)
    operator fun div(angle: SolidAngle) = LuminousIntensity(candelas = lumens / angle.steradians)
    operator fun div(area: Area) = Illuminance(lux = lumens / area.squareMeters)
    operator fun div(flux: RadiantFlux) = LuminousEfficacy(lumensPerWatt = lumens / flux.watts)
}

val Number.lumens get() = LuminousFlux(toDouble())
