package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * [Wiki](https://en.wikipedia.org/wiki/Linear_density)
 */
@JvmInline
value class LinearChargeDensity(val coulombsPerMeter: Double) : Units<LinearChargeDensity> {
    override fun plus(other: LinearChargeDensity) = LinearChargeDensity(coulombsPerMeter = coulombsPerMeter + other.coulombsPerMeter)
    override fun minus(other: LinearChargeDensity) = LinearChargeDensity(coulombsPerMeter = coulombsPerMeter - other.coulombsPerMeter)
    override fun times(factor: Number) = LinearChargeDensity(coulombsPerMeter = coulombsPerMeter * factor.toDouble())
    override fun div(factor: Number) = LinearChargeDensity(coulombsPerMeter = coulombsPerMeter / factor.toDouble())
    override fun compareTo(other: LinearChargeDensity): Int = coulombsPerMeter.compareTo(other.coulombsPerMeter)
}
