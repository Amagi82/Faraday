package faraday

import kotlin.math.absoluteValue
import kotlin.test.assertTrue
import kotlin.test.asserter

interface BaseTest {

    infix fun <T : Comparable<T>> T.shouldBeGreaterThan(expected: T) = assertTrue(this > expected)
    infix fun <T : Comparable<T>> T.shouldBeGreaterThanOrEqualTo(expected: T) = assertTrue(this >= expected)
    infix fun <T : Comparable<T>> T.shouldBeLessThan(expected: T) = assertTrue(this < expected)
    infix fun <T : Comparable<T>> T.shouldBeLessThanOrEqualTo(expected: T) = assertTrue(this <= expected)

    infix fun <T> T.shouldBeEqualTo(expected: T) = when {
        this is Number && expected is Number && ((this is Double || this is Float) || (expected is Float || expected is Double)) -> {
            assertApproxEquals(actual = toDouble(), expected = expected.toDouble())
        }
        this is Units<*> && expected is Units<*> -> {
            println("actual: $this, expected: $expected")
            assertApproxEquals(actual = this.unbox(), expected = expected.unbox())
        }
        else -> kotlin.test.assertEquals(actual = this, expected = expected)
    }

    // This is gross. Better ways to unbox inline classes?
    fun Units<*>.unbox(): Double = toString().filter { it == '.' || it in '0'..'9' }.toDouble()

    private fun assertApproxEquals(actual: Double, expected: Double, message: String? = null) {
        val precision = expected.absoluteValue * 0.00001
        asserter.assertTrue(
            lazyMessage = { "${if (message.isNullOrEmpty()) "" else "$message. "}Expected <$expected>, actual <$actual>" },
            actual = expected == actual || (actual - expected).absoluteValue < precision
        )
    }
}
