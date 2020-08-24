package konvert.derived.electromagnetic

import konvert.Units

/**
 * An electric field surrounds an electric charge, and exerts force on other charges in the field,
 * attracting or repelling them. Electric fields are created by electric charges, or by time-
 * varying magnetic fields. Electric fields and magnetic fields are both manifestations of the
 * electromagnetic force, one of the four fundamental forces (or interactions) of nature.
 *
 * @see https://en.wikipedia.org/wiki/Electric_field
 * */
inline class ElectricFieldStrength(val voltsPerMeter: Double) : Units<ElectricFieldStrength> {
    override val value: Double get() = voltsPerMeter
    override fun plus(other: ElectricFieldStrength): ElectricFieldStrength = ElectricFieldStrength(voltsPerMeter + other.voltsPerMeter)
    override fun minus(other: ElectricFieldStrength): ElectricFieldStrength = ElectricFieldStrength(voltsPerMeter - other.voltsPerMeter)
    override fun times(factor: Number): ElectricFieldStrength = ElectricFieldStrength(voltsPerMeter * factor.toDouble())
    override fun div(factor: Number): ElectricFieldStrength = ElectricFieldStrength(voltsPerMeter / factor.toDouble())
}
