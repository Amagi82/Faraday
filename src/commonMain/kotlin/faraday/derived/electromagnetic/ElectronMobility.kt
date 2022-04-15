package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

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
@JvmInline
value class ElectronMobility(val squareMetersPerVoltSecond: Double) : Units<ElectronMobility> {
    override fun plus(other: ElectronMobility) = ElectronMobility(squareMetersPerVoltSecond = squareMetersPerVoltSecond + other.squareMetersPerVoltSecond)
    override fun minus(other: ElectronMobility) = ElectronMobility(squareMetersPerVoltSecond = squareMetersPerVoltSecond - other.squareMetersPerVoltSecond)
    override fun times(factor: Number) = ElectronMobility(squareMetersPerVoltSecond = squareMetersPerVoltSecond * factor.toDouble())
    override fun div(factor: Number) = ElectronMobility(squareMetersPerVoltSecond = squareMetersPerVoltSecond / factor.toDouble())
    override fun compareTo(other: ElectronMobility): Int = squareMetersPerVoltSecond.compareTo(other.squareMetersPerVoltSecond)
}
