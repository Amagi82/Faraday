package faraday.derived.mechanical

import faraday.Units

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
    override fun plus(other: Radiance) = Radiance(wattsPerSteradianSquareMeter = wattsPerSteradianSquareMeter + other.wattsPerSteradianSquareMeter)
    override fun minus(other: Radiance) = Radiance(wattsPerSteradianSquareMeter = wattsPerSteradianSquareMeter - other.wattsPerSteradianSquareMeter)
    override fun times(factor: Number) = Radiance(wattsPerSteradianSquareMeter = wattsPerSteradianSquareMeter * factor.toDouble())
    override fun div(factor: Number) = Radiance(wattsPerSteradianSquareMeter = wattsPerSteradianSquareMeter / factor.toDouble())
    override fun compareTo(other: Radiance): Int = wattsPerSteradianSquareMeter.compareTo(other.wattsPerSteradianSquareMeter)
}
