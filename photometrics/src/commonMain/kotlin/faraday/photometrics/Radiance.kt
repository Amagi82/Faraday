package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In radiometry, radiance is the radiant flux emitted, reflected, transmitted or received by a given surface, per unit solid angle per unit projected area. These are directional quantities. Radiance is used to characterize diffuse emission and reflection of electromagnetic radiation, or to quantify emission of neutrinos and other particles. Historically, radiance is called "intensity" and spectral radiance is called "specific intensity". Many fields still use this nomenclature. It is especially dominant in heat transfer, astrophysics and astronomy. "Intensity" has many other meanings in physics, with the most common being power per unit area.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiance)
 */
@JvmInline
value class Radiance(val wattsPerSteradianSquareMeter: Double) : Units<Radiance> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerSteradianSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = Radiance(value)
}
