package faraday

import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Thermodynamics - Heat and Temperature`() {
        assertFormula(
            a = HeatCapacity(joulesPerKelvin = 10.0),
            b = 5.kelvin,
            c = 50.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = SpecificHeatCapacity(2.0),
            b = 10.kilograms,
            c = HeatCapacity(joulesPerKelvin = 20.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

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