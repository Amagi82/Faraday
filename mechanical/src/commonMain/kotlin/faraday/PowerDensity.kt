package faraday

import kotlin.jvm.JvmInline

/**
 * Power density is the amount of power (time rate of energy transfer) per unit volume.
 *
 * In energy transformers including batteries, fuel cells, motors, etc., and also power supply units
 * or similar, power density refers to a volume. It is then also called volume power density, which
 * is expressed as W/m3.
 *
 * In reciprocating internal combustion engines, power density—power per swept volume or brake
 * horsepower per cubic centimeter —is an important metric. This is based on the internal capacity
 * of the engine, not its external size.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Power_density)
 */
@JvmInline
value class PowerDensity(val wattsPerCubicMeter: Double) : Units<PowerDensity> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerCubicMeter

    @InternalUnitApi
    override fun create(value: Double) = PowerDensity(value)
}
