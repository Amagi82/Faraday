package konvert.derived

import konvert.Units

/**
 * In photometry, illuminance is the total luminous flux incident on a surface, per unit area.
 * It is a measure of how much the incident light illuminates the surface, wavelength-weighted
 * by the luminosity function to correlate with human brightness perception. Similarly, luminous
 * emittance is the luminous flux per unit area emitted from a surface. Luminous emittance is
 * also known as luminous exitance.
 *
 * In SI derived units these are measured in lux (lx), or equivalently in lumens per square metre
 * (lm·m−2). In the CGS system, the unit of illuminance is the phot, which is equal to 10000 lux.
 * The foot-candle is a non-metric unit of illuminance that is used in photography.
 *
 * Illuminance was formerly often called brightness, but this leads to confusion with other uses
 * of the word, such as to mean luminance. "Brightness" should never be used for quantitative
 * description, but only for nonquantitative references to physiological sensations and
 * perceptions of light.
 *
 * @see https://en.wikipedia.org/wiki/Illuminance
 * */
inline class Illuminance(val lux: Double) : Units<Illuminance> {
    override val value: Double get() = lux
    override fun plus(other: Illuminance): Illuminance = Illuminance(lux + other.lux)
    override fun minus(other: Illuminance): Illuminance = Illuminance(lux - other.lux)
    override fun times(factor: Number): Illuminance = Illuminance(lux * factor.toDouble())
    override fun div(factor: Number): Illuminance = Illuminance(lux / factor.toDouble())
}

val Number.lux: Illuminance get() = Illuminance(toDouble())
