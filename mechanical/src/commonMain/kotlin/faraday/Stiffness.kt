package faraday

import kotlin.jvm.JvmInline

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Stiffness)
 */
@JvmInline
value class Stiffness(val newtonsPerMeter: Double) : Units<Stiffness> {
    @InternalUnitApi
    override val rawValue: Double get() = newtonsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = Stiffness(value)
}