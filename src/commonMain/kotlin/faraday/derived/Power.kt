package faraday.derived

import faraday.Prefixes
import faraday.Units
import faraday.base.Distance
import faraday.base.ElectricCurrent
import faraday.base.Time

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
    val milliwatts get() = watts / Prefixes.MILLI
    val kilowatts get() = watts / Prefixes.KILO
    val megawatts get() = watts / Prefixes.MEGA
    val gigawatts get() = watts / Prefixes.GIGA
    val terawatts get() = watts / Prefixes.TERA

    val btusPerSecond get() = watts / 1.05505585262e3
    val btusPerMinute get() = btusPerSecond / Time.MINUTE
    val btusPerHour get() = btusPerSecond / Time.HOUR
    val horsepower get() = watts / HORSEPOWER

    override fun plus(other: Power) = Power(watts = watts + other.watts)
    override fun minus(other: Power) = Power(watts = watts - other.watts)
    override fun times(factor: Number) = Power(watts = watts * factor.toDouble())
    override fun div(factor: Number) = Power(watts = watts / factor.toDouble())
    override fun compareTo(other: Power): Int = watts.compareTo(other.watts)

    operator fun times(time: Time) = Energy(joules = watts * time.seconds)
    operator fun div(current: ElectricCurrent) = Voltage(volts = watts / current.amperes)
    operator fun div(voltage: Voltage) = ElectricCurrent(amperes = watts / voltage.volts)

    companion object {
        // Mechanical horsepower
        const val HORSEPOWER = 550 * Distance.FOOT * Weight.POUND
    }
}
typealias RadiantFlux = Power

val Number.milliwatts get() = Power(watts = toDouble() * Prefixes.MILLI)
val Number.watts get() = Power(watts = toDouble())
val Number.kilowatts get() = Power(watts = toDouble() * Prefixes.KILO)
val Number.megawatts get() = Power(watts = toDouble() * Prefixes.MEGA)
val Number.gigawatts get() = Power(watts = toDouble() * Prefixes.GIGA)
val Number.terawatts get() = Power(watts = toDouble() * Prefixes.TERA)

val Number.horsepower get() = Power(watts = toDouble() * Power.HORSEPOWER)
