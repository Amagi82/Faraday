package faraday.derived.mechanical

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Energy flux is the rate of transfer of energy through a surface.
 *
 * @see https://en.wikipedia.org/wiki/Energy_flux
 * */
@JvmInline
value class EnergyFluxDensity(val joulesPerSquareMeterSecond: Double) : Units<EnergyFluxDensity> {
    override fun plus(other: EnergyFluxDensity) = EnergyFluxDensity(joulesPerSquareMeterSecond = joulesPerSquareMeterSecond + other.joulesPerSquareMeterSecond)
    override fun minus(other: EnergyFluxDensity) = EnergyFluxDensity(joulesPerSquareMeterSecond = joulesPerSquareMeterSecond - other.joulesPerSquareMeterSecond)
    override fun times(factor: Number) = EnergyFluxDensity(joulesPerSquareMeterSecond = joulesPerSquareMeterSecond * factor.toDouble())
    override fun div(factor: Number) = EnergyFluxDensity(joulesPerSquareMeterSecond = joulesPerSquareMeterSecond / factor.toDouble())
    override fun compareTo(other: EnergyFluxDensity): Int = joulesPerSquareMeterSecond.compareTo(other.joulesPerSquareMeterSecond)
}
