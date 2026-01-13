package faraday.kinematics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In Newtonian mechanics, linear momentum, translational momentum, or simply momentum (pl. momenta) is the product of the mass and velocity of an object. It is a vector quantity, possessing a magnitude and a direction. If m is an object's mass and v is its velocity (also a vector quantity), then the object's momentum is: p = mv
 *
 * [Wiki](https://en.wikipedia.org/wiki/Momentum)
 */
@JvmInline
value class Momentum(val newtonSeconds: Double) : Units<Momentum> {
    @InternalUnitApi
    override val rawValue: Double get() = newtonSeconds

    @InternalUnitApi
    override fun create(value: Double) = Momentum(value)
}

typealias Impulse = Momentum
