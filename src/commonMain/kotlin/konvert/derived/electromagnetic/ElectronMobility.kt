package konvert.derived.electromagnetic

import konvert.Units

/**
 * In solid-state physics, the electron mobility characterises how quickly an electron can move through
 * a metal or semiconductor, when pulled by an electric field. There is an analogous quantity for holes,
 * called hole mobility. The term carrier mobility refers in general to both electron and hole mobility.
 *
 * Electron and hole mobility are special cases of electrical mobility of charged particles in a fluid
 * under an applied electric field.
 *
 * @see https://en.wikipedia.org/wiki/Electron_mobility
 * */
inline class ElectronMobility(val squareMetersPerVoltSecond: Double) : Units<ElectronMobility> {
    override val value: Double get() = squareMetersPerVoltSecond
    override fun plus(other: ElectronMobility): ElectronMobility = ElectronMobility(squareMetersPerVoltSecond + other.squareMetersPerVoltSecond)
    override fun minus(other: ElectronMobility): ElectronMobility = ElectronMobility(squareMetersPerVoltSecond - other.squareMetersPerVoltSecond)
    override fun times(factor: Number): ElectronMobility = ElectronMobility(squareMetersPerVoltSecond * factor.toDouble())
    override fun div(factor: Number): ElectronMobility = ElectronMobility(squareMetersPerVoltSecond / factor.toDouble())
}
