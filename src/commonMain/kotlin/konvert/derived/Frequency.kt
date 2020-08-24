package konvert.derived

import konvert.Units

/**
 * Frequency is the number of occurrences of a repeating event per unit of time. It is also
 * referred to as temporal frequency, which emphasizes the contrast to spatial frequency and
 * angular frequency. Frequency is measured in units of hertz (Hz) which is equal to one
 * occurrence of a repeating event per second. The period is the duration of time of one cycle
 * in a repeating event, so the period is the reciprocal of the frequency. For example: if a
 * newborn baby's heart beats at a frequency of 120 times a minute (2 hertz), its period, T,
 * — the time interval between beats—is half a second (60 seconds divided by 120 beats).
 * Frequency is an important parameter used in science and engineering to specify the rate
 * of oscillatory and vibratory phenomena, such as mechanical vibrations, audio signals
 * (sound), radio waves, and light.
 *
 * @see https://en.wikipedia.org/wiki/Frequency
 * */
inline class Frequency(val hertz: Double) : Units<Frequency> {
    override val value: Double get() = hertz
    override fun plus(other: Frequency): Frequency = Frequency(hertz + other.hertz)
    override fun minus(other: Frequency): Frequency = Frequency(hertz - other.hertz)
    override fun times(factor: Number): Frequency = Frequency(hertz * factor.toDouble())
    override fun div(factor: Number): Frequency = Frequency(hertz / factor.toDouble())
}

val Number.hertz: Frequency get() = Frequency(toDouble())
