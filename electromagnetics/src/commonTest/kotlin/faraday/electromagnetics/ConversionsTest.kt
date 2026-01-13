package faraday.electromagnetics

import faraday.BaseTest
import faraday.core.joules
import faraday.core.seconds
import faraday.core.squareMeters
import faraday.kinematics.hertz
import faraday.kinematics.watts
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Electromagnetism - Current and Resistance to Voltage`() {
        // Ohm's Law
        assertFormula(
            a = 2.amperes,
            b = 10.ohms,
            c = 20.volts,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Current and Voltage to Power`() {
        assertFormula(
            a = 2.amperes,
            b = 10.volts,
            c = 20.watts,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Current and Time to Charge`() {
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
    fun `Electromagnetism - Capacitance and Voltage to Charge`() {
        assertFormula(
            a = 5.farads,
            b = 4.volts,
            c = 20.coulombs,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Capacitance and Resistance to Time`() {
        assertFormula(
            a = 2.farads,
            b = 5.ohms,
            c = 10.seconds,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Inductance and Current to Flux`() {
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
    fun `Electromagnetism - Induction and Area to Flux`() {
        assertFormula(
            a = 2.teslas,
            b = 5.squareMeters,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Voltage and Time to Flux`() {
        assertFormula(
            a = 5.volts,
            b = 2.seconds,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Capacitance and Frequency to Conductance`() {
        assertFormula(
            a = 2.farads,
            b = 5.hertz,
            c = 10.siemens,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Flux and Current to Energy`() {
        assertFormula(
            a = 2.webers,
            b = 5.amperes,
            c = 10.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Resistance and Time to Inductance`() {
        assertFormula(
            a = 2.ohms,
            b = 5.seconds,
            c = 10.henrys,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Resistance and Charge to Flux`() {
        assertFormula(
            a = 2.ohms,
            b = 5.coulombs,
            c = 10.webers,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Charge and Voltage to Energy`() {
        assertFormula(
            a = 2.coulombs,
            b = 5.volts,
            c = 10.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Electromagnetism - Conductance and Resistance relationship`() {
        assertApproximatelyEqual(
            expected = 5.ohms.asConductance(),
            actual = 0.2.siemens,
            message = "Resistance to Conductance"
        )
        assertApproximatelyEqual(
            expected = 5.siemens.asResistance(),
            actual = 0.2.ohms,
            message = "Conductance to Resistance"
        )
    }
}