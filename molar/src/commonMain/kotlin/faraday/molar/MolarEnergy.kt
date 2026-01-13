package faraday.molar

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The joule per mole (symbol: J·mol−1 or J/mol) is the unit of molar energy, which is the ratio of energy to amount of substance in the International System of Units (SI).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Joule_per_mole)
 */
@JvmInline
value class MolarEnergy(val joulesPerMole: Double) : Units<MolarEnergy> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerMole

    @InternalUnitApi
    override fun create(value: Double) = MolarEnergy(value)
}
