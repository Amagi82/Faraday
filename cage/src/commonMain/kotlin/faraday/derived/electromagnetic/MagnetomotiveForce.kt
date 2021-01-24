package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics, the magnetomotive force (mmf) is a quantity appearing in the equation for the magnetic
 * flux in a magnetic circuit, often called Ohm's law for magnetic circuits. It is the property of
 * certain substances or phenomena that give rise to magnetic fields.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetomotive_force)
 */
@JvmInline
value class MagnetomotiveForce(val ampereRadians: Double) : Units<MagnetomotiveForce> {
    override fun plus(other: MagnetomotiveForce) = MagnetomotiveForce(ampereRadians = ampereRadians + other.ampereRadians)
    override fun minus(other: MagnetomotiveForce) = MagnetomotiveForce(ampereRadians = ampereRadians - other.ampereRadians)
    override fun times(factor: Number) = MagnetomotiveForce(ampereRadians = ampereRadians * factor.toDouble())
    override fun div(factor: Number) = MagnetomotiveForce(ampereRadians = ampereRadians / factor.toDouble())
    override fun compareTo(other: MagnetomotiveForce): Int = ampereRadians.compareTo(other.ampereRadians)
}
