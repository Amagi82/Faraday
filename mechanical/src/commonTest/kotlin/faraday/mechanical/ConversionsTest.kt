package faraday.mechanical

import faraday.BaseTest
import faraday.core.*
import faraday.kinematics.horsepower
import faraday.kinematics.newtons
import kotlin.test.Test

internal class ConversionsTest : BaseTest {

    @Test
    fun `Mechanical - Force and Distance to Torque`() {
        assertFormula(
            a = 10.newtons,
            b = 5.meters,
            c = 50.newtonMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - Stiffness and Angle to Torque`() {
        assertFormula(
            a = RotationalStiffness(newtonMetersPerRadian = 10.0),
            b = 5.radians,
            c = 50.newtonMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - Stiffness and Distance to Force`() {
        assertFormula(
            a = Stiffness(newtonsPerMeter = 10.0),
            b = 5.meters,
            c = 50.newtons,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - MassFlowRate and Time to Mass`() {
        assertFormula(
            a = MassFlowRate(kilogramsPerSecond = 10.0),
            b = 5.seconds,
            c = 50.kilograms,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - VolumetricFlowRate and Time to Volume`() {
        assertFormula(
            a = VolumetricFlowRate(cubicMetersPerSecond = 10.0),
            b = 5.seconds,
            c = 50.cubicMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - Horsepower per liter`() {
        assertFormula(
            a = 100.horsepowerPerLiter,
            b = 5.liters,
            c = 500.horsepower,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - Fuel mileage and Volume to Distance`() {
        assertFormula(
            a = 10.milesPerGallon,
            b = 5.gallonsUS,
            c = 50.miles,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - SpecificVolume and Mass to Volume`() {
        assertFormula(
            a = SpecificVolume(cubicMetersPerKilogram = 10.0),
            b = 5.kilograms,
            c = 50.cubicMeters,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - SpecificEnergy and Mass to Force`() {
        assertFormula(
            a = SpecificEnergy(joulesPerKilogram = 10.0),
            b = 5.kilograms,
            c = 50.newtons,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - Mass Fraction`() {
        assertFormula(
            a = MassFraction(ratio = 1.0 / 1_000_000),
            b = 1e6.kilograms,
            c = 1.kilograms,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }

    @Test
    fun `Mechanical - AreaDensity and Area to Mass`() {
        assertFormula(
            a = AreaDensity(kgPerSquareMeter = 20.0),
            b = 2.squareMeters,
            c = 40.kilograms,
            multiplyAB = { a, b -> a * b },
            multiplyBA = { b, a -> b * a },
            divCB = { c, b -> c / b },
            divCA = { c, a -> c / a })
    }
}