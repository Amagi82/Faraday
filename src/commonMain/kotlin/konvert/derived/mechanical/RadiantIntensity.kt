package konvert.derived.mechanical

import konvert.Units

/**
 * In radiometry, radiant intensity is the radiant flux emitted, reflected, transmitted or received,
 * per unit solid angle. Radiant intensity is distinct from irradiance and radiant exitance, which
 * are often called intensity in branches of physics other than radiometry. In radio-frequency
 * engineering, radiant intensity is sometimes called radiation intensity.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_intensity
 * */
inline class RadiantIntensity(val wattsPerSteradian: Double) : Units<RadiantIntensity> {
    override val value: Double get() = wattsPerSteradian
    override fun plus(other: RadiantIntensity): RadiantIntensity = RadiantIntensity(wattsPerSteradian + other.wattsPerSteradian)
    override fun minus(other: RadiantIntensity): RadiantIntensity = RadiantIntensity(wattsPerSteradian - other.wattsPerSteradian)
    override fun times(factor: Number): RadiantIntensity = RadiantIntensity(wattsPerSteradian * factor.toDouble())
    override fun div(factor: Number): RadiantIntensity = RadiantIntensity(wattsPerSteradian / factor.toDouble())
}
