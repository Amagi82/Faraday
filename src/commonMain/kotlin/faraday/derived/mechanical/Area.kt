package faraday.derived.mechanical

import faraday.Units
import faraday.base.Distance
import faraday.derived.MagneticFlux
import faraday.derived.MagneticInduction
import kotlin.jvm.JvmInline

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
@JvmInline
value class Area(val squareMeters: Double) : Units<Area> {
    val hectares get() = squareMeters / HECTARE
    val squareKilometers get() = squareMeters / SQ_KILO
    val squareCentimeters get() = squareMeters / SQ_CENTI

    val squareInches get() = squareMeters / SQ_INCH
    val squareFeet get() = squareMeters / SQ_FOOT
    val squareYards get() = squareMeters / SQ_YARD
    val acres get() = squareMeters / ACRE
    val squareMiles get() = squareMeters / SQ_MILE

    override fun plus(other: Area) = Area(squareMeters = squareMeters + other.squareMeters)
    override fun minus(other: Area) = Area(squareMeters = squareMeters - other.squareMeters)
    override fun times(factor: Number) = Area(squareMeters = squareMeters * factor.toDouble())
    override fun div(factor: Number) = Area(squareMeters = squareMeters / factor.toDouble())
    override fun compareTo(other: Area): Int = squareMeters.compareTo(other.squareMeters)

    operator fun times(distance: Distance) = Volume(cubicMeters = squareMeters * distance.meters)
    operator fun times(induction: MagneticInduction): MagneticFlux = induction * this

    companion object {
        const val HECTARE = 1e4
        const val SQ_KILO = 1e6
        const val SQ_CENTI = 1e-4
        const val SQ_INCH = Distance.INCH * Distance.INCH
        const val SQ_FOOT = Distance.FOOT * Distance.FOOT
        const val SQ_YARD = Distance.YARD * Distance.YARD
        const val ACRE = 4046.8564224
        const val SQ_MILE = Distance.MILE * Distance.MILE
    }
}

val Number.hectares get() = Area(squareMeters = toDouble() * Area.HECTARE)
val Number.squareCentimeters get() = Area(squareMeters = toDouble() * Area.SQ_CENTI)
val Number.squareMeters get() = Area(squareMeters = toDouble())
val Number.squareKilometers get() = Area(squareMeters = toDouble() * Area.SQ_KILO)

val Number.squareFeet get() = Area(squareMeters = toDouble() * Area.SQ_FOOT)
val Number.acres get() = Area(squareMeters = toDouble() * Area.ACRE)
val Number.squareMiles get() = Area(squareMeters = toDouble() * Area.SQ_MILE)

