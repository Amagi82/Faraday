package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The magnetic moment is the magnetic strength and orientation of a magnet or other object that
 * produces a magnetic field. Examples of objects that have magnetic moments include: loops of
 * electric current (such as electromagnets), permanent magnets, moving elementary particles
 * (such as electrons), various molecules, and many astronomical objects (such as many planets,
 * some moons, stars, etc).
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Magnetic_moment)
 */
@JvmInline
value class MagneticMoment(val weberMeters: Double) : Units<MagneticMoment> {
    override fun plus(other: MagneticMoment) = MagneticMoment(weberMeters = weberMeters + other.weberMeters)
    override fun minus(other: MagneticMoment) = MagneticMoment(weberMeters = weberMeters - other.weberMeters)
    override fun times(factor: Number) = MagneticMoment(weberMeters = weberMeters * factor.toDouble())
    override fun div(factor: Number) = MagneticMoment(weberMeters = weberMeters / factor.toDouble())
    override fun compareTo(other: MagneticMoment): Int = weberMeters.compareTo(other.weberMeters)
}
