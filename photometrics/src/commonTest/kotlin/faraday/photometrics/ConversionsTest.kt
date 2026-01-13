package faraday.photometrics

import faraday.BaseTest
import faraday.core.seconds
import faraday.core.squareMeters
import faraday.kinematics.RadiantFlux
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Photometrics - Illuminance and Time to LuminousExposure`() {
        assertFormula(
            a = Illuminance(lux = 10.0),
            b = 2.seconds,
            c = LuminousExposure(luxSeconds = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Photometrics - LuminousFlux and Time to LuminousEnergy`() {
        assertFormula(
            a = LuminousFlux(lumens = 10.0),
            b = 2.seconds,
            c = LuminousEnergy(lumenSeconds = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Photometrics - LuminousIntensity and SolidAngle to LuminousFlux`() {
        assertFormula(
            a = LuminousIntensity(candelas = 10.0),
            b = SolidAngle(steradians = 2.0),
            c = LuminousFlux(lumens = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Photometrics - Area and Illuminance to LuminousFlux`() {
        assertFormula(
            a = 4.squareMeters,
            b = Illuminance(lux = 5.0),
            c = LuminousFlux(lumens = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Photometrics - LuminousEfficacy and RadiantFlux to LuminousFlux`() {
        assertFormula(
            a = LuminousEfficacy(lumensPerWatt = 5.0),
            b = RadiantFlux(watts = 4.0),
            c = LuminousFlux(lumens = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Photometrics - Luminance and Area to LuminousIntensity`() {
        assertFormula(
            a = Luminance(candelasPerSquareMeter = 5.0),
            b = 10.squareMeters,
            c = LuminousIntensity(candelas = 50.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}