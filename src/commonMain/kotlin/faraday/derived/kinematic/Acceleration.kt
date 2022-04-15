package faraday.derived.kinematic

import faraday.Units
import faraday.base.Mass
import faraday.base.Time
import faraday.derived.Force
import kotlin.jvm.JvmInline

/**
 * In mechanics, acceleration is the rate of change of the velocity of an object with respect to
 * time. Accelerations are vector quantities (in that they have magnitude and direction). The
 * orientation of an object's acceleration is given by the orientation of the net force acting on
 * that object. The magnitude of an object's acceleration, as described by Newton's Second Law,
 * is the combined effect of two causes:
 * - the net balance of all external forces acting onto that object — magnitude is directly
 *   proportional to this net resulting force;
 * - that object's mass, depending on the materials out of which it is made — magnitude is
 *   inversely proportional to the object's mass.
 *
 * The SI unit for acceleration is metre per second squared, m/s^2.
 *
 * @see https://en.wikipedia.org/wiki/Acceleration
 * */
@JvmInline
value class Acceleration(val metersPerSecondSquared: Double) : Units<Acceleration> {
    val G get() = metersPerSecondSquared / EARTH_GRAVITY

    override fun plus(other: Acceleration) = Acceleration(metersPerSecondSquared = metersPerSecondSquared + other.metersPerSecondSquared)
    override fun minus(other: Acceleration) = Acceleration(metersPerSecondSquared = metersPerSecondSquared - other.metersPerSecondSquared)
    override fun times(factor: Number) = Acceleration(metersPerSecondSquared = metersPerSecondSquared * factor.toDouble())
    override fun div(factor: Number) = Acceleration(metersPerSecondSquared = metersPerSecondSquared / factor.toDouble())
    override fun compareTo(other: Acceleration): Int = metersPerSecondSquared.compareTo(other.metersPerSecondSquared)

    operator fun times(mass: Mass): Force = mass * this
    operator fun times(time: Time) = Velocity(metersPerSecond = metersPerSecondSquared * time.seconds)
    operator fun div(force: Force): Mass = force / this

    companion object {
        const val EARTH_GRAVITY = 9.807
        val earthGravity = Acceleration(EARTH_GRAVITY)
    }
}
