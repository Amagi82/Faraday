package faraday.mechanical

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Stiffness)
 */
@JvmInline
value class RotationalStiffness(val newtonMetersPerRadian: Double) : Units<RotationalStiffness> {
    @InternalUnitApi
    override val rawValue: Double get() = newtonMetersPerRadian

    @InternalUnitApi
    override fun create(value: Double) = RotationalStiffness(value)
}
