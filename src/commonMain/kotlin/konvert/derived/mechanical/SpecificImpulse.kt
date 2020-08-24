package konvert.derived.mechanical

import konvert.Units

/**
 * Specific impulse (usually abbreviated Isp) is a measure of how effectively a rocket uses propellant
 * or a jet engine uses fuel. Specific impulse can be calculated in a variety of different ways with
 * different  By definition, it is the total impulse (or change in momentum) delivered per unit
 * of propellant consumed and is dimensionally equivalent to the generated thrust divided by the
 * propellant mass flow rate or weight flow rate. If mass (kilogram, pound-mass, or slug) is used as
 * the unit of propellant, then specific impulse has units of velocity. If weight (newton or pound-force)
 * is used instead, then specific impulse has units of time (seconds). Multiplying flow rate by the
 * standard gravity (g0) converts specific impulse from the weight basis to the mass basis.
 *
 * A propulsion system with a higher specific impulse uses the mass of the propellant more efficiently.
 * In the case of a rocket or other vehicle governed by the Tsiolkovsky rocket equation, this means
 * less propellant needed for a given delta-v. In rockets, this means the vehicle the engine is
 * attached to can more efficiently gain altitude and velocity. This effectiveness is less important
 * in jet aircraft that use ambient air for combustion, and carry payloads that are much heavier than
 * the propellant.
 *
 * Specific impulse can include the contribution to impulse provided by external air that has been used
 * for combustion and is exhausted with the spent propellant. Jet engines use outside air, and therefore
 * have a much higher specific impulse than rocket engines. The specific impulse in terms of propellant
 * mass spent has units of distance per time, which is a notional velocity called the effective exhaust
 * velocity. This is higher than the actual exhaust velocity because the mass of the combustion air is
 * not being accounted for. Actual and effective exhaust velocity are the same in rocket engines
 * operating in a vacuum.
 *
 * Specific impulse is inversely proportional to specific fuel consumption (SFC) by the relationship
 * Isp = 1/(go·SFC) for SFC in kg/(N·s) and Isp = 3600/SFC for SFC in lb/(lbf·hr).
 *
 * In short, Isp is the amount of time a rocket engine can generate thrust given a quantity of propellant
 * with weight equal to the engine's thrust
 *
 * @see https://en.wikipedia.org/wiki/Specific_impulse
 * */
inline class SpecificImpulse(val isp: Double) : Units<SpecificImpulse> {
    override val value: Double get() = isp
    override fun plus(other: SpecificImpulse): SpecificImpulse = SpecificImpulse(isp + other.isp)
    override fun minus(other: SpecificImpulse): SpecificImpulse = SpecificImpulse(isp - other.isp)
    override fun times(factor: Number): SpecificImpulse = SpecificImpulse(isp * factor.toDouble())
    override fun div(factor: Number): SpecificImpulse = SpecificImpulse(isp / factor.toDouble())
}
