package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In solid-state physics, the electron mobility characterizes how quickly an electron can move through a metal or semiconductor, when pulled by an electric field. There is an analogous quantity for holes, called hole mobility. The term carrier mobility refers in general to both electron and hole mobility.
 *
 * Electron and hole mobility are special cases of electrical mobility of charged particles in a fluid under an applied electric field.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Electron_mobility)
 */
@JvmInline
value class ElectronMobility(val squareMetersPerVoltSecond: Double) : Units<ElectronMobility> {
    @InternalUnitApi
    override val rawValue: Double get() = squareMetersPerVoltSecond

    @InternalUnitApi
    override fun create(value: Double) = ElectronMobility(value)
}
