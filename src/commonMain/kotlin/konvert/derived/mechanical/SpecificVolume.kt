package konvert.derived.mechanical

import konvert.Units

/**
 * In thermodynamics, the specific volume of a substance is the ratio of the substance's volume to
 * its mass. It is the reciprocal of density and an intrinsic property of matter as well. Specific
 * volume is defined as the number of cubic meters occupied by one kilogram of a particular substance.
 *
 * @see https://en.wikipedia.org/wiki/Specific_volume
 * */
inline class SpecificVolume(val cubicMetersPerKilogram: Double) : Units<SpecificVolume> {
    override val value: Double get() = cubicMetersPerKilogram
    override fun plus(other: SpecificVolume): SpecificVolume = SpecificVolume(cubicMetersPerKilogram + other.cubicMetersPerKilogram)
    override fun minus(other: SpecificVolume): SpecificVolume = SpecificVolume(cubicMetersPerKilogram - other.cubicMetersPerKilogram)
    override fun times(factor: Number): SpecificVolume = SpecificVolume(cubicMetersPerKilogram * factor.toDouble())
    override fun div(factor: Number): SpecificVolume = SpecificVolume(cubicMetersPerKilogram / factor.toDouble())
}
