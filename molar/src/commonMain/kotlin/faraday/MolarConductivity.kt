package faraday

import kotlin.jvm.JvmInline

/**
 * The molar conductivity of an electrolyte solution is defined as its conductivity divided by
 * its molar concentration.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Molar_conductivity)
 */
@JvmInline
value class MolarConductivity(val siemensSquareMetersPerMole: Double) : Units<MolarConductivity> {
    @InternalUnitApi
    override val rawValue: Double get() = siemensSquareMetersPerMole

    @InternalUnitApi
    override fun create(value: Double) = MolarConductivity(value)
}
