package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Electrical conductivity or specific conductance is the reciprocal of electrical resistivity. It represents a material's ability to conduct electric current. It is commonly signified by the Greek letter σ (sigma), but κ (kappa) (especially in electrical engineering) and γ (gamma) are sometimes used.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Electrical_resistivity_and_conductivity)
 */
@JvmInline
value class ElectricalConductivity(val siemensPerMeter: Double) : Units<ElectricalConductivity> {
    @InternalUnitApi
    override val rawValue: Double get() = siemensPerMeter

    @InternalUnitApi
    override fun create(value: Double) = ElectricalConductivity(value)
}
