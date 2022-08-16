package faraday.derived

import faraday.Prefixes
import faraday.Units
import faraday.base.Distance
import faraday.base.ElectricCurrent
import faraday.base.Mass
import faraday.base.Time
import faraday.derived.kinematic.Velocity
import faraday.derived.mechanical.Volume
import kotlin.jvm.JvmInline
import kotlin.math.pow

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
@JvmInline
value class Energy(val joules: Double) : Units<Energy> {
    val kilojoules get() = joules / Prefixes.KILO
    val megajoules get() = joules / Prefixes.MEGA
    val gigajoules get() = joules / Prefixes.GIGA
    val terajoules get() = joules / Prefixes.TERA

    val btus get() = joules / 1.0545e3
    val cal get() = joules / 4.1868
    val kcal get() = cal / 1000
    val kWh get() = joules / 3.6e6
    val wattHour get() = joules / Time.HOUR

    override fun plus(other: Energy) = Energy(joules = joules + other.joules)
    override fun minus(other: Energy) = Energy(joules = joules - other.joules)
    override fun times(factor: Number) = Energy(joules = joules * factor.toDouble())
    override fun div(factor: Number) = Energy(joules = joules / factor.toDouble())
    override fun compareTo(other: Energy): Int = joules.compareTo(other.joules)

    operator fun div(time: Time) = Power(watts = joules / time.seconds)
    operator fun div(power: Power) = Time(seconds = joules / power.watts)
    operator fun div(charge: ElectricCharge) = Voltage(volts = joules / charge.coulombs)
    operator fun div(voltage: Voltage) = ElectricCharge(coulombs = joules / voltage.volts)
    operator fun div(force: Force) = Distance(meters = joules / force.newtons)
    operator fun div(distance: Distance) = Force(newtons = joules / distance.meters)
    operator fun div(volume: Volume) = EnergyDensity(pascals = joules / volume.cubicMeters)
    operator fun div(current: ElectricCurrent) = MagneticFlux(webers = joules / current.amperes)

    fun toMass() = Mass(joules / Velocity.LIGHT.pow(2))
}

val Number.joules get() = Energy(toDouble())
val Number.kilojoules get() = Energy(joules = toDouble() * Prefixes.KILO)
val Number.megajoules get() = Energy(joules = toDouble() * Prefixes.MEGA)
val Number.gigajoules get() = Energy(joules = toDouble() * Prefixes.GIGA)
val Number.terajoules get() = Energy(joules = toDouble() * Prefixes.TERA)
