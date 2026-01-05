package faraday

import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Mechanics - Force Acceleration Momentum`() {
        assertFormula(
            a = 10.kilograms,
            b = Acceleration(metersPerSecondSquared = 9.8),
            c = 98.newtons,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 10.kilograms,
            b = 5.metersPerSecond,
            c = Momentum(newtonSeconds = 50.0),
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

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
    fun `Kinetics - Velocity and Flow`() {
        assertFormula(
            a = Acceleration(metersPerSecondSquared = 2.0),
            b = 5.seconds,
            c = 10.metersPerSecond,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })

        assertFormula(
            a = 10.metersPerSecond,
            b = 5.seconds,
            c = 50.meters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })


        assertFormula(
            a = 2.cubicMetersPerSecond,
            b = 10.seconds,
            c = 20.cubicMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}