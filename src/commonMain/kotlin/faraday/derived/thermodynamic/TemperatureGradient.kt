package faraday.derived.thermodynamic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * A temperature gradient is a physical quantity that describes in which direction and at what
 * rate the temperature changes the most rapidly around a particular location. The temperature
 * gradient is a dimensional quantity expressed in units of degrees (on a particular temperature
 * scale) per unit length.
 *
 * @see https://en.wikipedia.org/wiki/Temperature_gradient
 * */
@JvmInline
value class TemperatureGradient(val kelvinsPerMeter: Double) : Units<TemperatureGradient> {
    override fun plus(other: TemperatureGradient) = TemperatureGradient(kelvinsPerMeter = kelvinsPerMeter + other.kelvinsPerMeter)
    override fun minus(other: TemperatureGradient) = TemperatureGradient(kelvinsPerMeter = kelvinsPerMeter - other.kelvinsPerMeter)
    override fun times(factor: Number) = TemperatureGradient(kelvinsPerMeter = kelvinsPerMeter * factor.toDouble())
    override fun div(factor: Number) = TemperatureGradient(kelvinsPerMeter = kelvinsPerMeter / factor.toDouble())
    override fun compareTo(other: TemperatureGradient): Int = kelvinsPerMeter.compareTo(other.kelvinsPerMeter)
}
