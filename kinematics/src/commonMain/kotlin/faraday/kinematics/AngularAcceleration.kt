package faraday.kinematics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics, angular acceleration refers to the time rate of change of angular velocity. As there are two types of angular velocity, namely spin angular velocity and orbital angular velocity, there are naturally also two types of angular acceleration, called spin angular acceleration and orbital angular acceleration respectively. Spin angular acceleration refers to the angular acceleration of a rigid body about its center of rotation, and orbital angular acceleration refers to the angular acceleration of a point particle about a fixed origin.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Angular_acceleration)
 */
@JvmInline
value class AngularAcceleration(val radiansPerSecondSquared: Double) : Units<AngularAcceleration> {
    @InternalUnitApi
    override val rawValue: Double get() = radiansPerSecondSquared

    @InternalUnitApi
    override fun create(value: Double) = AngularAcceleration(value)
}
