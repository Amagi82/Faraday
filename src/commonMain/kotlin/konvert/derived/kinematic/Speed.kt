package konvert.derived.kinematic

import konvert.Constants
import konvert.Units
import konvert.base.Distance
import konvert.base.Time

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
inline class Speed(val metersPerSecond: Double) : Units<Speed> {
    override val value: Double get() = metersPerSecond
    val kilometersPerSecond: Double get() = metersPerSecond / 1000
    val kilometersPerHour: Double get() = metersPerSecond / KPH
    val milesPerHour: Double get() = metersPerSecond / MPH
    val knots: Double get() = metersPerSecond / KNOT
    val feetPerSecond: Double get() = metersPerSecond / FOOT_PER_SEC

    override fun plus(other: Speed): Speed = Speed(metersPerSecond + other.metersPerSecond)
    override fun minus(other: Speed): Speed = Speed(metersPerSecond - other.metersPerSecond)
    override fun times(factor: Number): Speed = Speed(metersPerSecond * factor.toDouble())
    override fun div(factor: Number): Speed = Speed(metersPerSecond / factor.toDouble())

    operator fun times(time: Time): Distance = Distance(metersPerSecond * time.seconds)
    operator fun div(acceleration: Acceleration): Time =
        Time(seconds = metersPerSecond / acceleration.metersPerSecondSquared)

    companion object {
        const val KPH = 0.27
        const val MPH = 0.44704
        const val KNOT = 0.514
        const val FOOT_PER_SEC = 0.3048
        const val LIGHT = Constants.LIGHT_SPEED
        val light get() = Speed(LIGHT)
    }
}

val Number.metersPerSecond: Speed get() = Speed(metersPerSecond = toDouble())
val Number.kilometersPerSecond: Speed get() = Speed(metersPerSecond = toDouble() * 1000)
val Number.kilometersPerHour: Speed get() = Speed(metersPerSecond = toDouble() * Speed.KPH)
val Number.milesPerHour: Speed get() = Speed(metersPerSecond = toDouble() * Speed.MPH)
val Number.knots: Speed get() = Speed(metersPerSecond = toDouble() * Speed.KNOT)
val Number.feetPerSecond: Speed get() = Speed(metersPerSecond = toDouble() * Speed.FOOT_PER_SEC)
