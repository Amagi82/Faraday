package faraday

import kotlin.jvm.JvmInline

/**
 * The moment of inertia, otherwise known as the mass moment of inertia, angular mass or rotational
 * inertia, of a rigid body is a quantity that determines the torque needed for a desired angular
 * acceleration about a rotational axis; similar to how mass determines the force needed for a
 * desired acceleration. It depends on the body's mass distribution and the axis chosen, with larger
 * moments requiring more torque to change the body's rate of rotation.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Moment_of_inertia)
 */
@JvmInline
value class MomentOfInertia(val kilogramMetersPerSecond: Double) : Units<MomentOfInertia> {
    @InternalUnitApi
    override val rawValue: Double get() = kilogramMetersPerSecond

    @InternalUnitApi
    override fun create(value: Double) = MomentOfInertia(value)
}
