package faraday

import kotlin.jvm.JvmInline

/**
 * [Wiki](https://en.wikipedia.org/wiki/Specificity_constant)
 */
@JvmInline
value class CatalyticEfficiency(val cubicMetersPerMoleSecond: Double) : Units<CatalyticEfficiency> {
    @InternalUnitApi
    override val rawValue: Double get() = cubicMetersPerMoleSecond

    @InternalUnitApi
    override fun create(value: Double) = CatalyticEfficiency(value)
}
