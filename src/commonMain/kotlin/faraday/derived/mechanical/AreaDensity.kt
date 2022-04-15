package faraday.derived.mechanical

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * The area density (also known as areal density, surface density, superficial density, areic
 * density, mass thickness, column density, or density thickness) of a two-dimensional object
 * is calculated as the mass per unit area. In the paper and fabric industries, it is called
 * grammage and is expressed in grams per square meter (gsm); for paper in particular, it may
 * be expressed as pounds per ream of standard sizes ("basis ream").
 *
 * @see https://en.wikipedia.org/wiki/Area_density
 * */
@JvmInline
value class AreaDensity(val kgPerSquareMeter: Double) : Units<AreaDensity> {
    override fun plus(other: AreaDensity) = AreaDensity(kgPerSquareMeter = kgPerSquareMeter + other.kgPerSquareMeter)
    override fun minus(other: AreaDensity) = AreaDensity(kgPerSquareMeter = kgPerSquareMeter - other.kgPerSquareMeter)
    override fun times(factor: Number) = AreaDensity(kgPerSquareMeter = kgPerSquareMeter * factor.toDouble())
    override fun div(factor: Number) = AreaDensity(kgPerSquareMeter = kgPerSquareMeter / factor.toDouble())
    override fun compareTo(other: AreaDensity): Int = kgPerSquareMeter.compareTo(other.kgPerSquareMeter)
}
