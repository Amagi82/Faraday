package faraday.photometrics

import faraday.Conversion
import faraday.core.Area
import faraday.core.Time
import faraday.kinematics.RadiantFlux

@Conversion(factor1 = Illuminance::class, factor2 = Time::class, resultType = LuminousExposure::class)
@Conversion(factor1 = LuminousFlux::class, factor2 = Time::class, resultType = LuminousEnergy::class)
@Conversion(factor1 = LuminousIntensity::class, factor2 = SolidAngle::class, resultType = LuminousFlux::class)
@Conversion(factor1 = Area::class, factor2 = Illuminance::class, resultType = LuminousFlux::class)
@Conversion(factor1 = LuminousEfficacy::class, factor2 = RadiantFlux::class, resultType = LuminousFlux::class)
@Conversion(factor1 = Luminance::class, factor2 = Area::class, resultType = LuminousIntensity::class)
internal object Conversions