package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In radiometry, irradiance is the radiant flux (power) received by a surface per unit area. Irradiance is often called intensity, but this term is avoided in radiometry where such usage leads to confusion with radiant intensity. In astrophysics, irradiance is called radiant flux.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Irradiance)
 */
@JvmInline
value class Irradiance(val wattsPerSquareMeter: Double) : Units<Irradiance> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerSquareMeter

    @InternalUnitApi
    override fun create(value: Double) = Irradiance(value)
}
typealias HeatFluxDensity = Irradiance
