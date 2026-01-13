package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * An electric field surrounds an electric charge, and exerts force on other charges in the field, attracting or repelling them. Electric fields are created by electric charges, or by time-varying magnetic fields. Electric fields and magnetic fields are both manifestations of the electromagnetic force, one of the four fundamental forces (or interactions) of nature.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Electric_field)
 */
@JvmInline
value class ElectricFieldStrength(val voltsPerMeter: Double) : Units<ElectricFieldStrength> {
    @InternalUnitApi
    override val rawValue: Double get() = voltsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = ElectricFieldStrength(value)
}
