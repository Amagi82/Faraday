package faraday.derived.kinematic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics, angular acceleration refers to the time rate of change of angular velocity.
 * As there are two types of angular velocity, namely spin angular velocity and orbital
 * angular velocity, there are naturally also two types of angular acceleration, called
 * spin angular acceleration and orbital angular acceleration respectively. Spin angular
 * acceleration refers to the angular acceleration of a rigid body about its centre of
 * rotation, and orbital angular acceleration refers to the angular acceleration of a point
 * particle about a fixed origin.
 *
 * @see https://en.wikipedia.org/wiki/Angular_acceleration
 * */
@JvmInline
value class AngularAcceleration(val radiansPerSecondSquared: Double) : Units<AngularAcceleration> {
    override fun plus(other: AngularAcceleration) = AngularAcceleration(radiansPerSecondSquared = radiansPerSecondSquared + other.radiansPerSecondSquared)
    override fun minus(other: AngularAcceleration) = AngularAcceleration(radiansPerSecondSquared = radiansPerSecondSquared - other.radiansPerSecondSquared)
    override fun times(factor: Number) = AngularAcceleration(radiansPerSecondSquared = radiansPerSecondSquared * factor.toDouble())
    override fun div(factor: Number) = AngularAcceleration(radiansPerSecondSquared = radiansPerSecondSquared / factor.toDouble())
    override fun compareTo(other: AngularAcceleration): Int = radiansPerSecondSquared.compareTo(other.radiansPerSecondSquared)
}
