package faraday.kinematics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics and engineering, in particular fluid dynamics and hydrometry, the volumetric flow rate (also known as volume flow rate, rate of fluid flow, Discharge (hydrology) or volume velocity) is the volume of fluid which passes per unit time; usually represented by the symbol Q (sometimes V̇). The SI unit is cubic metres per second (m3/s).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Volumetric_flow_rate)
 */
@JvmInline
value class VolumetricFlowRate(val cubicMetersPerSecond: Double) : Units<VolumetricFlowRate> {
    @InternalUnitApi
    override val rawValue: Double get() = cubicMetersPerSecond

    @InternalUnitApi
    override fun create(value: Double) = VolumetricFlowRate(value)
}

val Number.cubicMetersPerSecond get() = VolumetricFlowRate(cubicMetersPerSecond = toDouble())