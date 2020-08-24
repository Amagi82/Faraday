package konvert.derived.electromagnetic

import konvert.Units

/**
 * In physics, the magnetomotive force (mmf) is a quantity appearing in the equation for the magnetic
 * flux in a magnetic circuit, often called Ohm's law for magnetic circuits. It is the property of
 * certain substances or phenomena that give rise to magnetic fields.
 *
 * @see https://en.wikipedia.org/wiki/Magnetomotive_force
 * */
inline class MagnetomotiveForce(val ampereRadians: Double) : Units<MagnetomotiveForce> {
    override val value: Double get() = ampereRadians
    override fun plus(other: MagnetomotiveForce): MagnetomotiveForce = MagnetomotiveForce(ampereRadians + other.ampereRadians)
    override fun minus(other: MagnetomotiveForce): MagnetomotiveForce = MagnetomotiveForce(ampereRadians - other.ampereRadians)
    override fun times(factor: Number): MagnetomotiveForce = MagnetomotiveForce(ampereRadians * factor.toDouble())
    override fun div(factor: Number): MagnetomotiveForce = MagnetomotiveForce(ampereRadians / factor.toDouble())
}
