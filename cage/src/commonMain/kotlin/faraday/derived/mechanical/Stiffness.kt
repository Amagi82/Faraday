package faraday.derived.mechanical

import faraday.Units

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * @see https://en.wikipedia.org/wiki/Stiffness
 * */
inline class Stiffness(val joulesPerSquareMeter: Double) : Units<Stiffness> {
    override fun plus(other: Stiffness) = Stiffness(joulesPerSquareMeter = joulesPerSquareMeter + other.joulesPerSquareMeter)
    override fun minus(other: Stiffness) = Stiffness(joulesPerSquareMeter = joulesPerSquareMeter - other.joulesPerSquareMeter)
    override fun times(factor: Number) = Stiffness(joulesPerSquareMeter = joulesPerSquareMeter * factor.toDouble())
    override fun div(factor: Number) = Stiffness(joulesPerSquareMeter = joulesPerSquareMeter / factor.toDouble())
    override fun compareTo(other: Stiffness): Int = joulesPerSquareMeter.compareTo(other.joulesPerSquareMeter)
}
