package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * An electric field surrounds an electric charge, and exerts force on other charges in the field,
 * attracting or repelling them. Electric fields are created by electric charges, or by time-
 * varying magnetic fields. Electric fields and magnetic fields are both manifestations of the
 * electromagnetic force, one of the four fundamental forces (or interactions) of nature.
 *
 * @see https://en.wikipedia.org/wiki/Electric_field
 * */
@JvmInline
value class ElectricFieldStrength(val voltsPerMeter: Double) : Units<ElectricFieldStrength> {
    override fun plus(other: ElectricFieldStrength) = ElectricFieldStrength(voltsPerMeter = voltsPerMeter + other.voltsPerMeter)
    override fun minus(other: ElectricFieldStrength) = ElectricFieldStrength(voltsPerMeter = voltsPerMeter - other.voltsPerMeter)
    override fun times(factor: Number) = ElectricFieldStrength(voltsPerMeter = voltsPerMeter * factor.toDouble())
    override fun div(factor: Number) = ElectricFieldStrength(voltsPerMeter = voltsPerMeter / factor.toDouble())
    override fun compareTo(other: ElectricFieldStrength): Int = voltsPerMeter.compareTo(other.voltsPerMeter)
}
