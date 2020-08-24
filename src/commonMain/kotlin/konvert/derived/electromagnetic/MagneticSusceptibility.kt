package konvert.derived.electromagnetic

import konvert.Units

/**
 * In electromagnetism, the magnetic susceptibility is a measure of how much a material will become
 * magnetized in an applied magnetic field. It is the ratio of magnetization M (magnetic moment per
 * unit volume) to the applied magnetizing field intensity H. This allows a simple classification,
 * into two categories, of most materials' responses to an applied magnetic field: an alignment with
 * the magnetic field, χ > 0, called paramagnetism, or an alignment against the field, χ < 0, called
 * diamagnetism.
 *
 * @see https://en.wikipedia.org/wiki/Magnetic_susceptibility
 * */
inline class MagneticSusceptibility(val metersPerHenry: Double) : Units<MagneticSusceptibility> {
    override val value: Double get() = metersPerHenry
    override fun plus(other: MagneticSusceptibility): MagneticSusceptibility = MagneticSusceptibility(metersPerHenry + other.metersPerHenry)
    override fun minus(other: MagneticSusceptibility): MagneticSusceptibility = MagneticSusceptibility(metersPerHenry - other.metersPerHenry)
    override fun times(factor: Number): MagneticSusceptibility = MagneticSusceptibility(metersPerHenry * factor.toDouble())
    override fun div(factor: Number): MagneticSusceptibility = MagneticSusceptibility(metersPerHenry / factor.toDouble())
}
