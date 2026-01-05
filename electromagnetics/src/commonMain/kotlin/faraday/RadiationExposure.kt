package faraday

import kotlin.jvm.JvmInline

/**
 * Radiation exposure is a measure of the ionization of air due to ionizing radiation from photons;
 * that is, gamma rays and X-rays.[1] It is defined as the electric charge freed by such radiation
 * in a specified volume of air divided by the mass of that air.
 *
 * The SI unit of exposure is the coulomb per kilogram (C/kg), which has largely replaced the roentgen (R).
 *
 * As a measure of radiation damage exposure has been superseded by the concept of absorbed dose which
 * takes into account the absorption characteristic of the target material.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiation_exposure)
 */
@JvmInline
value class RadiationExposure(val coulombsPerKg: Double) : Units<RadiationExposure> {
    val rontgens get() = coulombsPerKg / RONTGEN

    @InternalUnitApi
    override val rawValue: Double get() = coulombsPerKg

    @InternalUnitApi
    override fun create(value: Double) = RadiationExposure(value)

    companion object {
        const val RONTGEN = 2.58e-4
    }
}
