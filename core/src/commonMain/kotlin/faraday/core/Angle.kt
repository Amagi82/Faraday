package faraday.core

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline
import kotlin.math.PI

/**
 * In plane geometry, an angle is the figure formed by two rays, called the sides of the angle, sharing a common endpoint, called the vertex of the angle. Angles formed by two rays lie in a plane, but this plane does not have to be a Euclidean plane. Angles are also formed by the intersection of two planes in Euclidean and other spaces. These are called dihedral angles. Angles formed by the intersection of two curves in a plane are defined as the angle determined by the tangent rays at the point of intersection. Similar statements hold in space, for example, the spherical angle formed by two great circles on a sphere is the dihedral angle between the planes determined by the great circles.
 *
 * Angle is also used to designate the measure of an angle or of a rotation. This measure is the ratio of the length of a circular arc to its radius. In the case of a geometric angle, the arc is centered at the vertex and delimited by the sides. In the case of a rotation, the arc is centered at the center of the rotation and delimited by any other point and its image by the rotation.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Angle)
 * [Wiki](https://en.wikipedia.org/wiki/Angular_unit)
 */
@JvmInline
value class Angle(val radians: Double) : Units<Angle> {
    val milliRadians get() = radians * 1000
    val degrees get() = radians / DEGREE
    val arcMinutes get() = radians / ARC_MINUTE
    val arcSeconds get() = radians / ARC_SECOND
    val milliArcSeconds get() = radians / MILLI_ARC_SECOND
    val microArcSeconds get() = radians / MICRO_ARC_SECOND
    val gradians get() = radians / GRADIAN

    @InternalUnitApi
    override val rawValue: Double get() = radians

    @InternalUnitApi
    override fun create(value: Double) = Angle(value)

    companion object {
        const val TURN = 2 * PI
        const val DEGREE = PI / 180
        const val ARC_MINUTE = DEGREE * 60
        const val ARC_SECOND = ARC_MINUTE * 60
        const val MILLI_ARC_SECOND = ARC_SECOND * 1000
        const val MICRO_ARC_SECOND = MILLI_ARC_SECOND * 1000
        const val GRADIAN = 200 / PI
    }
}

val Number.radians get() = Angle(radians = toDouble())
val Number.degrees get() = Angle(radians = (toDouble() * Angle.DEGREE))
val Number.arcMinutes get() = Angle(radians = (toDouble() * Angle.ARC_MINUTE))
val Number.arcSeconds get() = Angle(radians = (toDouble() * Angle.ARC_SECOND))
val Number.milliArcSeconds get() = Angle(radians = (toDouble() * Angle.MILLI_ARC_SECOND))
val Number.microArcSeconds get() = Angle(radians = (toDouble() * Angle.MICRO_ARC_SECOND))
