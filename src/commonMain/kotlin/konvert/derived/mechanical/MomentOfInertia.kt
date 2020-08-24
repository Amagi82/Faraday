package konvert.derived.mechanical

import konvert.Units

/**
 * The moment of inertia, otherwise known as the mass moment of inertia, angular mass or rotational
 * inertia, of a rigid body is a quantity that determines the torque needed for a desired angular
 * acceleration about a rotational axis; similar to how mass determines the force needed for a
 * desired acceleration. It depends on the body's mass distribution and the axis chosen, with larger
 * moments requiring more torque to change the body's rate of rotation.
 *
 * @see https://en.wikipedia.org/wiki/Moment_of_inertia
 * */
inline class MomentOfInertia(val kilogramMetersPerSecond: Double) : Units<MomentOfInertia> {
    override val value: Double get() = kilogramMetersPerSecond
    override fun plus(other: MomentOfInertia): MomentOfInertia = MomentOfInertia(kilogramMetersPerSecond + other.kilogramMetersPerSecond)
    override fun minus(other: MomentOfInertia): MomentOfInertia = MomentOfInertia(kilogramMetersPerSecond - other.kilogramMetersPerSecond)
    override fun times(factor: Number): MomentOfInertia = MomentOfInertia(kilogramMetersPerSecond * factor.toDouble())
    override fun div(factor: Number): MomentOfInertia = MomentOfInertia(kilogramMetersPerSecond / factor.toDouble())
}
