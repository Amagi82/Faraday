package konvert.derived.mechanical

import konvert.Units

/**
 * Energy flux is the rate of transfer of energy through a surface.
 *
 * @see https://en.wikipedia.org/wiki/Energy_flux
 * */
inline class EnergyFluxDensity(val joulesPerSquareMeterSecond: Double) : Units<EnergyFluxDensity> {
    override val value: Double get() = joulesPerSquareMeterSecond
    override fun plus(other: EnergyFluxDensity): EnergyFluxDensity = EnergyFluxDensity(joulesPerSquareMeterSecond + other.joulesPerSquareMeterSecond)
    override fun minus(other: EnergyFluxDensity): EnergyFluxDensity = EnergyFluxDensity(joulesPerSquareMeterSecond - other.joulesPerSquareMeterSecond)
    override fun times(factor: Number): EnergyFluxDensity = EnergyFluxDensity(joulesPerSquareMeterSecond * factor.toDouble())
    override fun div(factor: Number): EnergyFluxDensity = EnergyFluxDensity(joulesPerSquareMeterSecond / factor.toDouble())
}
