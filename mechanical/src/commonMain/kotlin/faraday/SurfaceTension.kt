package faraday

import kotlin.jvm.JvmInline

/**
 * Surface tension is the tendency of liquid surfaces to shrink into the minimum surface area
 * possible. Surface tension allows insects (e.g. water striders), usually denser than water,
 * to float and slide on a water surface.
 *
 * At liquid–air interfaces, surface tension results from the greater attraction of liquid
 * molecules to each other (due to cohesion) than to the molecules in the air (due to adhesion).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Surface_tension)
 */
@JvmInline
value class SurfaceTension(val newtonsPerMeter: Double) : Units<SurfaceTension> {
    @InternalUnitApi
    override val rawValue: Double get() = newtonsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = SurfaceTension(value)
}
