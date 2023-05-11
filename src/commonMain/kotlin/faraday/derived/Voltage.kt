package faraday.derived

import faraday.Units
import faraday.base.ElectricCurrent
import faraday.base.Time
import kotlin.jvm.JvmInline

/**
 * An electric potential (also called the electric field potential, potential drop or the electrostatic potential)
 * is the amount of work needed to move a unit of charge from a reference point to a specific point inside the
 * field without producing an acceleration. Typically, the reference point is the Earth or a point at infinity,
 * although any point can be used.
 *
 * In classical electrostatics, the electrostatic field is a vector quantity which is expressed as the gradient
 * of the electrostatic potential, which is a scalar quantity denoted by V or occasionally φ, equal to the
 * electric potential energy of any charged particle at any location (measured in joules) divided by the charge
 * of that particle (measured in coulombs). By dividing out the charge on the particle a quotient is obtained
 * that is a property of the electric field itself. In short, electric potential is the electric potential energy
 * per unit charge.
 *
 * This value can be calculated in either a static (time-invariant) or a dynamic (varying with time) electric
 * field at a specific time in units of joules per coulomb (J⋅C−1), or volts (V). The electric potential at
 * infinity is assumed to be zero.
 *
 * In electrodynamics, when time-varying fields are present, the electric field cannot be expressed only in terms
 * of a scalar potential. Instead, the electric field can be expressed in terms of both the scalar electric
 * potential and the magnetic vector potential.[2] The electric potential and the magnetic vector potential
 * together form a four vector, so that the two kinds of potential are mixed under Lorentz transformations.
 *
 * Practically, electric potential is always a continuous function in space; Otherwise, the spatial derivative
 * of it will yield a field with infinite magnitude, which is practically impossible. Even an idealized point
 * charge has 1/r potential, which is continuous everywhere except the origin. The electric field is not
 * continuous across an idealized surface charge, but it is not infinite at any point. Therefore, the electric
 * potential is continuous across an idealized surface charge. An idealized linear charge has ln(r) potential,
 * which is continuous everywhere except on the linear charge.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Electric_potential)
 */
@JvmInline
value class Voltage(val volts: Double) : Units<Voltage> {
    override fun plus(other: Voltage) = Voltage(volts = volts + other.volts)
    override fun minus(other: Voltage) = Voltage(volts = volts - other.volts)
    override fun times(factor: Number) = Voltage(volts = volts * factor.toDouble())
    override fun div(factor: Number) = Voltage(volts = volts / factor.toDouble())
    override fun compareTo(other: Voltage): Int = volts.compareTo(other.volts)

    operator fun times(charge: ElectricCharge): Energy = charge * this
    operator fun times(current: ElectricCurrent): Power = current * this
    operator fun times(time: Time) = MagneticFlux(webers = volts * time.seconds)
    operator fun div(current: ElectricCurrent) = ElectricResistance(ohms = volts / current.amperes)
}
typealias ElectricPotential = Voltage

val Number.volts get() = Voltage(toDouble())
