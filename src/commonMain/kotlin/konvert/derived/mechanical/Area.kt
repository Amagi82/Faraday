package konvert.derived.mechanical

import konvert.Units
import konvert.base.Distance

/**
 * Area is the quantity that expresses the extent of a two-dimensional figure or shape or planar lamina,
 * in the plane. Surface area is its analog on the two-dimensional surface of a three-dimensional object.
 * Area can be understood as the amount of material with a given thickness that would be necessary to
 * fashion a model of the shape, or the amount of paint necessary to cover the surface with a single coat.
 * It is the two-dimensional analog of the length of a curve (a one-dimensional concept) or the volume of
 * a solid (a three-dimensional concept).
 *
 * The area of a shape can be measured by comparing the shape to squares of a fixed size. In the
 * International System of Units (SI), the standard unit of area is the square metre (written as m2),
 * which is the area of a square whose sides are one metre long. A shape with an area of three square
 * metres would have the same area as three such squares. In mathematics, the unit square is defined to
 * have area one, and the area of any other shape or surface is a dimensionless real number.
 *
 * @see https://en.wikipedia.org/wiki/Area
 * */
inline class Area(val squareMeters: Double) : Units<Area> {
    override val value: Double get() = squareMeters
    val hectares: Double get() = squareMeters / 10_000
    val squareKilometers: Double get() = squareMeters / 1e6
    val squareCentimeters: Double get() = squareMeters * 10_000

    val squareInches: Double get() = squareMeters / SQ_INCH
    val squareFeet: Double get() = squareMeters / SQ_FOOT
    val squareYards: Double get() = squareMeters / SQ_YARD
    val acres: Double get() = squareMeters / ACRE
    val squareMiles: Double get() = squareMeters / SQ_MILE

    override fun plus(other: Area): Area = Area(squareMeters + other.squareMeters)
    override fun minus(other: Area): Area = Area(squareMeters - other.squareMeters)
    override fun times(factor: Number): Area = Area(squareMeters * factor.toDouble())
    override fun div(factor: Number): Area = Area(squareMeters / factor.toDouble())

    operator fun times(distance: Distance): Volume = Volume(cubicMeters = squareMeters * distance.meters)

    companion object {
        const val SQ_INCH = Distance.INCH * Distance.INCH
        const val SQ_FOOT = Distance.FOOT * Distance.FOOT
        const val SQ_YARD = Distance.YARD * Distance.YARD
        const val ACRE = 4046.8564224
        const val SQ_MILE = Distance.MILE * Distance.MILE
    }
}

val Number.squareCentimeters: Area get() = Area(squareMeters = toDouble() / 10_000)
val Number.squareMeters: Area get() = Area(squareMeters = toDouble())

val Number.squareFeet: Area get() = Area(squareMeters = toDouble() * Area.SQ_FOOT)
val Number.acres: Area get() = Area(squareMeters = toDouble() * Area.ACRE)
val Number.squareMiles: Area get() = Area(squareMeters = toDouble() * Area.SQ_MILE)

