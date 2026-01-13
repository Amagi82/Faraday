package faraday.photometrics

import faraday.core.Area
import faraday.core.Time
import faraday.kinematics.RadiantFlux

operator fun Illuminance.times(time: Time) = LuminousExposure(luxSeconds = lux * time.seconds)
operator fun Time.times(illuminance: Illuminance): LuminousExposure = illuminance * this
operator fun LuminousExposure.div(illuminance: Illuminance) = Time(seconds = luxSeconds / illuminance.lux)
operator fun LuminousExposure.div(time: Time) = Illuminance(lux = luxSeconds / time.seconds)

operator fun LuminousFlux.times(time: Time) = LuminousEnergy(lumenSeconds = lumens * time.seconds)
operator fun Time.times(flux: LuminousFlux): LuminousEnergy = flux * this
operator fun LuminousEnergy.div(time: Time) = LuminousFlux(lumens = lumenSeconds / time.seconds)
operator fun LuminousEnergy.div(flux: LuminousFlux) = Time(seconds = lumenSeconds / flux.lumens)

operator fun LuminousIntensity.times(angle: SolidAngle) = LuminousFlux(lumens = candelas * angle.steradians)
operator fun SolidAngle.times(intensity: LuminousIntensity): LuminousFlux = intensity * this
operator fun LuminousFlux.div(intensity: LuminousIntensity) = SolidAngle(steradians = lumens / intensity.candelas)
operator fun LuminousFlux.div(angle: SolidAngle) = LuminousIntensity(candelas = lumens / angle.steradians)

operator fun Area.times(illuminance: Illuminance) = LuminousFlux(lumens = squareMeters * illuminance.lux)
operator fun Illuminance.times(area: Area): LuminousFlux = area * this
operator fun LuminousFlux.div(area: Area) = Illuminance(lux = lumens / area.squareMeters)
operator fun LuminousFlux.div(illuminance: Illuminance) = Area(squareMeters = lumens / illuminance.lux)

operator fun LuminousEfficacy.times(radiantFlux: RadiantFlux) = LuminousFlux(lumens = lumensPerWatt * radiantFlux.watts)
operator fun RadiantFlux.times(luminousEfficacy: LuminousEfficacy): LuminousFlux = luminousEfficacy * this
operator fun LuminousFlux.div(flux: RadiantFlux) = LuminousEfficacy(lumensPerWatt = lumens / flux.watts)
operator fun LuminousFlux.div(luminousEfficacy: LuminousEfficacy) = RadiantFlux(watts = lumens / luminousEfficacy.lumensPerWatt)

operator fun Luminance.times(area: Area) = LuminousIntensity(candelas = candelasPerSquareMeter * area.squareMeters)
operator fun Area.times(luminance: Luminance): LuminousIntensity = luminance * this
operator fun LuminousIntensity.div(area: Area) = Luminance(candelasPerSquareMeter = candelas / area.squareMeters)
operator fun LuminousIntensity.div(luminance: Luminance) = Area(squareMeters = candelas / luminance.candelasPerSquareMeter)
