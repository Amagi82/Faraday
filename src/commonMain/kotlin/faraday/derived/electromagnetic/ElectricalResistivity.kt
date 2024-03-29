package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Electrical resistivity (also called specific electrical resistance or volume resistivity) and its
 * inverse, electrical conductivity, is a fundamental property of a material that quantifies how
 * strongly it resists or conducts electric current. A low resistivity indicates a material that
 * readily allows electric current. Resistivity is commonly represented by the Greek letter ρ (rho).
 * The SI unit of electrical resistivity is the ohm-meter (Ω⋅m). For example, if a 1m × 1m × 1m
 * solid cube of material has sheet contacts on two opposite faces, and the resistance between these
 * contacts is 1Ω, then the resistivity of the material is 1 Ω⋅m.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Electrical_resistivity_and_conductivity)
 */
@JvmInline
value class ElectricalResistivity(val ohmMeters: Double) : Units<ElectricalResistivity> {
    override fun plus(other: ElectricalResistivity) = ElectricalResistivity(ohmMeters = ohmMeters + other.ohmMeters)
    override fun minus(other: ElectricalResistivity) = ElectricalResistivity(ohmMeters = ohmMeters - other.ohmMeters)
    override fun times(factor: Number) = ElectricalResistivity(ohmMeters = ohmMeters * factor.toDouble())
    override fun div(factor: Number) = ElectricalResistivity(ohmMeters = ohmMeters / factor.toDouble())
    override fun compareTo(other: ElectricalResistivity): Int = ohmMeters.compareTo(other.ohmMeters)
}
