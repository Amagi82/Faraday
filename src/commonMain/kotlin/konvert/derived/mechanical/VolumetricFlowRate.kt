package konvert.derived.mechanical

import konvert.Units
import konvert.base.Time

/**
 * In physics and engineering, in particular fluid dynamics, the volumetric flow rate
 * (also known as volume flow rate, rate of fluid flow, or volume velocity) is the
 * volume of fluid which passes per unit time.
 *
 * @see https://en.wikipedia.org/wiki/Volumetric_flow_rate
 * */
inline class VolumetricFlowRate(val cubicMetersPerSecond: Double) : Units<VolumetricFlowRate> {
    override val value: Double get() = cubicFeetPerSecond
    val litersPerMinute: Double get() = cubicMetersPerSecond / (1000 / Time.MINUTE)
    val cubicFeetPerMinute: Double get() = cubicMetersPerSecond / (Volume.CUBIC_FOOT / Time.MINUTE)
    val cubicFeetPerSecond: Double get() = cubicMetersPerSecond / Volume.CUBIC_FOOT
    val gallonsPerMinute: Double get() = cubicMetersPerSecond / (Volume.GALLON_US / Time.MINUTE)

    override fun plus(other: VolumetricFlowRate): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond + other.cubicMetersPerSecond)
    override fun minus(other: VolumetricFlowRate): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond - other.cubicMetersPerSecond)
    override fun times(factor: Number): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond * factor.toDouble())
    override fun div(factor: Number): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond / factor.toDouble())
}
