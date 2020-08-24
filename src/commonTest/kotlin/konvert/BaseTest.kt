package konvert

import kotlin.math.absoluteValue
import kotlin.test.assertNotNull
import kotlin.test.asserter

interface BaseTest {
    fun assertFloatEquals(expected: Double, actual: Double?, message: String? = null) {
        assertNotNull(actual)
        val precision = expected.absoluteValue * 0.00001
        asserter.assertTrue(
            lazyMessage = {
                val prefix = if (message.isNullOrEmpty()) "" else "$message. "
                prefix + "Expected <$expected>, actual <$actual>, should differ no more than <$precision>."
            },
            actual = (expected - actual).absoluteValue <= precision
        )
    }

    fun <T : Units<T>> assertFloatEquals(expected: T, actual: T?, message: String? = null) {
        assertNotNull(actual)
        val precision = expected.value.absoluteValue * 0.00001
        asserter.assertTrue(
            lazyMessage = {
                val prefix = if (message.isNullOrEmpty()) "" else "$message. "
                prefix + "Expected <$expected>, actual <$actual>, should differ no more than <$precision>.."
            },
            actual = expected.value == actual.value ||
                    (actual.value - expected.value).absoluteValue < precision
        )
    }
}
