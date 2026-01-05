package faraday

import kotlin.jvm.JvmInline

/**
 * Fuel efficiency is a form of thermal efficiency, meaning the ratio of effort to result of a
 * process that converts chemical potential energy contained in a carrier (fuel) into kinetic
 * energy or work. Overall fuel efficiency may vary per device, which in turn may vary per
 * application, and this spectrum of variance is often illustrated as a continuous energy
 * profile.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Fuel_efficiency)
 */
@JvmInline
value class FuelEfficiency(val metersPerCubicMeter: Double) : Units<FuelEfficiency> {
    val milesPerGallon get() = metersPerCubicMeter / MPG
    val milesPerImpGallon get() = metersPerCubicMeter / MPG_UK
    val kilometersPerLiter get() = metersPerCubicMeter / KM_PER_LITER
    val litersPer100km get() = 100.0 / kilometersPerLiter

    @InternalUnitApi
    override val rawValue: Double get() = metersPerCubicMeter

    @InternalUnitApi
    override fun create(value: Double) = FuelEfficiency(value)

    companion object {
        const val MPG = Distance.MILE / Volume.GALLON_US
        const val MPG_UK = Distance.MILE / Volume.GALLON_IMP
        const val KM_PER_LITER = 1e6
    }
}

val Number.milesPerGallon get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.MPG)
val Number.milesPerImpGallon get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.MPG_UK)
val Number.kilometersPerLiter get() = FuelEfficiency(metersPerCubicMeter = toDouble() * FuelEfficiency.KM_PER_LITER)
val Number.litersPer100km get() = FuelEfficiency(metersPerCubicMeter = 100 / (toDouble() * FuelEfficiency.KM_PER_LITER))