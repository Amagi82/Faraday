package faraday.derived.mechanical

import faraday.Prefixes
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Thermal expansion is the tendency of matter to increase in length, area, or volume, changing
 *
 * In materials science, fracture toughness is the critical stress intensity factor of a sharp
 * crack where propagation of the crack suddenly becomes rapid and unlimited. It is a material
 * property that quantifies its ability to resist crack propagation and failure under applied
 * stress. A component's thickness affects the constraint conditions at the tip of a crack with
 * thin components having plane stress conditions, leading to ductile behavior and thick
 * components having plane strain conditions, where the constraint increases, leading to brittle
 * failure. Plane strain conditions give the lowest fracture toughness value which is a material
 * property. The critical value of stress intensity factor in mode I loading measured under
 * plane strain conditions is known as the plane strain fracture toughness, denoted KIc
 *
 * When a test fails to meet the thickness and other test requirements that are in place to
 * ensure plane strain conditions, the fracture toughness value produced is given the
 * designation Kc
 *
 * [Wiki](https://en.wikipedia.org/wiki/Fracture_toughness)
 */
@JvmInline
value class FractureToughness(val pascalsPerSqRootMeter: Double) : Units<FractureToughness> {
    val megapascalsPerSqRootMeter: Double get() = pascalsPerSqRootMeter / Prefixes.MEGA
    override fun plus(other: FractureToughness) = FractureToughness(pascalsPerSqRootMeter = pascalsPerSqRootMeter + other.pascalsPerSqRootMeter)
    override fun minus(other: FractureToughness) = FractureToughness(pascalsPerSqRootMeter = pascalsPerSqRootMeter - other.pascalsPerSqRootMeter)
    override fun times(factor: Number) = FractureToughness(pascalsPerSqRootMeter = pascalsPerSqRootMeter * factor.toDouble())
    override fun div(factor: Number) = FractureToughness(pascalsPerSqRootMeter = pascalsPerSqRootMeter / factor.toDouble())
    override fun compareTo(other: FractureToughness): Int = pascalsPerSqRootMeter.compareTo(other.pascalsPerSqRootMeter)
}
