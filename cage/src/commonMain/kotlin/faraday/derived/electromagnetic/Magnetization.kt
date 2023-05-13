package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In classical electromagnetism, magnetization or magnetic polarization is the vector field that
 * expresses the density of permanent or induced magnetic dipole moments in a magnetic material.
 * The origin of the magnetic moments responsible for magnetization can be either microscopic
 * electric currents resulting from the motion of electrons in atoms, or the spin of the electrons
 * or the nuclei. Net magnetization results from the response of a material to an external magnetic
 * field. Paramagnetic materials have a weak induced magnetization in a magnetic field, which
 * disappears when the magnetic field is removed. Ferromagnetic and ferrimagnetic materials have
 * strong magnetization in a magnetic field, and can be magnetized to have magnetization in the
 * absence of an external field, becoming a permanent magnet. Magnetization is not necessarily
 * uniform within a material, but may vary between different points. Magnetization also describes
 * how a material responds to an applied magnetic field as well as the way the material changes
 * the magnetic field, and can be used to calculate the forces that result from those interactions.
 * It can be compared to electric polarization, which is the measure of the corresponding response
 * of a material to an electric field in electrostatics. Physicists and engineers usually define
 * magnetization as the quantity of magnetic moment per unit volume. It is represented by a
 * pseudovector M.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetization)
 */
@JvmInline
value class Magnetization(val amperesPerMeter: Double) : Units<Magnetization> {
    override fun plus(other: Magnetization) = Magnetization(amperesPerMeter = amperesPerMeter + other.amperesPerMeter)
    override fun minus(other: Magnetization) = Magnetization(amperesPerMeter = amperesPerMeter - other.amperesPerMeter)
    override fun times(factor: Number) = Magnetization(amperesPerMeter = amperesPerMeter * factor.toDouble())
    override fun div(factor: Number) = Magnetization(amperesPerMeter = amperesPerMeter / factor.toDouble())
    override fun compareTo(other: Magnetization): Int = amperesPerMeter.compareTo(other.amperesPerMeter)
}
