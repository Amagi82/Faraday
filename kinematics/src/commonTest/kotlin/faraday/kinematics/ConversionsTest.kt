package faraday.kinematics

import faraday.BaseTest
import faraday.core.*
import kotlin.math.pow
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Kinematics - Mass and Acceleration to Force`() {
        assertFormula(
            a = 10.kilograms,
            b = Acceleration(metersPerSecondSquared = 9.8),
            c = 98.newtons,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Mass and Velocity to Momentum`() {
        assertFormula(
            a = 10.kilograms,
            b = 5.metersPerSecond,
            c = Momentum(newtonSeconds = 50.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Force and Distance to Energy`() {
        assertFormula(
            a = 100.newtons,
            b = 5.meters,
            c = 500.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Acceleration and Time to Velocity`() {
        assertFormula(
            a = Acceleration(metersPerSecondSquared = 2.0),
            b = 5.seconds,
            c = 10.metersPerSecond,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Velocity and Time to Distance`() {
        assertFormula(
            a = 10.metersPerSecond,
            b = 5.seconds,
            c = 50.meters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - AngularVelocity and Time to Angle`() {
        assertFormula(
            a = AngularVelocity(radiansPerSecond = 10.0),
            b = 5.seconds,
            c = 50.radians,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - AngularAcceleration and Time to AngularVelocity`() {
        assertFormula(
            a = AngularAcceleration(radiansPerSecondSquared = 10.0),
            b = 5.seconds,
            c = AngularVelocity(radiansPerSecond = 50.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Volumetric Flow rate`() {
        assertFormula(
            a = 2.cubicMetersPerSecond,
            b = 10.seconds,
            c = 20.cubicMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Power and Time to Energy`() {
        assertFormula(
            a = 2.watts,
            b = 5.seconds,
            c = 10.joules,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Area and Pressure to Force`() {
        assertFormula(
            a = 2.squareMeters,
            b = 5.pascals,
            c = 10.newtons,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Kinematics - Mass-Energy relationship`() {
        assertApproximatelyEqual(
            expected = 5.kilograms.toEnergy(),
            actual = (5 * Velocity.LIGHT.pow(2)).joules,
            message = "Mass to Energy"
        )
        assertApproximatelyEqual(
            expected = (5 * Velocity.LIGHT.pow(2)).joules.toMass(),
            actual = 5.kilograms,
            message = "Energy to Mass"
        )
    }
}