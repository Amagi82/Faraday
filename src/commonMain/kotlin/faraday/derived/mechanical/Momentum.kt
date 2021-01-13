package faraday.derived.mechanical

import faraday.Units
import faraday.base.Mass
import faraday.derived.kinematic.Velocity

/**
 * In Newtonian mechanics, linear momentum, translational momentum, or simply momentum
 * (pl. momenta) is the product of the mass and velocity of an object. It is a vector
 * quantity, possessing a magnitude and a direction. If m is an object's mass and v is
 * its velocity (also a vector quantity), then the object's momentum is: p = mv
 *
 * @see https://en.wikipedia.org/wiki/Momentum
 * */
inline class Momentum(val newtonSeconds: Double) : Units<Momentum> {
    override fun plus(other: Momentum) = Momentum(newtonSeconds = newtonSeconds + other.newtonSeconds)
    override fun minus(other: Momentum) = Momentum(newtonSeconds = newtonSeconds - other.newtonSeconds)
    override fun times(factor: Number) = Momentum(newtonSeconds = newtonSeconds * factor.toDouble())
    override fun div(factor: Number) = Momentum(newtonSeconds = newtonSeconds / factor.toDouble())
    override fun compareTo(other: Momentum): Int = newtonSeconds.compareTo(other.newtonSeconds)

    operator fun div(velocity: Velocity) = Mass(kilograms = newtonSeconds / velocity.metersPerSecond)
    operator fun div(mass: Mass) = Velocity(metersPerSecond = newtonSeconds / mass.kilograms)
}

typealias Impulse = Momentum
