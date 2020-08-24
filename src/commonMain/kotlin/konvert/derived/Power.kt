package konvert.derived

import konvert.Units
import konvert.base.Distance
import konvert.base.Mass
import konvert.base.Time

/**
 * In physics, power is the amount of energy transferred or converted per unit time. In the International
 * System of Units, the unit of power is the watt, equal to one joule per second. In older works, power
 * is sometimes called activity. Power is a scalar quantity.
 *
 * The output power of a motor is the product of the torque that the motor generates and the angular
 * velocity of its output shaft. The power involved in moving a ground vehicle is the product of the
 * traction force on the wheels and the velocity of the vehicle. The power of a jet-propelled vehicle is
 * the product of the engine thrust and the velocity of the vehicle. The rate at which a light bulb
 * converts electrical energy into light and heat is measured in watts—the electrical energy used per
 * unit time.
 *
 * Electric power is the rate, per unit time, at which electrical energy is transferred by an electric
 * circuit. The SI unit of power is the watt, one joule per second.
 *
 * @see https://en.wikipedia.org/wiki/Power_(physics)
 * @see https://en.wikipedia.org/wiki/Electric_power
 * */
inline class Power(val watts: Double) : Units<Power> {
    override val value: Double get() = watts
    val kilowatts: Double get() = watts / 1000
    val btusPerSecond: Double get() = watts / 1.05505585262e3
    val btusPerMinute: Double get() = btusPerSecond / Time.MINUTE
    val btusPerHour: Double get() = btusPerSecond / Time.HOUR
    val horsepower: Double get() = watts / HORSEPOWER

    override fun plus(other: Power): Power = Power(watts + other.watts)
    override fun minus(other: Power): Power = Power(watts - other.watts)
    override fun times(factor: Number): Power = Power(watts * factor.toDouble())
    override fun div(factor: Number): Power = Power(watts / factor.toDouble())

    companion object {
        // Mechanical horsepower
        const val HORSEPOWER = 550 * Distance.FOOT * Weight.POUND
    }
}
typealias RadiantFlux = Power

val Number.watts: Power get() = Power(watts = toDouble())
val Number.kilowatts: Power get() = Power(watts = toDouble() * 1000)
val Number.horsepower: Power get() = Power(watts = toDouble() * Power.HORSEPOWER)
