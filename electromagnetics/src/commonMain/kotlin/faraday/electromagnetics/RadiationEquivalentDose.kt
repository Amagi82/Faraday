package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Equivalent dose is a dose quantity H representing the stochastic health effects of low levels of ionizing radiation on the human body which represents the probability of radiation-induced cancer and genetic damage. It is derived from the physical quantity absorbed dose, but also takes into account the biological effectiveness of the radiation, which is dependent on the radiation type and energy. In the SI system of units, the unit of measure is the sievert (Sv).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Equivalent_dose)
 */
@JvmInline
value class RadiationEquivalentDose(val sieverts: Double) : Units<RadiationEquivalentDose> {
    val rems get() = sieverts / REM

    @InternalUnitApi
    override val rawValue: Double get() = sieverts

    @InternalUnitApi
    override fun create(value: Double) = RadiationEquivalentDose(value)

    companion object {
        const val REM = 0.01
    }
}

val Number.sieverts get() = RadiationEquivalentDose(toDouble())
