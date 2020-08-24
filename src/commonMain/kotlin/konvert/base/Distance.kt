package konvert.base

import konvert.Units
import konvert.derived.mechanical.Area
import kotlin.math.PI

/**
 * Length is a measure of distance. In the International System of Quantities, length is a
 * quantity with dimension distance. In most systems of measurement a base unit for length
 * is chosen, from which all other units are derived. In the International System of Units
 * (SI) system the base unit for length is the meter.
 *
 * Length is commonly understood to mean the most extended dimension of a fixed object.
 * However, this is not always the case and may depend on the position the object is in.
 *
 * Various terms for the length of a fixed object are used, and these include height, which
 * is vertical length or vertical extent, and width, breadth or depth. Height is used when
 * there is a base from which vertical measurements can be taken. Width or breadth usually
 * refer to a shorter dimension when length is the longest one. Depth is used for the third
 * dimension of a three dimensional object.
 *
 * @see https://en.wikipedia.org/wiki/Length
 * */
inline class Distance(val meters: Double) : Units<Distance> {
    override val value: Double get() = meters
    val angstroms: Double get() = meters * 1e10
    val millimeters: Double get() = meters * 1000
    val centimeters: Double get() = meters * 100
    val kilometers: Double get() = meters / 1000
    val astronomicalUnits: Double get() = meters / ASTRONOMICAL_UNIT
    val lightYears: Double get() = meters / LIGHT_YEAR
    val parsecs: Double get() = meters / PARSEC

    val inches: Double get() = meters / INCH
    val feet: Double get() = meters / FOOT
    val yards: Double get() = meters / YARD
    val miles: Double get() = meters / MILE

    val nauticalMiles: Double get() = meters / NAUTICAL_MILE

    override fun plus(other: Distance): Distance = Distance(meters + other.meters)
    override fun minus(other: Distance): Distance = Distance(meters - other.meters)
    override fun times(factor: Number): Distance = Distance(meters * factor.toDouble())
    override fun div(factor: Number): Distance = Distance(meters / factor.toDouble())

    operator fun times(distance: Distance): Area = Area(squareMeters = meters * distance.meters)

    companion object {
        const val LIGHT_SECOND = 299_792_458.0
        const val LIGHT_YEAR = LIGHT_SECOND * Time.JULIAN_YEAR
        const val ASTRONOMICAL_UNIT = 149_597_870_700.0
        const val PARSEC = (648_000.0 / PI) * ASTRONOMICAL_UNIT

        const val INCH = 0.0254
        const val FOOT = INCH * 12
        const val YARD = FOOT * 3
        const val MILE = YARD * 1760
        const val NAUTICAL_MILE = 1852.0
    }
}

val Number.angstroms: Distance get() = Distance(meters = toDouble() / 1e10)
val Number.millimeters: Distance get() = Distance(meters = toDouble() / 1000)
val Number.centimeters: Distance get() = Distance(meters = toDouble() / 100)
val Number.meters: Distance get() = Distance(meters = toDouble())
val Number.kilometers: Distance get() = Distance(meters = toDouble() * 1000)
val Number.lightYears: Distance get() = Distance(meters = toDouble() * Distance.LIGHT_YEAR)
val Number.parsecs: Distance get() = Distance(meters = toDouble() * Distance.PARSEC)

val Number.inches: Distance get() = Distance(meters = toDouble() * Distance.INCH)
val Number.feet: Distance get() = Distance(meters = toDouble() * Distance.FOOT)
val Number.yards: Distance get() = Distance(meters = toDouble() * Distance.YARD)
val Number.miles: Distance get() = Distance(meters = toDouble() * Distance.MILE)
val Number.nauticalMiles: Distance get() = Distance(meters = toDouble() * Distance.NAUTICAL_MILE)
