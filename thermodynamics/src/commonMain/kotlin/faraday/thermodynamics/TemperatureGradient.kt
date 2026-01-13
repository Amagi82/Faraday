package faraday.thermodynamics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * A temperature gradient is a physical quantity that describes in which direction and at what rate the temperature changes the most rapidly around a particular location. The temperature gradient is a dimensional quantity expressed in units of degrees (on a particular temperature scale) per unit length.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Temperature_gradient)
 */
@JvmInline
value class TemperatureGradient(val kelvinsPerMeter: Double) : Units<TemperatureGradient> {
    @InternalUnitApi
    override val rawValue: Double get() = kelvinsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = TemperatureGradient(value)
}
