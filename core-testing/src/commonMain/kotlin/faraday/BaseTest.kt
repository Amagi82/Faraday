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
        assertApproximatelyEqual(expected = c, actual = multiplyAB(a, b), message = "A * B != C")
        assertApproximatelyEqual(expected = c, actual = multiplyBA(b, a), message = "B * A != C")

        // Check Divisions
        assertApproximatelyEqual(expected = a, actual = divCB(c, b), message = "C / B != A")
        assertApproximatelyEqual(expected = b, actual = divCA(c, a), message = "C / A != B")
    }

    @OptIn(InternalUnitApi::class)
    fun <T : Units<T>> assertApproximatelyEqual(expected: Units<T>, actual: Units<T>, message: String) =
        assertApproximatelyEqual(expected = expected.rawValue, actual = actual.rawValue, message = message)

    fun assertApproximatelyEqual(expected: Double, actual: Double, message: String) {
        val diff = abs(expected - actual)
        if (diff > EPSILON && diff / abs(expected) > EPSILON) {
            assertEquals(expected, actual, "$message (Values: Exp $expected, Act $actual)")
        }
    }

    companion object {
        private const val EPSILON = 1e-10
    }
}
