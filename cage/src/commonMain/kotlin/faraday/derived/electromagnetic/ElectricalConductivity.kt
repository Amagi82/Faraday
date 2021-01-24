package faraday.derived.electromagnetic

import faraday.Units

/**
 * Electrical conductivity or specific conductance is the reciprocal of electrical resistivity.
 * It represents a material's ability to conduct electric current. It is commonly signified by
 * the Greek letter σ (sigma), but κ (kappa) (especially in electrical engineering) and γ
 * (gamma) are sometimes used.
 *
 * @see https://en.wikipedia.org/wiki/Electrical_resistivity_and_conductivity
 * */
inline class ElectricalConductivity(val siemensPerMeter: Double) : Units<ElectricalConductivity> {
    override fun plus(other: ElectricalConductivity) = ElectricalConductivity(siemensPerMeter = siemensPerMeter + other.siemensPerMeter)
    override fun minus(other: ElectricalConductivity) = ElectricalConductivity(siemensPerMeter = siemensPerMeter - other.siemensPerMeter)
    override fun times(factor: Number) = ElectricalConductivity(siemensPerMeter = siemensPerMeter * factor.toDouble())
    override fun div(factor: Number) = ElectricalConductivity(siemensPerMeter = siemensPerMeter / factor.toDouble())
    override fun compareTo(other: ElectricalConductivity): Int = siemensPerMeter.compareTo(other.siemensPerMeter)
}
