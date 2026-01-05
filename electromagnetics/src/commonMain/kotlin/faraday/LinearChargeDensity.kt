package faraday

import kotlin.jvm.JvmInline

/**
 * [Wiki](https://en.wikipedia.org/wiki/Linear_density)
 */
@JvmInline
value class LinearChargeDensity(val coulombsPerMeter: Double) : Units<LinearChargeDensity> {
    @InternalUnitApi
    override val rawValue: Double get() = coulombsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = LinearChargeDensity(value)
}
