package konvert.derived

import konvert.Units
import konvert.base.Time

/**
 * In physics, energy is the quantitative property that must be transferred to an object in order to
 * perform work on, or to heat, the object. Energy is a conserved quantity; the law of conservation
 * of energy states that energy can be converted in form, but not created or destroyed. The SI unit
 * of energy is the joule, which is the energy transferred to an object by the work of moving it a
 * distance of 1 metre against a force of 1 newton.
 *
 * Common forms of energy include the kinetic energy of a moving object, the potential energy stored
 * by an object's position in a force field (gravitational, electric or magnetic), the elastic energy
 * stored by stretching solid objects, the chemical energy released when a fuel burns, the radiant
 * energy carried by light, and the thermal energy due to an object's temperature.
 *
 * Mass and energy are closely related. Due to mass–energy equivalence, any object that has mass when
 * stationary (called rest mass) also has an equivalent amount of energy whose form is called rest
 * energy, and any additional energy (of any form) acquired by the object above that rest energy will
 * increase the object's total mass just as it increases its total energy. For example, after heating
 * an object, its increase in energy could be measured as a small increase in mass, with a sensitive
 * enough scale.
 *
 * @see https://en.wikipedia.org/wiki/Energy
 * */
inline class Energy(val joules: Double) : Units<Energy> {
    override val value: Double get() = joules
    val btus: Double get() = joules / 1.0545e3
    val cal: Double get() = joules / 4.1868
    val kcal: Double get() = cal / 1000
    val kWh: Double get() = joules / 3.6e6
    val wattHour: Double get() = joules / Time.HOUR

    override fun plus(other: Energy): Energy = Energy(joules + other.joules)
    override fun minus(other: Energy): Energy = Energy(joules - other.joules)
    override fun times(factor: Number): Energy = Energy(joules * factor.toDouble())
    override fun div(factor: Number): Energy = Energy(joules / factor.toDouble())
}

val Number.joules: Energy get() = Energy(toDouble())
