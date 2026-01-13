package faraday.core

import faraday.InternalUnitApi
import faraday.Prefixes
import faraday.Units
import kotlin.jvm.JvmInline
import kotlin.math.PI

/**
 * Length is a measure of distance. In the International System of Quantities, length is a quantity with dimension distance. In most systems of measurement a base unit for length is chosen, from which all other units are derived. In the International System of Units (SI) system the base unit for length is the meter.
 *
 * Length is commonly understood to mean the most extended dimension of a fixed object. However, this is not always the case and may depend on the position the object is in.
 *
 * Various terms for the length of a fixed object are used, and these include height, which is vertical length or vertical extent, and width, breadth or depth. Height is used when there is a base from which vertical measurements can be taken. Width or breadth usually refer to a shorter dimension when length is the longest one. Depth is used for the third dimension of a three-dimensional object.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Length)
 */
@JvmInline
value class Distance(val meters: Double) : Units<Distance> {
    val angstroms get() = meters / ANGSTROM
    val millimeters get() = meters / Prefixes.MILLI
    val centimeters get() = meters / Prefixes.CENTI
    val kilometers get() = meters / Prefixes.KILO
    val astronomicalUnits get() = meters / ASTRONOMICAL_UNIT
    val lightYears get() = meters / LIGHT_YEAR
    val parsecs get() = meters / PARSEC

    val inches get() = meters / INCH
    val feet get() = meters / FOOT
    val yards get() = meters / YARD
    val miles get() = meters / MILE

    val nauticalMiles get() = meters / NAUTICAL_MILE

    @InternalUnitApi
    override val rawValue: Double get() = meters

    @InternalUnitApi
    override fun create(value: Double) = Distance(value)

    companion object {
        const val LIGHT_SECOND = 299_792_458.0
        const val LIGHT_YEAR = LIGHT_SECOND * Time.JULIAN_YEAR
        const val ASTRONOMICAL_UNIT = 149_597_870_700.0
        const val PARSEC = (648_000.0 / PI) * ASTRONOMICAL_UNIT
        const val ANGSTROM = 1e-10

        const val INCH = 0.0254
        const val FOOT = INCH * 12
        const val YARD = FOOT * 3
        const val MILE = YARD * 1760
        const val NAUTICAL_MILE = 1852.0
    }
}

typealias Length = Distance
typealias Width = Distance
typealias Height = Distance
typealias Depth = Distance

val Number.angstroms get() = Distance(meters = toDouble() * Distance.ANGSTROM)
val Number.millimeters get() = Distance(meters = toDouble() * Prefixes.MILLI)
val Number.centimeters get() = Distance(meters = toDouble() * Prefixes.CENTI)
val Number.meters get() = Distance(meters = toDouble())
val Number.kilometers get() = Distance(meters = toDouble() * Prefixes.KILO)
val Number.lightYears get() = Distance(meters = toDouble() * Distance.LIGHT_YEAR)
val Number.parsecs get() = Distance(meters = toDouble() * Distance.PARSEC)

val Number.inches get() = Distance(meters = toDouble() * Distance.INCH)
val Number.feet get() = Distance(meters = toDouble() * Distance.FOOT)
val Number.yards get() = Distance(meters = toDouble() * Distance.YARD)
val Number.miles get() = Distance(meters = toDouble() * Distance.MILE)
val Number.nauticalMiles get() = Distance(meters = toDouble() * Distance.NAUTICAL_MILE)
