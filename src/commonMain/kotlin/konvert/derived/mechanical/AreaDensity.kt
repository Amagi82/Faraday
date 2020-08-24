package konvert.derived.mechanical

import konvert.Units

/**
 * The area density (also known as areal density, surface density, superficial density, areic
 * density, mass thickness, column density, or density thickness) of a two-dimensional object
 * is calculated as the mass per unit area. In the paper and fabric industries, it is called
 * grammage and is expressed in grams per square meter (gsm); for paper in particular, it may
 * be expressed as pounds per ream of standard sizes ("basis ream").
 *
 * @see https://en.wikipedia.org/wiki/Area_density
 * */
inline class AreaDensity(val kgPerSquareMeter: Double) : Units<AreaDensity> {
    override val value: Double get() = kgPerSquareMeter
    override fun plus(other: AreaDensity): AreaDensity = AreaDensity(kgPerSquareMeter + other.kgPerSquareMeter)
    override fun minus(other: AreaDensity): AreaDensity = AreaDensity(kgPerSquareMeter - other.kgPerSquareMeter)
    override fun times(factor: Number): AreaDensity = AreaDensity(kgPerSquareMeter * factor.toDouble())
    override fun div(factor: Number): AreaDensity = AreaDensity(kgPerSquareMeter / factor.toDouble())
}
