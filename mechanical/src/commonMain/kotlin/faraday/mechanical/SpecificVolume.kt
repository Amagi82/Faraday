package faraday.mechanical

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In thermodynamics, the specific volume of a substance is the ratio of the substance's volume to its mass. It is the reciprocal of density and an intrinsic property of matter as well. Specific volume is defined as the number of cubic meters occupied by one kilogram of a particular substance.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Specific_volume)
 */
@JvmInline
value class SpecificVolume(val cubicMetersPerKilogram: Double) : Units<SpecificVolume> {
    @InternalUnitApi
    override val rawValue: Double get() = cubicMetersPerKilogram

    @InternalUnitApi
    override fun create(value: Double) = SpecificVolume(value)
}
