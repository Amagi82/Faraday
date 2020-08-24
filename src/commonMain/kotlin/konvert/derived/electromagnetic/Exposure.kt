package konvert.derived.electromagnetic

import konvert.Units

/**
 * @see https://en.wikipedia.org/wiki/Ionizing_radiation
 * */
inline class Exposure(val coulombsPerKg: Double) : Units<Exposure> {
    override val value: Double get() = coulombsPerKg
    override fun plus(other: Exposure): Exposure = Exposure(coulombsPerKg + other.coulombsPerKg)
    override fun minus(other: Exposure): Exposure = Exposure(coulombsPerKg - other.coulombsPerKg)
    override fun times(factor: Number): Exposure = Exposure(coulombsPerKg * factor.toDouble())
    override fun div(factor: Number): Exposure = Exposure(coulombsPerKg / factor.toDouble())
}
