package faraday.derived

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Absorbed dose is a dose quantity which is the measure of the energy deposited in matter
 * by ionizing radiation per unit mass. Absorbed dose is used in the calculation of dose
 * uptake in living tissue in both radiation protection (reduction of harmful effects),
 * and radiology (potential beneficial effects for example in cancer treatment). It is
 * also used to directly compare the effect of radiation on inanimate matter such as in
 * radiation hardening.
 *
 * The SI unit of measure is the gray (Gy), which is defined as one Joule of energy
 * absorbed per kilogram of matter. The older, non-SI CGS unit rad, is sometimes also
 * used, predominantly in the USA.
 *
 * @see https://en.wikipedia.org/wiki/Absorbed_dose
 * */
@JvmInline
value class RadiationAbsorbedDose(val grays: Double) : Units<RadiationAbsorbedDose> {
    val ergsPerGram get() = grays / 1e-4
    val rads get() = grays / RAD

    override fun plus(other: RadiationAbsorbedDose) = RadiationAbsorbedDose(grays = grays + other.grays)
    override fun minus(other: RadiationAbsorbedDose) = RadiationAbsorbedDose(grays = grays - other.grays)
    override fun times(factor: Number) = RadiationAbsorbedDose(grays = grays * factor.toDouble())
    override fun div(factor: Number) = RadiationAbsorbedDose(grays = grays / factor.toDouble())
    override fun compareTo(other: RadiationAbsorbedDose): Int = grays.compareTo(other.grays)

    companion object {
        const val RAD = 0.01
    }
}

val Number.grays get() = RadiationAbsorbedDose(toDouble())
