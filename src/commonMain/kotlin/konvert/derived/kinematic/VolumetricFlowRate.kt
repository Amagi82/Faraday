package konvert.derived.kinematic

import konvert.Units
import konvert.base.Time
import konvert.derived.mechanical.Volume

/**
 * In physics and engineering, in particular fluid dynamics and hydrometry, the volumetric flow rate
 * (also known as volume flow rate, rate of fluid flow, Discharge (hydrology) or volume velocity) is
 * the volume of fluid which passes per unit time; usually represented by the symbol Q (sometimes V̇).
 * The SI unit is cubic metres per second (m3/s).
 *
 * @see https://en.wikipedia.org/wiki/Volumetric_flow_rate
 * */
inline class VolumetricFlowRate(val cubicMetersPerSecond: Double) : Units<VolumetricFlowRate> {
    override val value: Double get() = cubicMetersPerSecond
    override fun plus(other: VolumetricFlowRate): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond + other.cubicMetersPerSecond)
    override fun minus(other: VolumetricFlowRate): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond - other.cubicMetersPerSecond)
    override fun times(factor: Number): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond * factor.toDouble())
    override fun div(factor: Number): VolumetricFlowRate = VolumetricFlowRate(cubicMetersPerSecond / factor.toDouble())

    operator fun div(time: Time): Volume = Volume(cubicMeters = cubicMetersPerSecond / time.seconds)
}

val Number.cubicMetersPerSecond: VolumetricFlowRate get() = VolumetricFlowRate(cubicMetersPerSecond = toDouble())
