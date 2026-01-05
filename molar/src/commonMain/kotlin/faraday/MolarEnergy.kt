package faraday

import kotlin.jvm.JvmInline

/**
 * [Wiki](https://en.wikipedia.org/wiki/Energy)
 */
@JvmInline
value class MolarEnergy(val joulesPerMole: Double) : Units<MolarEnergy> {
    @InternalUnitApi
    override val rawValue: Double get() = joulesPerMole

    @InternalUnitApi
    override fun create(value: Double) = MolarEnergy(value)
}
