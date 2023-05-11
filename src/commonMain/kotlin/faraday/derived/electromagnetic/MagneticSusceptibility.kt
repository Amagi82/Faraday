package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In electromagnetism, the magnetic susceptibility is a measure of how much a material will become
 * magnetized in an applied magnetic field. It is the ratio of magnetization M (magnetic moment per
 * unit volume) to the applied magnetizing field intensity H. This allows a simple classification,
 * into two categories, of most materials' responses to an applied magnetic field: an alignment with
 * the magnetic field, χ > 0, called paramagnetism, or an alignment against the field, χ < 0, called
 * diamagnetism.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetic_susceptibility)
 */
@JvmInline
value class MagneticSusceptibility(val metersPerHenry: Double) : Units<MagneticSusceptibility> {
    override fun plus(other: MagneticSusceptibility) = MagneticSusceptibility(metersPerHenry = metersPerHenry + other.metersPerHenry)
    override fun minus(other: MagneticSusceptibility) = MagneticSusceptibility(metersPerHenry = metersPerHenry - other.metersPerHenry)
    override fun times(factor: Number) = MagneticSusceptibility(metersPerHenry = metersPerHenry * factor.toDouble())
    override fun div(factor: Number) = MagneticSusceptibility(metersPerHenry = metersPerHenry / factor.toDouble())
    override fun compareTo(other: MagneticSusceptibility): Int = metersPerHenry.compareTo(other.metersPerHenry)
}
