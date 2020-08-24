package konvert.derived.photometric

import konvert.Units

/**
 * In photography, exposure is the amount of light per unit area (the image plane illuminance
 * times the exposure time) reaching a frame of photographic film or the surface of an electronic
 * image sensor, as determined by shutter speed, lens aperture, and scene luminance. Exposure is
 * measured in lux seconds, and can be computed from exposure value (EV) and scene luminance in a
 * specified region.
 *
 * @see https://en.wikipedia.org/wiki/Exposure_(photography)#Photometric_and_radiometric_exposure
 * */
inline class LuminousExposure(val luxSeconds: Double) : Units<LuminousExposure> {
    override val value: Double get() = luxSeconds
    override fun plus(other: LuminousExposure): LuminousExposure = LuminousExposure(luxSeconds + other.luxSeconds)
    override fun minus(other: LuminousExposure): LuminousExposure = LuminousExposure(luxSeconds - other.luxSeconds)
    override fun times(factor: Number): LuminousExposure = LuminousExposure(luxSeconds * factor.toDouble())
    override fun div(factor: Number): LuminousExposure = LuminousExposure(luxSeconds / factor.toDouble())
}
