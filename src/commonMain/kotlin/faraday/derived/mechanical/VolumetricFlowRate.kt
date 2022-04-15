package faraday.derived.mechanical

import faraday.Units
import faraday.base.Time
import kotlin.jvm.JvmInline

/**
 * In physics and engineering, in particular fluid dynamics, the volumetric flow rate
 * (also known as volume flow rate, rate of fluid flow, or volume velocity) is the
 * volume of fluid which passes per unit time.
 *
 * @see https://en.wikipedia.org/wiki/Volumetric_flow_rate
 * */
@JvmInline
value class VolumetricFlowRate(val cubicMetersPerSecond: Double) : Units<VolumetricFlowRate> {
    val litersPerMinute get() = cubicMetersPerSecond / (1000 / Time.MINUTE)
    val cubicFeetPerMinute get() = cubicMetersPerSecond / (Volume.CUBIC_FOOT / Time.MINUTE)
    val cubicFeetPerSecond get() = cubicMetersPerSecond / Volume.CUBIC_FOOT
    val gallonsPerMinute get() = cubicMetersPerSecond / (Volume.GALLON_US / Time.MINUTE)

    override fun plus(other: VolumetricFlowRate) = VolumetricFlowRate(cubicMetersPerSecond = cubicMetersPerSecond + other.cubicMetersPerSecond)
    override fun minus(other: VolumetricFlowRate) = VolumetricFlowRate(cubicMetersPerSecond = cubicMetersPerSecond - other.cubicMetersPerSecond)
    override fun times(factor: Number) = VolumetricFlowRate(cubicMetersPerSecond = cubicMetersPerSecond * factor.toDouble())
    override fun div(factor: Number) = VolumetricFlowRate(cubicMetersPerSecond = cubicMetersPerSecond / factor.toDouble())
    override fun compareTo(other: VolumetricFlowRate): Int = cubicFeetPerSecond.compareTo(other.cubicFeetPerSecond)
}
