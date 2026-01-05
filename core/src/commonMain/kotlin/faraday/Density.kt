package faraday

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

    @InternalUnitApi
    override val rawValue: Double get() = kgPerCubicMeter

    @InternalUnitApi
    override fun create(value: Double) = Density(value)
}

val Number.kgPerCubicMeter get() = Density(kgPerCubicMeter = toDouble())
val Number.gramsPerCubicCentimeter get() = Density(kgPerCubicMeter = toDouble() * 1000)
