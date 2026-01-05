package faraday

import kotlin.jvm.JvmInline

/**
 * In radiometry, radiant intensity is the radiant flux emitted, reflected, transmitted or received,
 * per unit solid angle. Radiant intensity is distinct from irradiance and radiant exitance, which
 * are often called intensity in branches of physics other than radiometry. In radio-frequency
 * engineering, radiant intensity is sometimes called radiation intensity.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Radiant_intensity)
 */
@JvmInline
value class RadiantIntensity(val wattsPerSteradian: Double) : Units<RadiantIntensity> {
    @InternalUnitApi
    override val rawValue: Double get() = wattsPerSteradian

    @InternalUnitApi
    override fun create(value: Double) = RadiantIntensity(value)
}
