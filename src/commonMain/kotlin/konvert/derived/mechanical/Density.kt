package konvert.derived.mechanical

import konvert.Units
import konvert.base.Mass

/**
 * The density (more precisely, the volumetric mass density; also known as specific mass), of a
 * substance is its mass per unit volume. The symbol most often used for density is ρ, although
 * the Latin letter D can also be used. Mathematically, density is defined as mass divided by
 * volume: ρ = m/V where ρ is the density, m is the mass, and V is the volume.
 *
 * @see https://en.wikipedia.org/wiki/Density
 * */
inline class Density(val kgPerCubicMeter: Double) : Units<Density> {
    override val value: Double get() = kgPerCubicMeter
    val gramsPerCubicCentimeter: Double get() = kgPerCubicMeter / 1000
    val kgPerLiter: Double get() = kgPerCubicMeter / 1000
    val gramsPerMilliliter: Double get() = kgPerCubicMeter / 1000
    val metricTonsPerCubicMeter: Double get() = kgPerCubicMeter / 1000

    override fun plus(other: Density): Density = Density(kgPerCubicMeter + other.kgPerCubicMeter)
    override fun minus(other: Density): Density = Density(kgPerCubicMeter - other.kgPerCubicMeter)
    override fun times(factor: Number): Density = Density(kgPerCubicMeter * factor.toDouble())
    override fun div(factor: Number): Density = Density(kgPerCubicMeter / factor.toDouble())

    operator fun times(volume: Volume): Mass = volume * this
    operator fun div(mass: Mass): Volume = mass / this
}
