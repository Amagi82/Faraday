package konvert.base

import konvert.Units
import konvert.derived.kinematic.Acceleration
import konvert.derived.mechanical.Density
import konvert.derived.Force
import konvert.derived.mechanical.Volume

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
    override val value: Double get() = kilograms
    val grams: Double get() = kilograms * 1000
    val milligrams: Double get() = kilograms / 1e6
    val carats: Double get() = kilograms / 2e-4
    val pounds: Double get() = kilograms / POUND
    val tonnes: Double get() = kilograms / 1000

    override fun plus(other: Mass): Mass = Mass(kilograms + other.kilograms)
    override fun minus(other: Mass): Mass = Mass(kilograms - other.kilograms)
    override fun times(factor: Number): Mass = Mass(kilograms * factor.toDouble())
    override fun div(factor: Number): Mass = Mass(kilograms / factor.toDouble())

    operator fun times(acceleration: Acceleration): Force = Force(kilograms * acceleration.metersPerSecondSquared)
    operator fun div(density: Density): Volume = Volume(density.kgPerCubicMeter / kilograms)

    companion object {
        const val POUND = 0.45359237
    }
}

val Number.milligrams: Mass get() = Mass(kilograms = toDouble() / 1e6)
val Number.grams: Mass get() = Mass(kilograms = toDouble() / 1000)
val Number.kilograms: Mass get() = Mass(kilograms = toDouble())
val Number.pounds: Mass get() = Mass(kilograms = toDouble() * Mass.POUND)
