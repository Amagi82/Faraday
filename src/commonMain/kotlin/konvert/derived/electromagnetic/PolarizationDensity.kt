package konvert.derived.electromagnetic

import konvert.Units

/**
 * In classical electromagnetism, polarization density (or electric polarization, or simply polarization)
 * is the vector field that expresses the density of permanent or induced electric dipole moments in a
 * dielectric material. When a dielectric is placed in an external electric field, its molecules gain
 * electric dipole moment and the dielectric is said to be polarized. The electric dipole moment induced
 * per unit volume of the dielectric material is called the electric polarization of the dielectric.
 *
 * @see https://en.wikipedia.org/wiki/Polarization_density
 * */
inline class PolarizationDensity(val coulombsPerSquareMeter: Double) : Units<PolarizationDensity> {
    override val value: Double get() = coulombsPerSquareMeter
    override fun plus(other: PolarizationDensity): PolarizationDensity = PolarizationDensity(coulombsPerSquareMeter + other.coulombsPerSquareMeter)
    override fun minus(other: PolarizationDensity): PolarizationDensity = PolarizationDensity(coulombsPerSquareMeter - other.coulombsPerSquareMeter)
    override fun times(factor: Number): PolarizationDensity = PolarizationDensity(coulombsPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): PolarizationDensity = PolarizationDensity(coulombsPerSquareMeter / factor.toDouble())
}
