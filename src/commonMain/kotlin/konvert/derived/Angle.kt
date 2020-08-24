package konvert.derived

import konvert.Units
import kotlin.math.PI

/**
 * In plane geometry, an angle is the figure formed by two rays, called the sides of the angle, sharing a
 * common endpoint, called the vertex of the angle. Angles formed by two rays lie in a plane, but this
 * plane does not have to be a Euclidean plane. Angles are also formed by the intersection of two planes
 * in Euclidean and other spaces. These are called dihedral angles. Angles formed by the intersection of
 * two curves in a plane are defined as the angle determined by the tangent rays at the point of
 * intersection. Similar statements hold in space, for example, the spherical angle formed by two great
 * circles on a sphere is the dihedral angle between the planes determined by the great circles.
 *
 * Angle is also used to designate the measure of an angle or of a rotation. This measure is the ratio of
 * the length of a circular arc to its radius. In the case of a geometric angle, the arc is centered at the
 * vertex and delimited by the sides. In the case of a rotation, the arc is centered at the center of the
 * rotation and delimited by any other point and its image by the rotation.
 *
 * @see https://en.wikipedia.org/wiki/Angle
 * @see https://en.wikipedia.org/wiki/Angular_unit
 * */
inline class Angle(val radians: Double) : Units<Angle> {
    override val value: Double get() = radians
    val degrees: Double get() = radians * 180.0 / PI

    override fun plus(other: Angle): Angle = Angle((radians + other.radians) % (2 * PI))
    override fun minus(other: Angle): Angle = Angle((radians - other.radians) % (2 * PI))
    override fun times(factor: Number): Angle = Angle((radians * factor.toDouble()) % (2 * PI))
    override fun div(factor: Number): Angle = Angle((radians / factor.toDouble()) % (2 * PI))
}

val Number.radians: Angle get() = Angle(toDouble())
val Number.degrees: Angle get() = Angle(toDouble() * PI / 180.0)
