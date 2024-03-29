package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 *  The component of the magnetic moment that can be represented by an equivalent magnetic dipole: a
 *  magnetic north and south pole separated by a very small distance. The magnetic dipole component
 *  is sufficient for small enough magnets or for large enough distances. Higher order terms (such as
 *  the magnetic quadrupole moment) may be needed in addition to the dipole moment for extended objects.
 *
 *  The magnetic dipole moment of an object is readily defined in terms of the torque that object
 *  experiences in a given magnetic field. The same applied magnetic field creates larger torques on
 *  objects with larger magnetic moments. The strength (and direction) of this torque depends not only
 *  on the magnitude of the magnetic moment but also on its orientation relative to the direction of
 *  the magnetic field. The magnetic moment may be considered, therefore, to be a vector. The direction
 *  of the magnetic moment points from the south to north pole of the magnet (inside the magnet).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetic_moment)
 */
@JvmInline
value class MagneticDipoleMoment(val joulesPerTesla: Double) : Units<MagneticDipoleMoment> {
    override fun plus(other: MagneticDipoleMoment) = MagneticDipoleMoment(joulesPerTesla = joulesPerTesla + other.joulesPerTesla)
    override fun minus(other: MagneticDipoleMoment) = MagneticDipoleMoment(joulesPerTesla = joulesPerTesla - other.joulesPerTesla)
    override fun times(factor: Number) = MagneticDipoleMoment(joulesPerTesla = joulesPerTesla * factor.toDouble())
    override fun div(factor: Number) = MagneticDipoleMoment(joulesPerTesla = joulesPerTesla / factor.toDouble())
    override fun compareTo(other: MagneticDipoleMoment): Int = joulesPerTesla.compareTo(other.joulesPerTesla)
}
