package konvert.derived.mechanical

import konvert.Units

/**
 * In radiometry, radiance is the radiant flux emitted, reflected, transmitted or received by a given
 * surface, per unit solid angle per unit projected area. These are directional quantities. Radiance
 * is used to characterize diffuse emission and reflection of electromagnetic radiation, or to quantify
 * emission of neutrinos and other particles. Historically, radiance is called "intensity" and spectral
 * radiance is called "specific intensity". Many fields still use this nomenclature. It is especially
 * dominant in heat transfer, astrophysics and astronomy. "Intensity" has many other meanings in
 * physics, with the most common being power per unit area.
 *
 * @see https://en.wikipedia.org/wiki/Radiance
 * */
inline class Radiance(val wattsPerSteradianSquareMeter: Double) : Units<Radiance> {
    override val value: Double get() = wattsPerSteradianSquareMeter
    override fun plus(other: Radiance): Radiance = Radiance(wattsPerSteradianSquareMeter + other.wattsPerSteradianSquareMeter)
    override fun minus(other: Radiance): Radiance = Radiance(wattsPerSteradianSquareMeter - other.wattsPerSteradianSquareMeter)
    override fun times(factor: Number): Radiance = Radiance(wattsPerSteradianSquareMeter * factor.toDouble())
    override fun div(factor: Number): Radiance = Radiance(wattsPerSteradianSquareMeter / factor.toDouble())
}
