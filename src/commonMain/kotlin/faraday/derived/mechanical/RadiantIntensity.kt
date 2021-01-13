package faraday.derived.mechanical

import faraday.Units

/**
 * In radiometry, radiant intensity is the radiant flux emitted, reflected, transmitted or received,
 * per unit solid angle. Radiant intensity is distinct from irradiance and radiant exitance, which
 * are often called intensity in branches of physics other than radiometry. In radio-frequency
 * engineering, radiant intensity is sometimes called radiation intensity.
 *
 * @see https://en.wikipedia.org/wiki/Radiant_intensity
 * */
inline class RadiantIntensity(val wattsPerSteradian: Double) : Units<RadiantIntensity> {
    override fun plus(other: RadiantIntensity) = RadiantIntensity(wattsPerSteradian = wattsPerSteradian + other.wattsPerSteradian)
    override fun minus(other: RadiantIntensity) = RadiantIntensity(wattsPerSteradian = wattsPerSteradian - other.wattsPerSteradian)
    override fun times(factor: Number) = RadiantIntensity(wattsPerSteradian = wattsPerSteradian * factor.toDouble())
    override fun div(factor: Number) = RadiantIntensity(wattsPerSteradian = wattsPerSteradian / factor.toDouble())
    override fun compareTo(other: RadiantIntensity): Int = wattsPerSteradian.compareTo(other.wattsPerSteradian)
}
