package faraday.base

import faraday.Prefixes
import faraday.Units
import faraday.derived.*
import kotlin.jvm.JvmInline

/**
 * An electric current is the rate of flow of electric charge past a point or region. An
 * electric current is said to exist when there is a net flow of electric charge through
 * a region. Electric charge is carried by charged particles, so an electric current is
 * a flow of charged particles. The moving particles are called charge carriers, and in
 * different conductors may be different types of particle. In electric circuits the
 * charge carriers are often electrons moving through a wire. In an electrolyte the charge
 * carriers are ions, and in an ionized gas (plasma) are ions and electrons.
 *
 * The SI unit of electric current is the ampere, which is the flow of electric charge
 * across a surface at the rate of one coulomb per second. The ampere (symbol: A) is an
 * SI base unit. Electric current is measured using a device called an ammeter.
 *
 * @see https://en.wikipedia.org/wiki/Electric_current
 * */
@JvmInline
value class ElectricCurrent(val amperes: Double) : Units<ElectricCurrent> {
    val milliAmps get() = amperes / Prefixes.MILLI

    override fun plus(other: ElectricCurrent) = ElectricCurrent(amperes = amperes + other.amperes)
    override fun minus(other: ElectricCurrent) = ElectricCurrent(amperes = amperes - other.amperes)
    override fun times(factor: Number) = ElectricCurrent(amperes = amperes * factor.toDouble())
    override fun div(factor: Number) = ElectricCurrent(amperes = amperes / factor.toDouble())
    override fun compareTo(other: ElectricCurrent): Int = amperes.compareTo(other.amperes)

    operator fun times(voltage: Voltage) = Power(watts = amperes * voltage.volts)
    operator fun times(resistance: ElectricResistance) = Voltage(volts = amperes * resistance.ohms)
    operator fun times(time: Time) = ElectricCharge(coulombs = amperes * time.seconds)
    operator fun times(inductance: ElectricInductance): MagneticFlux = inductance * this
}

val Number.amperes get() = ElectricCurrent(amperes = toDouble())
