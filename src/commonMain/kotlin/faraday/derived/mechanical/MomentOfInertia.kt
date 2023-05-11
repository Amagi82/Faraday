package faraday.derived.mechanical

import faraday.Units
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
    override fun plus(other: MomentOfInertia) = MomentOfInertia(kilogramMetersPerSecond = kilogramMetersPerSecond + other.kilogramMetersPerSecond)
    override fun minus(other: MomentOfInertia) = MomentOfInertia(kilogramMetersPerSecond = kilogramMetersPerSecond - other.kilogramMetersPerSecond)
    override fun times(factor: Number) = MomentOfInertia(kilogramMetersPerSecond = kilogramMetersPerSecond * factor.toDouble())
    override fun div(factor: Number) = MomentOfInertia(kilogramMetersPerSecond = kilogramMetersPerSecond / factor.toDouble())
    override fun compareTo(other: MomentOfInertia): Int = kilogramMetersPerSecond.compareTo(other.kilogramMetersPerSecond)
}
