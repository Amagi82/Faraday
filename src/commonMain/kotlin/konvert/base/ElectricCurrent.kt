package konvert.base

import konvert.Units

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
inline class ElectricCurrent(val amperes: Double) : Units<ElectricCurrent> {
    override val value: Double get() = amperes
    override fun plus(other: ElectricCurrent): ElectricCurrent = ElectricCurrent(amperes + other.amperes)
    override fun minus(other: ElectricCurrent): ElectricCurrent = ElectricCurrent(amperes - other.amperes)
    override fun times(factor: Number): ElectricCurrent = ElectricCurrent(amperes * factor.toDouble())
    override fun div(factor: Number): ElectricCurrent = ElectricCurrent(amperes / factor.toDouble())
}

val Number.amperes: ElectricCurrent get() = ElectricCurrent(amperes = toDouble())
