package faraday.derived.kinematic

import faraday.Constants
import faraday.Prefixes
import faraday.Units
import faraday.base.Distance
import faraday.base.Mass
import faraday.base.Time
import faraday.derived.mechanical.Momentum

/**
 * In everyday use and in kinematics, the speed of an object is the magnitude of the change of its
 * position; it is thus a scalar quantity. The average speed of an object in an interval of time is
 * the distance travelled by the object divided by the duration of the interval; the instantaneous
 * speed is the limit of the average speed as the duration of the time interval approaches zero.
 *
 * Speed has the dimensions of distance divided by time. The SI unit of speed is the metre per second,
 * but the most common unit of speed in everyday usage is the kilometre per hour or, in the US and the
 * UK, miles per hour. For air and marine travel the knot is commonly used.
 *
 * The fastest possible speed at which energy or information can travel, according to special
 * relativity, is the speed of light in a vacuum c = 299792458 metres per second. Matter cannot quite
 * reach the speed of light, as this would require an infinite amount of energy. In relativity physics,
 * the concept of rapidity replaces the classical idea of speed.
 *
 * @see https://en.wikipedia.org/wiki/Speed
 * */
inline class Velocity(val metersPerSecond: Double) : Units<Velocity> {
    val kilometersPerSecond get() = metersPerSecond / Prefixes.KILO
    val kilometersPerHour get() = metersPerSecond / KPH
    val milesPerHour get() = metersPerSecond / MPH
    val knots get() = metersPerSecond / KNOT
    val feetPerSecond get() = metersPerSecond / FOOT_PER_SEC

    override fun plus(other: Velocity) = Velocity(metersPerSecond = metersPerSecond + other.metersPerSecond)
    override fun minus(other: Velocity) = Velocity(metersPerSecond = metersPerSecond - other.metersPerSecond)
    override fun times(factor: Number) = Velocity(metersPerSecond = metersPerSecond * factor.toDouble())
    override fun div(factor: Number) = Velocity(metersPerSecond = metersPerSecond / factor.toDouble())
    override fun compareTo(other: Velocity): Int = metersPerSecond.compareTo(other.metersPerSecond)

    operator fun times(time: Time) = Distance(meters = metersPerSecond * time.seconds)
    operator fun times(mass: Mass): Momentum = mass * this
    operator fun div(acceleration: Acceleration) = Time(seconds = metersPerSecond / acceleration.metersPerSecondSquared)

    companion object {
        const val KPH = 0.27
        const val MPH = 0.44704
        const val KNOT = 0.514
        const val FOOT_PER_SEC = 0.3048
        const val LIGHT = Constants.LIGHT_SPEED
        val light get() = Velocity(LIGHT)
    }
}

typealias Speed = Velocity

val Number.metersPerSecond get() = Velocity(metersPerSecond = toDouble())
val Number.kilometersPerSecond get() = Velocity(metersPerSecond = toDouble() * Prefixes.KILO)
val Number.kilometersPerHour get() = Velocity(metersPerSecond = toDouble() * Velocity.KPH)
val Number.milesPerHour get() = Velocity(metersPerSecond = toDouble() * Velocity.MPH)
val Number.knots get() = Velocity(metersPerSecond = toDouble() * Velocity.KNOT)
val Number.feetPerSecond get() = Velocity(metersPerSecond = toDouble() * Velocity.FOOT_PER_SEC)
