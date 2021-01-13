package faraday.base

import faraday.Units

/**
 * Temperature is a physical property of matter that quantitatively expresses hot and cold. It
 * is the manifestation of thermal energy, present in all matter, which is the source of the
 * occurrence of heat, a flow of energy, when a body is in contact with another that is colder.
 *
 * Temperature is measured with a thermometer. Thermometers are calibrated in various temperature
 * scales that historically have used various reference points and thermometric substances for
 * definition. The most common scales are the Celsius scale (formerly called centigrade, denoted
 * °C), the Fahrenheit scale (denoted °F), and the Kelvin scale (denoted K), the last of which
 * is predominantly used for scientific purposes by conventions of the International System of
 * Units (SI).
 *
 * @see https://en.wikipedia.org/wiki/Temperature
 * */
inline class Temperature(val kelvin: Double) : Units<Temperature> {
    val celsius get() = kelvin + KELVIN_TO_CELSIUS
    val fahrenheit get() = celsius * 1.8 + 32

    override fun plus(other: Temperature) = Temperature(kelvin = kelvin + other.kelvin)
    override fun minus(other: Temperature) = Temperature(kelvin = kelvin - other.kelvin)
    override fun times(factor: Number) = Temperature(kelvin = kelvin * factor.toDouble())
    override fun div(factor: Number) = Temperature(kelvin = kelvin / factor.toDouble())
    override fun compareTo(other: Temperature): Int = kelvin.compareTo(other.kelvin)

    companion object {
        const val KELVIN_TO_CELSIUS = 273.15
    }
}

val Number.kelvin get() = Temperature(kelvin = toDouble()).validate()
val Number.celsius get() = Temperature(kelvin = toDouble() - Temperature.KELVIN_TO_CELSIUS).validate()
val Number.fahrenheit get() = Temperature(kelvin = (toDouble() + 459.67) / 1.8).validate()

//TODO: Inline classes will permit init blocks as of v1.4.30, so this can be moved inside at that time
private fun Temperature.validate(): Temperature {
    if (kelvin < 0) throw IllegalStateException("Temperature cannot be below absolute zero")
    return this
}
