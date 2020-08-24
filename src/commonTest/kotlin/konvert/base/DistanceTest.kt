package konvert.base

import konvert.BaseTest
import konvert.derived.mechanical.squareMeters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class DistanceTest : BaseTest {

    @Test
    fun plus() {
        assertFloatEquals(5.meters, 3.meters + 2.meters)
        assertFloatEquals(10.9.meters, 14.meters + (-3.1).meters)
    }

    @Test
    fun minus() {
        assertFloatEquals(2.meters, 6.meters - 4.meters)
        assertFloatEquals((-1.4).meters, 8.meters - 9.4.meters)
    }

    @Test
    fun timesDistance() {
        assertFloatEquals(100.squareMeters, 10.meters * 10.meters)
    }

    @Test
    fun timesFactor() {
        assertFloatEquals(20.meters, 4.meters * 5)
    }

    @Test
    fun divFactor() {
        assertFloatEquals(3.5.meters, 7.meters / 2)
    }

    @Test
    fun compareTo() {
        assertEquals(0, 1.meters.compareTo(1.meters))
        assertEquals(-1, (-1).meters.compareTo(1.meters))
        assertEquals(1, 20.meters.compareTo(1.meters))
        assertFloatEquals(5.meters, 5.meters)
        assertTrue(7.meters > 6.5.meters)
        assertTrue((-2).meters < 3.1.meters)
    }

    @Test
    fun conversions() {
        assertEquals(Distance(meters = 1.0).angstroms, 10_000_000_000.0)
        assertEquals(Distance(meters = 1.0).millimeters, 1000.0)
        assertEquals(Distance(meters = 1.0).centimeters, 100.0)
        assertEquals(Distance(meters = 1.0).meters, 1.0)
        assertEquals(Distance(meters = 1.0).kilometers, 0.001)
        assertEquals(Distance(meters = 1.0).astronomicalUnits, 1.0 / Distance.ASTRONOMICAL_UNIT)
        assertEquals(Distance(meters = 1.0).lightYears, 1.0 / Distance.LIGHT_YEAR)
        assertEquals(Distance(meters = 1.0).parsecs, 1.0 / Distance.PARSEC)
        assertEquals(Distance(meters = 1.0).inches, 1.0 / Distance.INCH)
        assertEquals(Distance(meters = 1.0).feet, 1.0 / Distance.FOOT)
        assertEquals(Distance(meters = 1.0).yards, 1.0 / Distance.YARD)
        assertEquals(Distance(meters = 1.0).miles, 1.0 / Distance.MILE)
        assertEquals(Distance(meters = 1.0).nauticalMiles, 1.0 / Distance.NAUTICAL_MILE)
    }

    @Test
    fun extensions() {
        assertFloatEquals(5.kilometers, Distance(5000.0))
        assertFloatEquals(5.5.meters, Distance(5.5))
        assertFloatEquals(1.meters, 10_000_000_000.angstroms)
        assertFloatEquals(2.meters, 2000.millimeters)
        assertFloatEquals(3.meters, 300.centimeters)
        assertFloatEquals(4.meters, 0.004.kilometers)
        assertFloatEquals(Distance.LIGHT_YEAR.meters, 1.lightYears)
        assertFloatEquals(Distance.PARSEC.meters, 1.parsecs)
        assertFloatEquals(0.0254.meters, 1.inches)
        assertFloatEquals(2.feet, 24.inches)
        assertFloatEquals(3.feet, 1.yards)
        assertFloatEquals(5280.feet, 1.miles)
        assertFloatEquals(1852.meters, 1.nauticalMiles)
    }
}
