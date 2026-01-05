package faraday

import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Electricity - Basic Circuit Laws`() {
        // Ohm's Law
        assertFormula(
            a = 2.amperes,
            b = 10.ohms,
            c = 20.volts,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        // Power
        assertFormula(
            a = 2.amperes,
            b = 10.volts,
            c = 20.watts,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        // Charge
        assertFormula(
            a = 2.amperes,
            b = 10.seconds,
            c = 20.coulombs,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electricity - Capacitance and Inductance`() {
        assertFormula(
            a = 5.farads,
            b = 4.volts,
            c = 20.coulombs,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 2.farads,
            b = 5.ohms,
            c = 10.seconds,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 2.henrys,
            b = 5.amperes,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Magnetism - Flux and Induction`() {
        assertFormula(
            a = 2.teslas,
            b = 5.squareMeters,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 5.volts,
            b = 2.seconds,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}