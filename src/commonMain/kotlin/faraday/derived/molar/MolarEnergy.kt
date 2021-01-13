package faraday.derived.molar

import faraday.Units

/**
 * @see https://en.wikipedia.org/wiki/Energy
 * */
inline class MolarEnergy(val joulesPerMole: Double) : Units<MolarEnergy> {
    override fun plus(other: MolarEnergy) = MolarEnergy(joulesPerMole = joulesPerMole + other.joulesPerMole)
    override fun minus(other: MolarEnergy) = MolarEnergy(joulesPerMole = joulesPerMole - other.joulesPerMole)
    override fun times(factor: Number) = MolarEnergy(joulesPerMole = joulesPerMole * factor.toDouble())
    override fun div(factor: Number) = MolarEnergy(joulesPerMole = joulesPerMole / factor.toDouble())
    override fun compareTo(other: MolarEnergy): Int = joulesPerMole.compareTo(other.joulesPerMole)
}
