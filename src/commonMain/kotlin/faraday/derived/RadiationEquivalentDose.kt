package faraday.derived

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Equivalent dose is a dose quantity H representing the stochastic health effects of low levels
 * of ionizing radiation on the human body which represents the probability of radiation-induced
 * cancer and genetic damage. It is derived from the physical quantity absorbed dose, but also
 * takes into account the biological effectiveness of the radiation, which is dependent on the
 * radiation type and energy. In the SI system of units, the unit of measure is the sievert (Sv).
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Equivalent_dose)
 */
@JvmInline
value class RadiationEquivalentDose(val sieverts: Double) : Units<RadiationEquivalentDose> {
    val rems get() = sieverts / REM

    override fun plus(other: RadiationEquivalentDose) = RadiationEquivalentDose(sieverts = sieverts + other.sieverts)
    override fun minus(other: RadiationEquivalentDose) = RadiationEquivalentDose(sieverts = sieverts - other.sieverts)
    override fun times(factor: Number) = RadiationEquivalentDose(sieverts = sieverts * factor.toDouble())
    override fun div(factor: Number) = RadiationEquivalentDose(sieverts = sieverts / factor.toDouble())
    override fun compareTo(other: RadiationEquivalentDose): Int = sieverts.compareTo(other.sieverts)

    companion object {
        const val REM = 0.01
    }
}

val Number.sieverts get() = RadiationEquivalentDose(toDouble())
