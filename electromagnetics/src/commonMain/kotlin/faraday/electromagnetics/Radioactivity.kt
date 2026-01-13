package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Specific activity is the activity per quantity of a radionuclide and is a physical property of that radionuclide.
 *
 * Activity is a quantity related to radioactivity, for which the SI unit is the becquerel (Bq), equal to one reciprocal second. The becquerel is defined as the number of radioactive transformations per second that occur in a particular radionuclide. The older, non-SI unit of activity is the curie (Ci), which is 3.7×1010 transformations per second.
 *
 * Since the probability of radioactive decay for a given radionuclide is a fixed physical quantity (with some slight exceptions, see changing decay rates), the number of decays that occur in a given time of a specific number of atoms of that radionuclide is also a fixed physical quantity (if there are large enough numbers of atoms to ignore statistical fluctuations).
 *
 * Thus, specific activity is defined as the activity per quantity of atoms of a particular radionuclide. It is usually given in units of Bq/g, but another commonly used unit of activity is the curie (Ci) allowing the definition of specific activity in Ci/g. The amount of specific activity should not be confused with level of exposure to ionizing radiation and thus the exposure or absorbed dose. The absorbed dose is the quantity important in assessing the effects of ionizing radiation on humans.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Specific_activity)
 */
@JvmInline
value class Radioactivity(val becquerels: Double) : Units<Radioactivity> {
    val curies get() = becquerels / CURIE
    val rutherfords get() = becquerels / RUTHERFORD

    @InternalUnitApi
    override val rawValue: Double get() = becquerels

    @InternalUnitApi
    override fun create(value: Double) = Radioactivity(value)

    companion object {
        const val CURIE = 3.7e10
        const val RUTHERFORD = 1e6
    }
}

val Number.becquerels get() = Radioactivity(toDouble())
