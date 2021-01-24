package faraday.base

import faraday.BaseTest
import faraday.derived.mechanical.squareMeters
import kotlin.test.Test

internal class DistanceTest : BaseTest {

    @Test
    fun plus() {
        3.meters + 2.meters shouldBeEqualTo 5.meters
        14.meters + (-3.1).meters shouldBeEqualTo 10.9.meters
    }

    @Test
    fun minus() {
        6.meters - 4.meters shouldBeEqualTo 2.meters
        8.meters - 9.4.meters shouldBeEqualTo (-1.4).meters
    }

    @Test
    fun timesDistance() {
        10.meters * 10.meters shouldBeEqualTo 100.squareMeters
    }

    @Test
    fun timesFactor() {
        4.meters * 5 shouldBeEqualTo 20.meters
    }

    @Test
    fun divFactor() {
        7.meters / 2 shouldBeEqualTo 3.5.meters
    }

    @Test
    fun compareTo() {
        3.meters shouldBeEqualTo 3.meters
        7.meters shouldBeGreaterThan 6.5.meters
        (-2).meters shouldBeLessThan 3.1.meters
    }

    @Test
    fun unitConversions() {
        val oneMeter = Distance(meters = 1.0)
        oneMeter.angstroms shouldBeEqualTo 10_000_000_000.0
        oneMeter.millimeters shouldBeEqualTo 1000.0
        oneMeter.centimeters shouldBeEqualTo 100.0
        oneMeter.meters shouldBeEqualTo 1.0
        oneMeter.kilometers shouldBeEqualTo 0.001
        oneMeter.astronomicalUnits shouldBeEqualTo 1.0 / Distance.ASTRONOMICAL_UNIT
        oneMeter.lightYears shouldBeEqualTo 1.0 / Distance.LIGHT_YEAR
        oneMeter.parsecs shouldBeEqualTo 1.0 / Distance.PARSEC
        oneMeter.inches shouldBeEqualTo 1.0 / Distance.INCH
        oneMeter.feet shouldBeEqualTo 1.0 / Distance.FOOT
        oneMeter.yards shouldBeEqualTo 1.0 / Distance.YARD
        oneMeter.miles shouldBeEqualTo 1.0 / Distance.MILE
        oneMeter.nauticalMiles shouldBeEqualTo 1.0 / Distance.NAUTICAL_MILE
    }

    @Test
    fun unitConversionComparisons() {
        val oneMeter = Distance(meters = 1.0)
        oneMeter.angstroms shouldBeGreaterThan  1.0
        oneMeter.millimeters shouldBeGreaterThan  1.0
        oneMeter.centimeters shouldBeGreaterThan  1.0
        oneMeter.meters shouldBeEqualTo 1.0
        oneMeter.kilometers shouldBeLessThan 1.0
        oneMeter.lightYears shouldBeLessThan 1.0
        oneMeter.parsecs shouldBeLessThan 1.0
        oneMeter.inches shouldBeGreaterThan  1.0
        oneMeter.feet shouldBeGreaterThan  1.0
        oneMeter.yards shouldBeGreaterThan  1.0
        oneMeter.miles shouldBeLessThan 1.0
        oneMeter.nauticalMiles shouldBeLessThan 1.0
    }

    @Test
    fun numberExtensions() {
        val oneMeter = Distance(meters = 1.0)
        1.angstroms shouldBeLessThan oneMeter
        1.millimeters shouldBeLessThan oneMeter
        1.centimeters shouldBeLessThan oneMeter
        1.meters shouldBeEqualTo oneMeter
        1.kilometers shouldBeGreaterThan oneMeter
        1.lightYears shouldBeGreaterThan oneMeter
        1.parsecs shouldBeGreaterThan oneMeter
        1.inches shouldBeLessThan oneMeter
        1.feet shouldBeLessThan oneMeter
        1.yards shouldBeLessThan oneMeter
        1.miles shouldBeGreaterThan oneMeter
        1.nauticalMiles shouldBeGreaterThan oneMeter
    }
}
