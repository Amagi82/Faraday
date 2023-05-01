package faraday.derived.mechanical

import faraday.Units
import faraday.derived.Angle
import kotlin.jvm.JvmInline

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * @see https://en.wikipedia.org/wiki/Stiffness
 * */
@JvmInline
value class RotationalStiffness(val newtonMetersPerRadian: Double) : Units<RotationalStiffness> {
    override fun plus(other: RotationalStiffness) = RotationalStiffness(newtonMetersPerRadian = newtonMetersPerRadian + other.newtonMetersPerRadian)
    override fun minus(other: RotationalStiffness) = RotationalStiffness(newtonMetersPerRadian = newtonMetersPerRadian - other.newtonMetersPerRadian)
    override fun times(factor: Number) = RotationalStiffness(newtonMetersPerRadian = newtonMetersPerRadian * factor.toDouble())
    override fun div(factor: Number) = RotationalStiffness(newtonMetersPerRadian = newtonMetersPerRadian / factor.toDouble())
    override fun compareTo(other: RotationalStiffness): Int = newtonMetersPerRadian.compareTo(other.newtonMetersPerRadian)

    operator fun times(angle: Angle) = Torque(newtonMeters = newtonMetersPerRadian * angle.radians)
}
