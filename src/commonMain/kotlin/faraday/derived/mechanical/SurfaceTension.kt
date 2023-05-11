package faraday.derived.mechanical

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Surface tension is the tendency of liquid surfaces to shrink into the minimum surface area
 * possible. Surface tension allows insects (e.g. water striders), usually denser than water,
 * to float and slide on a water surface.
 *
 * At liquid–air interfaces, surface tension results from the greater attraction of liquid
 * molecules to each other (due to cohesion) than to the molecules in the air (due to adhesion).
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Surface_tension)
 */
@JvmInline
value class SurfaceTension(val newtonsPerMeter: Double) : Units<SurfaceTension> {
    override fun plus(other: SurfaceTension) = SurfaceTension(newtonsPerMeter = newtonsPerMeter + other.newtonsPerMeter)
    override fun minus(other: SurfaceTension) = SurfaceTension(newtonsPerMeter = newtonsPerMeter - other.newtonsPerMeter)
    override fun times(factor: Number) = SurfaceTension(newtonsPerMeter = newtonsPerMeter * factor.toDouble())
    override fun div(factor: Number) = SurfaceTension(newtonsPerMeter = newtonsPerMeter / factor.toDouble())
    override fun compareTo(other: SurfaceTension): Int = newtonsPerMeter.compareTo(other.newtonsPerMeter)
}
