package faraday.derived.thermodynamic

import faraday.Prefixes
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Thermal expansion is the tendency of matter to increase in length, area, or volume, changing
 * its size and density, in response to an increase in temperature (usually excluding phase
 * transitions). In simple words, the change in size of a body due to heating is called thermal
 * expansion. Substances usually contract with decreasing temperature (thermal contraction),
 * with rare exceptions within limited temperature ranges (negative thermal expansion).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Thermal_expansion)
 */
@JvmInline
value class ThermalExpansion(val inverseKelvin: Double) : Units<ThermalExpansion> {
    val micrometersPerMeterPerDeltaK: Double get() = inverseKelvin / Prefixes.MICRO
    override fun plus(other: ThermalExpansion) = ThermalExpansion(inverseKelvin = inverseKelvin + other.inverseKelvin)
    override fun minus(other: ThermalExpansion) = ThermalExpansion(inverseKelvin = inverseKelvin - other.inverseKelvin)
    override fun times(factor: Number) = ThermalExpansion(inverseKelvin = inverseKelvin * factor.toDouble())
    override fun div(factor: Number) = ThermalExpansion(inverseKelvin = inverseKelvin / factor.toDouble())
    override fun compareTo(other: ThermalExpansion): Int = inverseKelvin.compareTo(other.inverseKelvin)
}
