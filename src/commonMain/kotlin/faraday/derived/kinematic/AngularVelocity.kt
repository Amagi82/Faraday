package faraday.derived.kinematic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics, angular velocity refers to how fast an object rotates or revolves relative
 * to another point, i.e. how fast the angular position or orientation of an object changes
 * with time. There are two types of angular velocity: orbital angular velocity and spin
 * angular velocity. Spin angular velocity refers to how fast a rigid body rotates with
 * respect to its centre of rotation. Orbital angular velocity refers to how fast a point
 * object revolves about a fixed origin, i.e. the time rate of change of its angular
 * position relative to the origin. Spin angular velocity is independent of the choice of
 * origin, in contrast to orbital angular velocity which depends on the choice of origin.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Angular_velocity)
 */
@JvmInline
value class AngularVelocity(val radiansPerSecond: Double) : Units<AngularVelocity> {
    override fun plus(other: AngularVelocity) = AngularVelocity(radiansPerSecond = radiansPerSecond + other.radiansPerSecond)
    override fun minus(other: AngularVelocity) = AngularVelocity(radiansPerSecond = radiansPerSecond - other.radiansPerSecond)
    override fun times(factor: Number) = AngularVelocity(radiansPerSecond = radiansPerSecond * factor.toDouble())
    override fun div(factor: Number) = AngularVelocity(radiansPerSecond = radiansPerSecond / factor.toDouble())
    override fun compareTo(other: AngularVelocity): Int = radiansPerSecond.compareTo(other.radiansPerSecond)
}
