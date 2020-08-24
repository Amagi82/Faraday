package konvert.derived.mechanical

import konvert.Units
import konvert.base.Distance

/**
 * Fuel efficiency is a form of thermal efficiency, meaning the ratio of effort to result of a
 * process that converts chemical potential energy contained in a carrier (fuel) into kinetic
 * energy or work. Overall fuel efficiency may vary per device, which in turn may vary per
 * application, and this spectrum of variance is often illustrated as a continuous energy
 * profile.
 *
 * @see https://en.wikipedia.org/wiki/Fuel_efficiency
 * */
inline class FuelEfficiency(val metersPerCubicMeter: Double) : Units<FuelEfficiency> {
    override val value: Double get() = metersPerCubicMeter
    val milesPerGallon: Double get() = metersPerCubicMeter / MPG
    val milesPerImpGallon: Double get() = metersPerCubicMeter / MPG_UK
    val kilometersPerLiter: Double get() = metersPerCubicMeter / KM_PER_LITER
    val litersPer100km: Double get() = 100.0 / kilometersPerLiter

    override fun plus(other: FuelEfficiency): FuelEfficiency = FuelEfficiency(metersPerCubicMeter + other.metersPerCubicMeter)
    override fun minus(other: FuelEfficiency): FuelEfficiency = FuelEfficiency(metersPerCubicMeter - other.metersPerCubicMeter)
    override fun times(factor: Number): FuelEfficiency = FuelEfficiency(metersPerCubicMeter * factor.toDouble())
    override fun div(factor: Number): FuelEfficiency = FuelEfficiency(metersPerCubicMeter / factor.toDouble())

    companion object {
        const val MPG = Distance.MILE / Volume.GALLON_US
        const val MPG_UK = Distance.MILE / Volume.GALLON_IMP
        const val KM_PER_LITER = 1e6
    }
}

val Number.milesPerGallon: FuelEfficiency get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.MPG)
val Number.milesPerImpGallon: FuelEfficiency get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.MPG_UK)
val Number.kilometersPerLiter: FuelEfficiency get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.KM_PER_LITER)
val Number.litersPer100km: FuelEfficiency get() = FuelEfficiency(metersPerCubicMeter = 100 / (toDouble() * FuelEfficiency.KM_PER_LITER))
