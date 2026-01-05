package faraday

import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Photometry - Light Relationships`() {
        assertFormula(
            a = 10.candelas,
            b = 2.steradians,
            c = 20.lumens,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 5.lux,
            b = 4.squareMeters,
            c = 20.lumens,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = Luminance(candelasPerSquareMeter = 5.0),
            b = 10.squareMeters,
            c = 50.candelas,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}