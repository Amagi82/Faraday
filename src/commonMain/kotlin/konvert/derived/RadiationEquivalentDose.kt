package konvert.derived

import konvert.Units

/**
 * Equivalent dose is a dose quantity H representing the stochastic health effects of low levels
 * of ionizing radiation on the human body which represents the probability of radiation-induced
 * cancer and genetic damage. It is derived from the physical quantity absorbed dose, but also
 * takes into account the biological effectiveness of the radiation, which is dependent on the
 * radiation type and energy. In the SI system of units, the unit of measure is the sievert (Sv).
 *
 * @see https://en.wikipedia.org/wiki/Equivalent_dose
 * */
inline class RadiationEquivalentDose(val sieverts: Double) : Units<RadiationEquivalentDose> {
    override val value: Double get() = sieverts
    override fun plus(other: RadiationEquivalentDose): RadiationEquivalentDose = RadiationEquivalentDose(sieverts + other.sieverts)
    override fun minus(other: RadiationEquivalentDose): RadiationEquivalentDose = RadiationEquivalentDose(sieverts - other.sieverts)
    override fun times(factor: Number): RadiationEquivalentDose = RadiationEquivalentDose(sieverts * factor.toDouble())
    override fun div(factor: Number): RadiationEquivalentDose = RadiationEquivalentDose(sieverts / factor.toDouble())
}

val Number.sieverts: RadiationEquivalentDose get() = RadiationEquivalentDose(toDouble())
