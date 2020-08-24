package konvert.derived.mechanical

import konvert.Units

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * @see https://en.wikipedia.org/wiki/Stiffness
 * */
inline class Stiffness(val joulesPerSquareMeter: Double) : Units<Stiffness> {
    override val value: Double get() = joulesPerSquareMeter
    override fun plus(other: Stiffness): Stiffness = Stiffness(joulesPerSquareMeter + other.joulesPerSquareMeter)
    override fun minus(other: Stiffness): Stiffness = Stiffness(joulesPerSquareMeter - other.joulesPerSquareMeter)
    override fun times(factor: Number): Stiffness = Stiffness(joulesPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): Stiffness = Stiffness(joulesPerSquareMeter / factor.toDouble())
}
