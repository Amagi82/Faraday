package faraday

import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Geometry - Distance Area Volume`() {
        assertFormula(
            a = 2.meters,
            b = 2.meters,
            c = 4.squareMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 10.squareMeters,
            b = 2.meters,
            c = 20.cubicMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanics - Density and Mass`() {
        assertFormula(
            a = 1000.kgPerCubicMeter,
            b = 2.cubicMeters,
            c = 2000.kilograms,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}