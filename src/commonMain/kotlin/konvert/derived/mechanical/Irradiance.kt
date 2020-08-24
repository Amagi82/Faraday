package konvert.derived.mechanical

import konvert.Units

/**
 * In radiometry, irradiance is the radiant flux (power) received by a surface per unit area.
 * Irradiance is often called intensity, but this term is avoided in radiometry where such
 * usage leads to confusion with radiant intensity. In astrophysics, irradiance is called
 * radiant flux.
 *
 * @see https://en.wikipedia.org/wiki/Irradiance
 * */
inline class Irradiance(val wattsPerSquareMeter: Double) : Units<Irradiance> {
    override val value: Double get() = wattsPerSquareMeter
    override fun plus(other: Irradiance): Irradiance = Irradiance(wattsPerSquareMeter + other.wattsPerSquareMeter)
    override fun minus(other: Irradiance): Irradiance = Irradiance(wattsPerSquareMeter - other.wattsPerSquareMeter)
    override fun times(factor: Number): Irradiance = Irradiance(wattsPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): Irradiance = Irradiance(wattsPerSquareMeter / factor.toDouble())
}
typealias HeatFluxDensity = Irradiance
