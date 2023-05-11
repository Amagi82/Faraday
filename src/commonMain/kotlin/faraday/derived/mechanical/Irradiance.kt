package faraday.derived.mechanical

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In radiometry, irradiance is the radiant flux (power) received by a surface per unit area.
 * Irradiance is often called intensity, but this term is avoided in radiometry where such
 * usage leads to confusion with radiant intensity. In astrophysics, irradiance is called
 * radiant flux.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Irradiance)
 */
@JvmInline
value class Irradiance(val wattsPerSquareMeter: Double) : Units<Irradiance> {
    override fun plus(other: Irradiance) = Irradiance(wattsPerSquareMeter = wattsPerSquareMeter + other.wattsPerSquareMeter)
    override fun minus(other: Irradiance) = Irradiance(wattsPerSquareMeter = wattsPerSquareMeter - other.wattsPerSquareMeter)
    override fun times(factor: Number) = Irradiance(wattsPerSquareMeter = wattsPerSquareMeter * factor.toDouble())
    override fun div(factor: Number) = Irradiance(wattsPerSquareMeter = wattsPerSquareMeter / factor.toDouble())
    override fun compareTo(other: Irradiance): Int = wattsPerSquareMeter.compareTo(other.wattsPerSquareMeter)
}
typealias HeatFluxDensity = Irradiance
