package konvert.derived.mechanical

import konvert.Units
import konvert.base.Mass
import konvert.base.Time

/**
 * In physics and engineering, mass flow rate is the mass of a substance which passes per unit of
 * time.
 *
 * @see https://en.wikipedia.org/wiki/Mass_flow_rate
 * */
inline class MassFlowRate(val kilogramsPerSecond: Double) : Units<MassFlowRate> {
    override val value: Double get() = kilogramsPerSecond
    override fun plus(other: MassFlowRate): MassFlowRate = MassFlowRate(kilogramsPerSecond + other.kilogramsPerSecond)
    override fun minus(other: MassFlowRate): MassFlowRate = MassFlowRate(kilogramsPerSecond - other.kilogramsPerSecond)
    override fun times(factor: Number): MassFlowRate = MassFlowRate(kilogramsPerSecond * factor.toDouble())
    override fun div(factor: Number): MassFlowRate = MassFlowRate(kilogramsPerSecond / factor.toDouble())

    operator fun times(time: Time): Mass = Mass(kilogramsPerSecond * time.seconds)
}
