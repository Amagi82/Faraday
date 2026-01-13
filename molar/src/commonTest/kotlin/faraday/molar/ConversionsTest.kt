package faraday.molar

import faraday.BaseTest
import faraday.core.seconds
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Molar - Catalysis and Time to Amount of Substance`() {
        assertFormula(
            a = 10.katals,
            b = 5.seconds,
            c = 50.moles,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}