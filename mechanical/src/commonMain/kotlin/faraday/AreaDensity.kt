package faraday

import kotlin.jvm.JvmInline

/**
 * The area density (also known as areal density, surface density, superficial density, areic
 * density, mass thickness, column density, or density thickness) of a two-dimensional object
 * is calculated as the mass per unit area. In the paper and fabric industries, it is called
 * grammage and is expressed in grams per square meter (gsm); for paper in particular, it may
 * be expressed as pounds per ream of standard sizes ("basis ream").
 *
 * [Wiki](https://en.wikipedia.org/wiki/Area_density)
 */
@JvmInline
value class AreaDensity(val kgPerSquareMeter: Double) : Units<AreaDensity> {
    @InternalUnitApi
    override val rawValue: Double get() = kgPerSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = AreaDensity(value)
}
