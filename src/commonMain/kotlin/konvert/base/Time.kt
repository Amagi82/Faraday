package konvert.base

import konvert.Units

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
 * @see https://en.wikipedia.org/wiki/Time
 * */
inline class Time(val seconds: Double) : Units<Time> {
    override val value: Double get() = seconds
    val nanoseconds: Double get() = seconds / 1e9
    val microseconds: Double get() = seconds / 1e6
    val milliseconds: Double get() = seconds / 1000
    val minutes: Double get() = seconds / MINUTE
    val hours: Double get() = seconds / HOUR
    val days: Double get() = seconds / DAY
    val weeks: Double get() = seconds / WEEK
    val years: Double get() = seconds / GREGORIAN_YEAR // Gregorian
    val siderealYears: Double get() = seconds / SIDEREAL_YEAR

    override fun plus(other: Time): Time = Time(seconds + other.seconds)
    override fun minus(other: Time): Time = Time(seconds - other.seconds)
    override fun times(factor: Number): Time = Time(seconds * factor.toDouble())
    override fun div(factor: Number): Time = Time(seconds / factor.toDouble())

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

val Number.nanoseconds: Time get() = Time(seconds = toDouble() / 1e9)
val Number.microseconds: Time get() = Time(seconds = toDouble() / 1e6)
val Number.milliseconds: Time get() = Time(seconds = toDouble() / 1000)
val Number.seconds: Time get() = Time(seconds = toDouble())
val Number.minutes: Time get() = Time(seconds = toDouble() * Time.MINUTE)
val Number.hours: Time get() = Time(seconds = toDouble() * Time.HOUR)
val Number.days: Time get() = Time(seconds = toDouble() * Time.DAY)
val Number.weeks: Time get() = Time(seconds = toDouble() * Time.WEEK)
val Number.years: Time get() = Time(seconds = toDouble() * Time.GREGORIAN_YEAR)
