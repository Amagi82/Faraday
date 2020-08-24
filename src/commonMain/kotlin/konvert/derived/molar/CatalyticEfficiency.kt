package konvert.derived.molar

import konvert.Units

/**
 * @see https://en.wikipedia.org/wiki/Specificity_constant
 * */
inline class CatalyticEfficiency(val cubicMetersPerMoleSecond: Double) : Units<CatalyticEfficiency> {
    override val value: Double get() = cubicMetersPerMoleSecond
    override fun plus(other: CatalyticEfficiency): CatalyticEfficiency = CatalyticEfficiency(cubicMetersPerMoleSecond + other.cubicMetersPerMoleSecond)
    override fun minus(other: CatalyticEfficiency): CatalyticEfficiency = CatalyticEfficiency(cubicMetersPerMoleSecond - other.cubicMetersPerMoleSecond)
    override fun times(factor: Number): CatalyticEfficiency = CatalyticEfficiency(cubicMetersPerMoleSecond * factor.toDouble())
    override fun div(factor: Number): CatalyticEfficiency = CatalyticEfficiency(cubicMetersPerMoleSecond / factor.toDouble())
}
