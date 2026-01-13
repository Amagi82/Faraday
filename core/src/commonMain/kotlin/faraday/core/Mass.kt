package faraday.core

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Mass is both a property of a physical body and a measure of its resistance to acceleration (a change in its state of motion) when a net force is applied. An object's mass also determines the strength of its gravitational attraction to other bodies.
 *
 * The basic SI unit of mass is the kilogram (kg). In physics, mass is not the same as weight, even though mass is often determined by measuring the object's weight using a spring scale, rather than balance scale comparing it directly with known masses. An object on the Moon would weigh less than it does on Earth because of the lower gravity, but it would still have the same mass. This is because weight is a force, while mass is the property that (along with gravity) determines the strength of this force.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Mass)
 */
@JvmInline
value class Mass(val kilograms: Double) : Units<Mass> {
    val grams get() = kilograms * 1000
    val milligrams get() = kilograms * 1e6
    val carats get() = kilograms / CARAT
    val pounds get() = kilograms / POUND
    val tonnes get() = kilograms / 1000

    @InternalUnitApi
    override val rawValue: Double get() = kilograms

    @InternalUnitApi
    override fun create(value: Double) = Mass(value)

    companion object {
        const val CARAT = 2e-4
        const val POUND = 0.45359237
    }
}

val Number.milligrams get() = Mass(kilograms = toDouble() / 1e6)
val Number.grams get() = Mass(kilograms = toDouble() / 1000)
val Number.kilograms get() = Mass(kilograms = toDouble())
val Number.carats get() = Mass(kilograms = toDouble() * Mass.CARAT)
val Number.pounds get() = Mass(kilograms = toDouble() * Mass.POUND)