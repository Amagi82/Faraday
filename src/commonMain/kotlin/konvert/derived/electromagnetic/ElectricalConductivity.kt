package konvert.derived.electromagnetic

import konvert.Units

/**
 * Electrical conductivity or specific conductance is the reciprocal of electrical resistivity.
 * It represents a material's ability to conduct electric current. It is commonly signified by
 * the Greek letter σ (sigma), but κ (kappa) (especially in electrical engineering) and γ
 * (gamma) are sometimes used.
 *
 * @see https://en.wikipedia.org/wiki/Electrical_resistivity_and_conductivity
 * */
inline class ElectricalConductivity(val siemensPerMeter: Double) : Units<ElectricalConductivity> {
    override val value: Double get() = siemensPerMeter
    override fun plus(other: ElectricalConductivity): ElectricalConductivity = ElectricalConductivity(siemensPerMeter + other.siemensPerMeter)
    override fun minus(other: ElectricalConductivity): ElectricalConductivity = ElectricalConductivity(siemensPerMeter - other.siemensPerMeter)
    override fun times(factor: Number): ElectricalConductivity = ElectricalConductivity(siemensPerMeter * factor.toDouble())
    override fun div(factor: Number): ElectricalConductivity = ElectricalConductivity(siemensPerMeter / factor.toDouble())
}
