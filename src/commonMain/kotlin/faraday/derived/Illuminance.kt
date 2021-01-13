package faraday.derived

import faraday.Units
import faraday.base.Time
import faraday.derived.photometric.LuminousExposure

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
    override fun plus(other: Illuminance) = Illuminance(lux = lux + other.lux)
    override fun minus(other: Illuminance) = Illuminance(lux = lux - other.lux)
    override fun times(factor: Number) = Illuminance(lux = lux * factor.toDouble())
    override fun div(factor: Number) = Illuminance(lux = lux / factor.toDouble())
    override fun compareTo(other: Illuminance): Int = lux.compareTo(other.lux)

    operator fun times(time: Time) = LuminousExposure(luxSeconds = lux * time.seconds)
}

val Number.lux get() = Illuminance(toDouble())
