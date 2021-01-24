package faraday.derived.photometric

import faraday.Units
import faraday.base.Time
import faraday.derived.LuminousFlux
import kotlin.jvm.JvmInline

/**
 * In photometry, luminous energy is the perceived energy of light. This is sometimes called the
 * quantity of light. Luminous energy is not the same as radiant energy, the corresponding
 * objective physical quantity. This is because the human eye can only see light in the visible
 * spectrum and has different sensitivities to light of different wavelengths within the spectrum.
 * When adapted for bright conditions (photopic vision), the eye is most sensitive to light at a
 * wavelength of 555 nm. Light with a given amount of radiant energy will have more luminous energy
 * if the wavelength is 555 nm than if the wavelength is longer or shorter. Light whose wavelength
 * is well outside the visible spectrum has a luminous energy of zero, regardless of the amount of
 * radiant energy present.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminous_energy)
 */
@JvmInline
value class LuminousEnergy(val lumenSeconds: Double) : Units<LuminousEnergy> {
    override fun plus(other: LuminousEnergy): LuminousEnergy = LuminousEnergy(lumenSeconds + other.lumenSeconds)
    override fun minus(other: LuminousEnergy): LuminousEnergy = LuminousEnergy(lumenSeconds - other.lumenSeconds)
    override fun times(factor: Number): LuminousEnergy = LuminousEnergy(lumenSeconds * factor.toDouble())
    override fun div(factor: Number): LuminousEnergy = LuminousEnergy(lumenSeconds / factor.toDouble())
    override fun compareTo(other: LuminousEnergy): Int = lumenSeconds.compareTo(other.lumenSeconds)

    operator fun div(time: Time) = LuminousFlux(lumenSeconds / time.seconds)
    operator fun div(flux: LuminousFlux) = Time(lumenSeconds / flux.lumens)
}
