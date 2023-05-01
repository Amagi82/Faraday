package faraday.derived.mechanical

import faraday.Units
import faraday.base.Distance
import faraday.derived.Force
import kotlin.jvm.JvmInline

/**
 * Stiffness is the extent to which an object resists deformation in response to an applied force.
 *
 * @see https://en.wikipedia.org/wiki/Stiffness
 * */
@JvmInline
value class Stiffness(val newtonsPerMeter: Double) : Units<Stiffness> {
    override fun plus(other: Stiffness) = Stiffness(newtonsPerMeter = newtonsPerMeter + other.newtonsPerMeter)
    override fun minus(other: Stiffness) = Stiffness(newtonsPerMeter = newtonsPerMeter - other.newtonsPerMeter)
    override fun times(factor: Number) = Stiffness(newtonsPerMeter = newtonsPerMeter * factor.toDouble())
    override fun div(factor: Number) = Stiffness(newtonsPerMeter = newtonsPerMeter / factor.toDouble())
    override fun compareTo(other: Stiffness): Int = newtonsPerMeter.compareTo(other.newtonsPerMeter)

    operator fun times(distance: Distance) = Force(newtons = newtonsPerMeter * distance.meters)
}
