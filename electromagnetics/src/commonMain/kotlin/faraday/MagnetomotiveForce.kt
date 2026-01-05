package faraday

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
    @InternalUnitApi
    override val rawValue: Double get() = ampereRadians

    @InternalUnitApi
    override fun create(value: Double) = MagnetomotiveForce(value)
}
