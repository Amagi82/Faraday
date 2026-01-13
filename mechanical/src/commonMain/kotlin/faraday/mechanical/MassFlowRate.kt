package faraday.mechanical

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics and engineering, mass flow rate is the mass of a substance which passes per unit of time.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Mass_flow_rate)
 */
@JvmInline
value class MassFlowRate(val kilogramsPerSecond: Double) : Units<MassFlowRate> {
    @InternalUnitApi
    override val rawValue: Double get() = kilogramsPerSecond

    @InternalUnitApi
    override fun create(value: Double) = MassFlowRate(value)
}
