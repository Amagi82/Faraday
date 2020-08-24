package konvert.derived.mechanical

import konvert.Units

/**
 * Specific energy or massic energy is energy per unit mass. It is also sometimes called
 * gravimetric energy density, or just energy density though energy density more precisely
 * means energy per unit volume. It is used to quantify, for example, stored heat and other
 * thermodynamic properties of substances such as specific internal energy, specific enthalpy,
 * specific Gibbs free energy, and specific Helmholtz free energy. It may also be used for
 * the kinetic energy or potential energy of a body. Specific energy is an intensive property,
 * whereas energy and mass are extensive properties.
 *
 * @see https://en.wikipedia.org/wiki/Specific_energy
 * */
inline class SpecificEnergy(val joulesPerKilogram: Double) : Units<SpecificEnergy> {
    override val value: Double get() = joulesPerKilogram
    override fun plus(other: SpecificEnergy): SpecificEnergy = SpecificEnergy(joulesPerKilogram + other.joulesPerKilogram)
    override fun minus(other: SpecificEnergy): SpecificEnergy = SpecificEnergy(joulesPerKilogram - other.joulesPerKilogram)
    override fun times(factor: Number): SpecificEnergy = SpecificEnergy(joulesPerKilogram * factor.toDouble())
    override fun div(factor: Number): SpecificEnergy = SpecificEnergy(joulesPerKilogram / factor.toDouble())
}
