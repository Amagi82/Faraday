package konvert.derived.mechanical

import konvert.Units

/**
 * In Newtonian mechanics, linear momentum, translational momentum, or simply momentum
 * (pl. momenta) is the product of the mass and velocity of an object. It is a vector
 * quantity, possessing a magnitude and a direction. If m is an object's mass and v is
 * its velocity (also a vector quantity), then the object's momentum is: p = mv
 *
 * @see https://en.wikipedia.org/wiki/Momentum
 * */
inline class Momentum(val newtonSeconds: Double) : Units<Momentum> {
    override val value: Double get() = newtonSeconds
    override fun plus(other: Momentum): Momentum = Momentum(newtonSeconds + other.newtonSeconds)
    override fun minus(other: Momentum): Momentum = Momentum(newtonSeconds - other.newtonSeconds)
    override fun times(factor: Number): Momentum = Momentum(newtonSeconds * factor.toDouble())
    override fun div(factor: Number): Momentum = Momentum(newtonSeconds / factor.toDouble())
}
typealias Impulse = Momentum
