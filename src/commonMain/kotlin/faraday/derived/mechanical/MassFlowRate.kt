package faraday.derived.mechanical

import faraday.Units
import faraday.base.Mass
import faraday.base.Time
import kotlin.jvm.JvmInline

/**
 * In physics and engineering, mass flow rate is the mass of a substance which passes per unit of
 * time.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Mass_flow_rate)
 */
@JvmInline
value class MassFlowRate(val kilogramsPerSecond: Double) : Units<MassFlowRate> {
    override fun plus(other: MassFlowRate) = MassFlowRate(kilogramsPerSecond = kilogramsPerSecond + other.kilogramsPerSecond)
    override fun minus(other: MassFlowRate) = MassFlowRate(kilogramsPerSecond = kilogramsPerSecond - other.kilogramsPerSecond)
    override fun times(factor: Number) = MassFlowRate(kilogramsPerSecond = kilogramsPerSecond * factor.toDouble())
    override fun div(factor: Number) = MassFlowRate(kilogramsPerSecond = kilogramsPerSecond / factor.toDouble())
    override fun compareTo(other: MassFlowRate): Int = kilogramsPerSecond.compareTo(other.kilogramsPerSecond)

    operator fun times(time: Time) = Mass(kilogramsPerSecond * time.seconds)
}
