package faraday.base

import faraday.Prefixes
import faraday.Units
import faraday.derived.*
import faraday.derived.kinematic.Velocity
import faraday.derived.photometric.LuminousEnergy
import faraday.derived.photometric.LuminousExposure
import kotlin.jvm.JvmInline

/**
 * Time is the indefinite continued progress of existence and events that occur in an apparently
 * irreversible succession from the past, through the present, into the future. It is a component
 * quantity of various measurements used to sequence events, to compare the duration of events or
 * the intervals between them, and to quantify rates of change of quantities in material reality
 * or in the conscious experience. Time is often referred to as a fourth dimension, along with
 * three spatial dimensions.
 *
 * Time in physics is operationally defined as "what a clock reads". Time is one of the seven
 * fundamental physical quantities in both the International System of Units (SI) and International
 * System of Quantities. The SI base unit of time is the second. Time is used to define other
 * quantities – such as velocity – so defining time in terms of such quantities would result in
 * circularity of definition. An operational definition of time, wherein one says that observing
 * a certain number of repetitions of one or another standard cyclical event (such as the passage
 * of a free-swinging pendulum) constitutes one standard unit such as the second, is highly useful
 * in the conduct of both advanced experiments and everyday affairs of life. To describe
 * observations of an event, a location (position in space) and time are typically noted.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Time)
 */
@JvmInline
value class Time(val seconds: Double) : Units<Time> {
    val nanoseconds get() = seconds / Prefixes.NANO
    val microseconds get() = seconds / Prefixes.MICRO
    val milliseconds get() = seconds / Prefixes.MILLI
    val minutes get() = seconds / MINUTE
    val hours get() = seconds / HOUR
    val days get() = seconds / DAY
    val weeks get() = seconds / WEEK
    val years get() = seconds / GREGORIAN_YEAR // Gregorian
    val siderealYears get() = seconds / SIDEREAL_YEAR

    override fun plus(other: Time) = Time(seconds = seconds + other.seconds)
    override fun minus(other: Time) = Time(seconds = seconds - other.seconds)
    override fun times(factor: Number) = Time(seconds = seconds * factor.toDouble())
    override fun div(factor: Number) = Time(seconds = seconds / factor.toDouble())
    override fun compareTo(other: Time): Int = seconds.compareTo(other.seconds)

    operator fun times(velocity: Velocity): Distance = velocity * this
    operator fun times(power: Power): Energy = power * this
    operator fun times(current: ElectricCurrent): ElectricCharge = current * this
    operator fun times(catalysis: Catalysis): ChemicalAmount = catalysis * this
    operator fun times(flux: LuminousFlux): LuminousEnergy = flux * this
    operator fun times(illuminance: Illuminance): LuminousExposure = illuminance * this
    operator fun times(resistance: ElectricResistance): ElectricInductance = resistance * this
    operator fun times(voltage: Voltage): MagneticFlux = voltage * this
    operator fun div(capacitance: ElectricCapacitance) = ElectricResistance(ohms = seconds / capacitance.farads)
    operator fun div(resistance: ElectricResistance) = ElectricCapacitance(farads = seconds / resistance.ohms)

    companion object {
        const val MINUTE = 60.0
        const val HOUR = MINUTE * 60
        const val DAY = HOUR * 24
        const val WEEK = DAY * 7
        const val GREGORIAN_YEAR = DAY * 365.2425
        const val JULIAN_YEAR = DAY * 365.25
        const val SIDEREAL_YEAR = DAY * 365.256363004
    }
}

val Number.nanoseconds get() = Time(seconds = toDouble() * Prefixes.NANO)
val Number.microseconds get() = Time(seconds = toDouble() * Prefixes.MICRO)
val Number.milliseconds get() = Time(seconds = toDouble() * Prefixes.MILLI)
val Number.seconds get() = Time(seconds = toDouble())
val Number.minutes get() = Time(seconds = toDouble() * Time.MINUTE)
val Number.hours get() = Time(seconds = toDouble() * Time.HOUR)
val Number.days get() = Time(seconds = toDouble() * Time.DAY)
val Number.weeks get() = Time(seconds = toDouble() * Time.WEEK)
val Number.years get() = Time(seconds = toDouble() * Time.GREGORIAN_YEAR)
