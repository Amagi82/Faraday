package faraday.derived.molar

import faraday.Units

/**
 * @see https://en.wikipedia.org/wiki/Specificity_constant
 * */
inline class CatalyticEfficiency(val cubicMetersPerMoleSecond: Double) : Units<CatalyticEfficiency> {
    override fun plus(other: CatalyticEfficiency) = CatalyticEfficiency(cubicMetersPerMoleSecond = cubicMetersPerMoleSecond + other.cubicMetersPerMoleSecond)
    override fun minus(other: CatalyticEfficiency) = CatalyticEfficiency(cubicMetersPerMoleSecond = cubicMetersPerMoleSecond - other.cubicMetersPerMoleSecond)
    override fun times(factor: Number) = CatalyticEfficiency(cubicMetersPerMoleSecond = cubicMetersPerMoleSecond * factor.toDouble())
    override fun div(factor: Number) = CatalyticEfficiency(cubicMetersPerMoleSecond = cubicMetersPerMoleSecond / factor.toDouble())
    override fun compareTo(other: CatalyticEfficiency): Int = cubicMetersPerMoleSecond.compareTo(other.cubicMetersPerMoleSecond)
}
