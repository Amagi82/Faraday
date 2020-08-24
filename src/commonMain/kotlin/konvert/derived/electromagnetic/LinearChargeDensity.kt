package konvert.derived.electromagnetic

import konvert.Units

/**
 * @see https://en.wikipedia.org/wiki/Linear_density
 * */
inline class LinearChargeDensity(val coulombsPerMeter: Double) : Units<LinearChargeDensity> {
    override val value: Double get() = coulombsPerMeter
    override fun plus(other: LinearChargeDensity): LinearChargeDensity = LinearChargeDensity(coulombsPerMeter + other.coulombsPerMeter)
    override fun minus(other: LinearChargeDensity): LinearChargeDensity = LinearChargeDensity(coulombsPerMeter - other.coulombsPerMeter)
    override fun times(factor: Number): LinearChargeDensity = LinearChargeDensity(coulombsPerMeter * factor.toDouble())
    override fun div(factor: Number): LinearChargeDensity = LinearChargeDensity(coulombsPerMeter / factor.toDouble())
}
