package faraday.kinematics

import faraday.InternalUnitApi
import faraday.Prefixes
import faraday.Units
import faraday.core.Distance
import faraday.core.Time
import kotlin.jvm.JvmInline

/**
 * In physics, power is the amount of energy transferred or converted per unit time. In the International System of Units, the unit of power is the watt, equal to one joule per second. In older works, power is sometimes called activity. Power is a scalar quantity.
 *
 * The output power of a motor is the product of the torque that the motor generates and the angular velocity of its output shaft. The power involved in moving a ground vehicle is the product of the traction force on the wheels and the velocity of the vehicle. The power of a jet-propelled vehicle is the product of the engine thrust and the velocity of the vehicle. The rate at which a light bulb converts electrical energy into light and heat is measured in watts—the electrical energy used per unit time.
 *
 * Electric power is the rate, per unit time, at which electrical energy is transferred by an electric circuit. The SI unit of power is the watt, one joule per second.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Power_(physics)
 * [Wiki](https://en.wikipedia.org/wiki/Electric_power)
 */
@JvmInline
value class Power(val watts: Double) : Units<Power> {
    val milliwatts get() = watts / Prefixes.MILLI
    val kilowatts get() = watts / Prefixes.KILO
    val megawatts get() = watts / Prefixes.MEGA
    val gigawatts get() = watts / Prefixes.GIGA
    val terawatts get() = watts / Prefixes.TERA

    val btusPerSecond get() = watts / 1.05505585262e3
    val btusPerMinute get() = btusPerSecond / Time.MINUTE
    val btusPerHour get() = btusPerSecond / Time.HOUR
    val horsepower get() = watts / MECHANICAL_HORSEPOWER
    val metricHorsepower get() = watts / METRIC_HORSEPOWER
    val ps get() = metricHorsepower

    @InternalUnitApi
    override val rawValue: Double get() = watts

    @InternalUnitApi
    override fun create(value: Double) = Power(value)

    companion object {
        const val MECHANICAL_HORSEPOWER = 550 * Distance.FOOT * Weight.POUND
        const val METRIC_HORSEPOWER = 75 * Acceleration.EARTH_GRAVITY
    }
}
typealias RadiantFlux = Power

val Number.milliwatts get() = Power(watts = toDouble() * Prefixes.MILLI)
val Number.watts get() = Power(watts = toDouble())
val Number.kilowatts get() = Power(watts = toDouble() * Prefixes.KILO)
val Number.megawatts get() = Power(watts = toDouble() * Prefixes.MEGA)
val Number.gigawatts get() = Power(watts = toDouble() * Prefixes.GIGA)
val Number.terawatts get() = Power(watts = toDouble() * Prefixes.TERA)

val Number.horsepower get() = Power(watts = toDouble() * Power.MECHANICAL_HORSEPOWER)
val Number.metricHorsepower get() = Power(watts = toDouble() * Power.METRIC_HORSEPOWER)
