package konvert.derived.thermodynamic

import konvert.Units

/**
 * A temperature gradient is a physical quantity that describes in which direction and at what
 * rate the temperature changes the most rapidly around a particular location. The temperature
 * gradient is a dimensional quantity expressed in units of degrees (on a particular temperature
 * scale) per unit length.
 *
 * @see https://en.wikipedia.org/wiki/Temperature_gradient
 * */
inline class TemperatureGradient(val kelvinsPerMeter: Double) : Units<TemperatureGradient> {
    override val value: Double get() = kelvinsPerMeter
    override fun plus(other: TemperatureGradient): TemperatureGradient = TemperatureGradient(kelvinsPerMeter + other.kelvinsPerMeter)
    override fun minus(other: TemperatureGradient): TemperatureGradient = TemperatureGradient(kelvinsPerMeter - other.kelvinsPerMeter)
    override fun times(factor: Number): TemperatureGradient = TemperatureGradient(kelvinsPerMeter * factor.toDouble())
    override fun div(factor: Number): TemperatureGradient = TemperatureGradient(kelvinsPerMeter / factor.toDouble())
}
