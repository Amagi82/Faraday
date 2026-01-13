package faraday.mechanical

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Stiffness)
 *
 * Surface tension is the tendency of liquid surfaces to shrink into the minimum surface area possible. Surface tension allows insects (e.g. water striders), usually denser than water, to float and slide on a water surface.
 *
 * At liquid–air interfaces, surface tension results from the greater attraction of liquid molecules to each other (due to cohesion) than to the molecules in the air (due to adhesion).
 *
 * [Wiki](https://en.wikipedia.org/wiki/Surface_tension)
 */
@JvmInline
value class Stiffness(val newtonsPerMeter: Double) : Units<Stiffness> {
    @InternalUnitApi
    override val rawValue: Double get() = newtonsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = Stiffness(value)
}

typealias SurfaceTension = Stiffness