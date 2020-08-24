package konvert.derived.molar

import konvert.Units

/**
 * @see https://en.wikipedia.org/wiki/Energy
 * */
inline class MolarEnergy(val joulesPerMole: Double) : Units<MolarEnergy> {
    override val value: Double get() = joulesPerMole
    override fun plus(other: MolarEnergy): MolarEnergy = MolarEnergy(joulesPerMole + other.joulesPerMole)
    override fun minus(other: MolarEnergy): MolarEnergy = MolarEnergy(joulesPerMole - other.joulesPerMole)
    override fun times(factor: Number): MolarEnergy = MolarEnergy(joulesPerMole * factor.toDouble())
    override fun div(factor: Number): MolarEnergy = MolarEnergy(joulesPerMole / factor.toDouble())
}
