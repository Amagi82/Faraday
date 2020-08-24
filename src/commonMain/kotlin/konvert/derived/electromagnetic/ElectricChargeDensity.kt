package konvert.derived.electromagnetic

import konvert.Units

/**
 * In electromagnetism, charge density is the amount of electric charge per unit length, surface
 * area, or volume. Volume charge density (symbolized by the Greek letter ρ) is the quantity of
 * charge per unit volume, measured in the SI system in coulombs per cubic meter (C⋅m−3), at any
 * point in a volume. Surface charge density (σ) is the quantity of charge per unit area,
 * measured in coulombs per square meter (C⋅m−2), at any point on a surface charge distribution
 * on a two dimensional surface. Linear charge density (λ) is the quantity of charge per unit
 * length, measured in coulombs per meter (C⋅m−1), at any point on a line charge distribution.
 * Charge density can be either positive or negative, since electric charge can be either
 * positive or negative.
 *
 * @see https://en.wikipedia.org/wiki/Charge_density
 * */
inline class ElectricChargeDensity(val coulombsPerCubicMeter: Double) : Units<ElectricChargeDensity> {
    override val value: Double get() = coulombsPerCubicMeter
    override fun plus(other: ElectricChargeDensity): ElectricChargeDensity = ElectricChargeDensity(coulombsPerCubicMeter + other.coulombsPerCubicMeter)
    override fun minus(other: ElectricChargeDensity): ElectricChargeDensity = ElectricChargeDensity(coulombsPerCubicMeter - other.coulombsPerCubicMeter)
    override fun times(factor: Number): ElectricChargeDensity = ElectricChargeDensity(coulombsPerCubicMeter * factor.toDouble())
    override fun div(factor: Number): ElectricChargeDensity = ElectricChargeDensity(coulombsPerCubicMeter / factor.toDouble())
}
