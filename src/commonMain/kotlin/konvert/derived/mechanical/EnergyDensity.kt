package konvert.derived.mechanical

import konvert.Units

/**
 * Energy density is the amount of energy stored in a given system or region of space per unit
 * volume. Colloquially it may also be used for energy per unit mass, though the accurate term
 * for this is specific energy. Often only the useful or extractable energy is measured, which
 * is to say that inaccessible energy (such as rest mass energy) is ignored. In cosmological and
 * other general relativistic contexts, however, the energy densities considered are those that
 * correspond to the elements of the stress–energy tensor and therefore do include mass energy
 * as well as energy densities associated with the pressures described in the next paragraph.
 *
 * Energy per unit volume has the same physical units as pressure, and in many circumstances is
 * a synonym: for example, the energy density of a magnetic field may be expressed as (and
 * behaves as) a physical pressure, and the energy required to compress a compressed gas a little
 * more may be determined by multiplying the difference between the gas pressure and the external
 * pressure by the change in volume. In short, pressure is a measure of the enthalpy per unit
 * volume of a system. A pressure gradient has the potential to perform work on the surroundings
 * by converting enthalpy to work until equilibrium is reached.
 *
 * @see https://en.wikipedia.org/wiki/Energy_density
 * */
inline class EnergyDensity(val joulesPerCubicMeter: Double) : Units<EnergyDensity> {
    override val value: Double get() = joulesPerCubicMeter
    override fun plus(other: EnergyDensity): EnergyDensity = EnergyDensity(joulesPerCubicMeter + other.joulesPerCubicMeter)
    override fun minus(other: EnergyDensity): EnergyDensity = EnergyDensity(joulesPerCubicMeter - other.joulesPerCubicMeter)
    override fun times(factor: Number): EnergyDensity = EnergyDensity(joulesPerCubicMeter * factor.toDouble())
    override fun div(factor: Number): EnergyDensity = EnergyDensity(joulesPerCubicMeter / factor.toDouble())
}
