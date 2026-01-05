package faraday

import kotlin.math.abs
import kotlin.test.assertEquals

interface BaseTest {

    /**
     * Verifies that:
     * 1. a * b = c
     * 2. b * a = c
     * 3. c / b = a
     * 4. c / a = b
     */
    @OptIn(InternalUnitApi::class)
    fun <A : Units<A>, B : Units<B>, C : Units<C>> assertFormula(
        a: A,
        b: B,
        c: C,
        multiplyAB: (A, B) -> C,
        multiplyBA: (B, A) -> C,
        divCB: (C, B) -> A,
        divCA: (C, A) -> B
    ) {
        // Check Multiplications
        assertRelative(expected = c.rawValue, actual = multiplyAB(a, b).rawValue, message = "A * B != C")
        assertRelative(expected = c.rawValue, actual = multiplyBA(b, a).rawValue, message = "B * A != C")

        // Check Divisions
        assertRelative(expected = a.rawValue, actual = divCB(c, b).rawValue, message = "C / B != A")
        assertRelative(expected = b.rawValue, actual = divCA(c, a).rawValue, message = "C / A != B")
    }

    fun assertRelative(expected: Double, actual: Double, message: String) {
        val diff = abs(expected - actual)
        if (diff > EPSILON && diff / abs(expected) > EPSILON) {
            assertEquals(expected, actual, "$message (Values: Exp $expected, Act $actual)")
        }
    }

    companion object {
        private const val EPSILON = 1e-10
    }
}
