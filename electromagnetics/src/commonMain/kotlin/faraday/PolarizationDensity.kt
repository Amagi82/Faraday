package faraday

import kotlin.jvm.JvmInline

/**
 * In classical electromagnetism, polarization density (or electric polarization, or simply polarization)
 * is the vector field that expresses the density of permanent or induced electric dipole moments in a
 * dielectric material. When a dielectric is placed in an external electric field, its molecules gain
 * electric dipole moment and the dielectric is said to be polarized. The electric dipole moment induced
 * per unit volume of the dielectric material is called the electric polarization of the dielectric.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Polarization_density)
 */
@JvmInline
value class PolarizationDensity(val coulombsPerSquareMeter: Double) : Units<PolarizationDensity> {
    @InternalUnitApi
    override val rawValue: Double get() = coulombsPerSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = PolarizationDensity(value)
}
