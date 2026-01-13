package faraday.thermodynamics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The specific heat capacity,(symbol Cp) of a substance is the heat capacity of a sample of the substance divided by the mass of the sample. Informally, it is the amount of energy that must be added, in the form of heat, to one unit of mass of the substance in order to cause an increase of one unit in its temperature.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Specific_heat_capacity)
 */
@JvmInline
value class SpecificHeatCapacity(val joulesPerKilogramKelvin: Double) : Units<SpecificHeatCapacity> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerKilogramKelvin

    @InternalUnitApi
    override fun create(value: Double) = SpecificHeatCapacity(value)
}
