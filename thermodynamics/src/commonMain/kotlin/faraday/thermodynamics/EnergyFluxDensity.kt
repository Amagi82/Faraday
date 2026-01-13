package faraday.thermodynamics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Energy flux is the rate of transfer of energy through a surface.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Energy_flux)
 */
@JvmInline
value class EnergyFluxDensity(val joulesPerSquareMeterSecond: Double) : Units<EnergyFluxDensity> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerSquareMeterSecond

    @InternalUnitApi
    override fun create(value: Double) = EnergyFluxDensity(value)
}