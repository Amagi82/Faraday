package faraday

import kotlin.jvm.JvmInline

/**
 * In physics and engineering, in particular fluid dynamics, the volumetric flow rate
 * (also known as volume flow rate, rate of fluid flow, or volume velocity) is the
 * volume of fluid which passes per unit time.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Volumetric_flow_rate)
 */
@JvmInline
value class VolumetricFlowRate(val cubicMetersPerSecond: Double) : Units<VolumetricFlowRate> {
    val litersPerMinute get() = cubicMetersPerSecond / (1000 / Time.MINUTE)
    val cubicFeetPerMinute get() = cubicMetersPerSecond / (Volume.CUBIC_FOOT / Time.MINUTE)
    val cubicFeetPerSecond get() = cubicMetersPerSecond / Volume.CUBIC_FOOT
    val gallonsPerMinute get() = cubicMetersPerSecond / (Volume.GALLON_US / Time.MINUTE)

    @InternalUnitApi
    override val rawValue: Double get() = cubicMetersPerSecond

    @InternalUnitApi
    override fun create(value: Double) = VolumetricFlowRate(value)
}
