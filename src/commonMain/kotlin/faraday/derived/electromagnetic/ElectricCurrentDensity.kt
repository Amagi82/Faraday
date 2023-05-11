package faraday.derived.electromagnetic

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In electromagnetism, current density is the amount of charge per unit time that flows through
 * a unit area of a chosen cross section. The current density vector is defined as a vector whose
 * magnitude is the electric current per cross-sectional area at a given point in space, its
 * direction being that of the motion of the positive charges at this point. In SI base units,
 * the electric current density is measured in amperes per square metre.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Current_density)
 */
@JvmInline
value class ElectricCurrentDensity(val amperesPerSquareMeter: Double) : Units<ElectricCurrentDensity> {
    override fun plus(other: ElectricCurrentDensity) = ElectricCurrentDensity(amperesPerSquareMeter = amperesPerSquareMeter + other.amperesPerSquareMeter)
    override fun minus(other: ElectricCurrentDensity) = ElectricCurrentDensity(amperesPerSquareMeter = amperesPerSquareMeter - other.amperesPerSquareMeter)
    override fun times(factor: Number) = ElectricCurrentDensity(amperesPerSquareMeter = amperesPerSquareMeter * factor.toDouble())
    override fun div(factor: Number) = ElectricCurrentDensity(amperesPerSquareMeter = amperesPerSquareMeter / factor.toDouble())
    override fun compareTo(other: ElectricCurrentDensity): Int = amperesPerSquareMeter.compareTo(other.amperesPerSquareMeter)
}
