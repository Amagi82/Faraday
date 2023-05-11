package faraday.derived.mechanical

import faraday.Units
import faraday.base.Mass
import kotlin.jvm.JvmInline

/**
 * The density (more precisely, the volumetric mass density; also known as specific mass), of a
 * substance is its mass per unit volume. The symbol most often used for density is ρ, although
 * the Latin letter D can also be used. Mathematically, density is defined as mass divided by
 * volume: ρ = m/V where ρ is the density, m is the mass, and V is the volume.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Density)
 */
@JvmInline
value class Density(val kgPerCubicMeter: Double) : Units<Density> {
    val gramsPerCubicCentimeter get() = kgPerCubicMeter / 1000
    val kgPerLiter get() = kgPerCubicMeter / 1000
    val gramsPerMilliliter get() = kgPerCubicMeter / 1000
    val metricTonsPerCubicMeter get() = kgPerCubicMeter / 1000

    override fun plus(other: Density) = Density(kgPerCubicMeter = kgPerCubicMeter + other.kgPerCubicMeter)
    override fun minus(other: Density) = Density(kgPerCubicMeter = kgPerCubicMeter - other.kgPerCubicMeter)
    override fun times(factor: Number) = Density(kgPerCubicMeter = kgPerCubicMeter * factor.toDouble())
    override fun div(factor: Number) = Density(kgPerCubicMeter = kgPerCubicMeter / factor.toDouble())
    override fun compareTo(other: Density): Int = kgPerCubicMeter.compareTo(other.kgPerCubicMeter)

    operator fun times(volume: Volume): Mass = volume * this
    operator fun div(mass: Mass): Volume = mass / this
}

val Number.kgPerCubicMeter get() = Density(kgPerCubicMeter = toDouble())
val Number.gramsPerCubicCentimeter get() = Density(kgPerCubicMeter = toDouble() * 1000)
