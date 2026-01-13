package faraday.photometrics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In photography, exposure is the amount of light per unit area (the image plane illuminance times the exposure time) reaching a frame of photographic film or the surface of an electronic image sensor, as determined by shutter speed, lens aperture, and scene luminance. Exposure is measured in lux seconds, and can be computed from exposure value (EV) and scene luminance in a specified region.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Exposure_(photography)#Photometric_and_radiometric_exposure
 */
@JvmInline
value class LuminousExposure(val luxSeconds: Double) : Units<LuminousExposure> {
    @InternalUnitApi
    override val rawValue: Double get() = luxSeconds

    @InternalUnitApi
    override fun create(value: Double) = LuminousExposure(value)
}
