package faraday

import kotlin.jvm.JvmInline

/**
 * Torque is the rotational equivalent of linear force. It is also referred to as the moment,
 * moment of force, rotational force or turning effect, depending on the field of study. The
 * concept originated with the studies by Archimedes of the usage of levers. Just as a linear
 * force is a push or a pull, a torque can be thought of as a twist to an object around a
 * specific axis. Another definition of torque is the product of the magnitude of the force
 * and the perpendicular distance of the line of action of force from the axis of rotation.
 * The symbol for torque is typically τ, the lowercase Greek letter tau. When being referred
 * to as moment of force, it is commonly denoted by M.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Torque)
 */
@JvmInline
value class Torque(val newtonMeters: Double) : Units<Torque> {
    val poundFeet get() = newtonMeters / POUND_FOOT
    val inchPound get() = newtonMeters / INCH_POUND

    @InternalUnitApi
    override val rawValue: Double get() = newtonMeters

    @InternalUnitApi
    override fun create(value: Double) = Torque(value)

    companion object {
        const val POUND_FOOT = Force.POUND * Distance.FOOT
        const val INCH_POUND = POUND_FOOT / 12
    }
}

val Number.newtonMeters get() = Torque(newtonMeters = toDouble())
val Number.poundFeet get() = Torque(newtonMeters = toDouble() * Torque.POUND_FOOT)
val Number.inchPounds get() = Torque(newtonMeters = toDouble() * Torque.INCH_POUND)