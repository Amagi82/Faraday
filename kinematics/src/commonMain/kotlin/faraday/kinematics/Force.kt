package faraday.kinematics

import faraday.InternalUnitApi
import faraday.Units
import faraday.core.Mass
import kotlin.jvm.JvmInline

/**
 * In physics, a force is any interaction that, when unopposed, will change the motion of an object. A force can cause an object with mass to change its velocity (which includes to begin moving from a state of rest), i.e., to accelerate. Force can also be described intuitively as a push or a pull. A force has both magnitude and direction, making it a vector quantity. It is measured in the SI unit of newtons and represented by the symbol F.
 *
 * The original form of Newton's second law states that the net force acting upon an object is equal to the rate at which its momentum changes with time. If the mass of the object is constant, this law implies that the acceleration of an object is directly proportional to the net force acting on the object, is in the direction of the net force, and is inversely proportional to the mass of the object.
 *
 * Concepts related to force include: thrust, which increases the velocity of an object; drag, which decreases the velocity of an object; and torque, which produces changes in rotational speed of an object. In an extended body, each part usually applies forces on the adjacent parts; the distribution of such forces through the body is the internal faraday.derived.mechanical stress. Such internal faraday.derived.mechanical stresses cause no acceleration of that body as the forces balance one another. Pressure, the distribution of many small forces applied over an area of a body, is a simple type of stress that if unbalanced can cause the body to accelerate. Stress usually causes deformation of solid materials, or flow in fluids.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Force)
 */
@JvmInline
value class Force(val newtons: Double) : Units<Force> {
    val lbs get() = newtons / POUND

    @InternalUnitApi
    override val rawValue: Double get() = newtons

    @InternalUnitApi
    override fun create(value: Double) = Force(value)

    companion object {
        const val POUND = Mass.POUND * Acceleration.EARTH_GRAVITY
    }
}

val Number.newtons get() = Force(newtons = toDouble())
val Number.poundsF get() = Force(newtons = toDouble() * Force.POUND)

typealias Weight = Force
