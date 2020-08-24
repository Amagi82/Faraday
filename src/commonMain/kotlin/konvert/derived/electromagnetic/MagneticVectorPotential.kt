package konvert.derived.electromagnetic

import konvert.Units

/**
 * Magnetic vector potential, A, is the vector quantity in classical electromagnetism defined so that
 * its curl is equal to the magnetic field. Together with the electric potential φ, the magnetic vector
 * potential can be used to specify the electric field E as well. Therefore, many equations of
 * electromagnetism can be written either in terms of the fields E and B, or equivalently in terms of
 * the potentials φ and A. In more advanced theories such as quantum mechanics, most equations use
 * potentials rather than fields.
 *
 * @see https://en.wikipedia.org/wiki/Magnetic_vector_potential
 * */
inline class MagneticVectorPotential(val webersPerMeter: Double) : Units<MagneticVectorPotential> {
    override val value: Double get() = webersPerMeter
    override fun plus(other: MagneticVectorPotential): MagneticVectorPotential = MagneticVectorPotential(webersPerMeter + other.webersPerMeter)
    override fun minus(other: MagneticVectorPotential): MagneticVectorPotential = MagneticVectorPotential(webersPerMeter - other.webersPerMeter)
    override fun times(factor: Number): MagneticVectorPotential = MagneticVectorPotential(webersPerMeter * factor.toDouble())
    override fun div(factor: Number): MagneticVectorPotential = MagneticVectorPotential(webersPerMeter / factor.toDouble())
}
