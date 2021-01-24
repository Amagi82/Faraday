package faraday.derived.molar

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The molar volume is the volume occupied divided by the amount of substance (of a chemical element
 * or chemical compound) at a given temperature and pressure. It is equal to the molar mass (M)
 * divided by the mass density (ρ). It has the SI unit cubic metres per mole (m3/mol), although it
 * is typically more practical to use the units cubic decimetres per mole (dm3/mol) for gases and
 * cubic centimetres per mole (cm3/mol) for liquids and solids.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Molar_volume)
 */
@JvmInline
value class MolarVolume(val cubicMetersPerMole: Double) : Units<MolarVolume> {
    override fun plus(other: MolarVolume) = MolarVolume(cubicMetersPerMole = cubicMetersPerMole + other.cubicMetersPerMole)
    override fun minus(other: MolarVolume) = MolarVolume(cubicMetersPerMole = cubicMetersPerMole - other.cubicMetersPerMole)
    override fun times(factor: Number) = MolarVolume(cubicMetersPerMole = cubicMetersPerMole * factor.toDouble())
    override fun div(factor: Number) = MolarVolume(cubicMetersPerMole = cubicMetersPerMole / factor.toDouble())
    override fun compareTo(other: MolarVolume): Int = cubicMetersPerMole.compareTo(other.cubicMetersPerMole)
}
