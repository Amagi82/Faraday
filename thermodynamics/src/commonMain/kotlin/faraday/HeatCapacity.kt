package faraday

import kotlin.jvm.JvmInline

/**
 * Heat capacity or thermal capacity is a physical property of matter, defined as the amount of heat
 * to be supplied to a given mass of a material to produce a unit change in its temperature.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Heat_capacity)
 */
@JvmInline
value class HeatCapacity(val joulesPerKelvin: Double) : Units<HeatCapacity> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerKelvin

    @InternalUnitApi
    override fun create(value: Double) = HeatCapacity(value)
}
