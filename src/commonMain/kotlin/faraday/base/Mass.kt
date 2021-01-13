package faraday.base

import faraday.Units
import faraday.derived.kinematic.Acceleration
import faraday.derived.mechanical.Density
import faraday.derived.Force
import faraday.derived.kinematic.Velocity
import faraday.derived.mechanical.Momentum
import faraday.derived.mechanical.Volume

/**
 * Mass is both a property of a physical body and a measure of its resistance to acceleration
 * (a change in its state of motion) when a net force is applied. An object's mass also
 * determines the strength of its gravitational attraction to other bodies.
 *
 * The basic SI unit of mass is the kilogram (kg). In physics, mass is not the same as weight,
 * even though mass is often determined by measuring the object's weight using a spring scale,
 * rather than balance scale comparing it directly with known masses. An object on the Moon
 * would weigh less than it does on Earth because of the lower gravity, but it would still
 * have the same mass. This is because weight is a force, while mass is the property that
 * (along with gravity) determines the strength of this force.
 *
 * @see https://en.wikipedia.org/wiki/Mass
 * */
inline class Mass(val kilograms: Double) : Units<Mass> {
    val grams get() = kilograms * 1000
    val milligrams get() = kilograms * 1e6
    val carats get() = kilograms / CARAT
    val pounds get() = kilograms / POUND
    val tonnes get() = kilograms / 1000

    override fun plus(other: Mass) = Mass(kilograms = kilograms + other.kilograms)
    override fun minus(other: Mass) = Mass(kilograms = kilograms - other.kilograms)
    override fun times(factor: Number) = Mass(kilograms = kilograms * factor.toDouble())
    override fun div(factor: Number) = Mass(kilograms = kilograms / factor.toDouble())
    override fun compareTo(other: Mass): Int = kilograms.compareTo(other.kilograms)

    operator fun times(acceleration: Acceleration) = Force(newtons = kilograms * acceleration.metersPerSecondSquared)
    operator fun times(velocity: Velocity) = Momentum(newtonSeconds = kilograms * velocity.metersPerSecond)
    operator fun div(density: Density) = Volume(cubicMeters = density.kgPerCubicMeter / kilograms)

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
