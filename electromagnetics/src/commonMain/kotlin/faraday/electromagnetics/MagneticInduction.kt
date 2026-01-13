package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The magnetic field can be defined in several equivalent ways based on the effects it has on its environment.
 *
 * Often the magnetic field is defined by the force it exerts on a moving charged particle. Experiments in electrostatics show that a particle of charge q in an electric field E experiences a force F = qE. Other experiments show that a charged particle experiences a force proportional to its relative velocity to a current-carrying wire. The velocity dependent portion can be separated such that the force on the particle satisfies the Lorentz force law, F=q(E+v*B). Here v is the particle's velocity and × denotes the cross product. The vector B is termed the magnetic field, and it is defined as the vector field necessary to make the Lorentz force law correctly describe the motion of a charged particle. This definition allows the determination of B in the following way:
 *
 * The command, "Measure the direction and magnitude of the vector B at such and such a place," calls for the following operations: Take a particle of known charge q. Measure the force on q at rest, to determine E. Then measure the force on the particle when its velocity is v; repeat with v in some other direction. Now find a B that makes the Lorentz force law fit all these results—that is the magnetic field at the place in question.
 *
 * Alternatively, the magnetic field can be defined in terms of the torque it produces on a magnetic dipole.
 *
 * In addition to B, there is a quantity H, which is often called the magnetic field. In a vacuum, B and H are proportional to each other, with the multiplicative constant depending on the physical  Inside a material they are different (see H and B inside and outside magnetic materials). The term "magnetic field" is historically reserved for H while using other terms for B. Informally, though, and formally for some recent textbooks mostly in physics, the term 'magnetic field' is used to describe B as well as or in place of H. There are many alternative names for both.
 *
 * In SI units, B is measured in teslas (symbol: T) and correspondingly ΦB (magnetic flux) is measured in webers (symbol: Wb) so that a flux density of 1 Wb/m2 is 1 tesla. The SI unit of tesla is equivalent to (newton·second)/(coulomb·metre). In Gaussian-cgs units, B is measured in gauss (symbol: G). (The conversion is 1 T = 10000 G.) One nanotesla is equivalent to 1 gamma (symbol: γ). The H-field is measured in amperes per metre (A/m) in SI units, and in oersteds (Oe) in cgs
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetic_field#The_B-field)
 */
@JvmInline
value class MagneticInduction(val teslas: Double) : Units<MagneticInduction> {
    val gauss get() = teslas / 1e-4

    @InternalUnitApi
    override val rawValue: Double get() = teslas

    @InternalUnitApi
    override fun create(value: Double) = MagneticInduction(value)
}
typealias MagneticFluxDensity = MagneticInduction

val Number.teslas get() = MagneticInduction(toDouble())
