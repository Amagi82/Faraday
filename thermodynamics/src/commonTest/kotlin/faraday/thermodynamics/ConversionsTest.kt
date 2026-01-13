package faraday.thermodynamics

import faraday.BaseTest
import faraday.core.joules
import faraday.core.kelvin
import faraday.core.kilograms
import faraday.core.meters
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Thermodynamics - HeatCapacity and Temperature to Energy`() {
        assertFormula(
            a = HeatCapacity(joulesPerKelvin = 10.0),
            b = 5.kelvin,
            c = 50.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Thermodynamics - SpecificHeatCapacity and Mass to HeatCapacity`() {
        assertFormula(
            a = SpecificHeatCapacity(2.0),
            b = 10.kilograms,
            c = HeatCapacity(joulesPerKelvin = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Thermodynamics - TemperatureGradient and Distance to Temperature`() {
        assertFormula(
            a = TemperatureGradient(kelvinsPerMeter = 2.0),
            b = 10.meters,
            c = 20.kelvin,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}