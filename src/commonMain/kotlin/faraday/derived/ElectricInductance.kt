package faraday.derived

import faraday.Units
import faraday.base.ElectricCurrent
import faraday.base.Time

/**
 * In electromagnetism and electronics, inductance is the tendency of an electrical conductor to oppose
 * a change in the electric current flowing through it. The flow of electric current creates a magnetic
 * field around the conductor. The field strength depends on the magnitude of the current, and follows
 * any changes in current. From Faraday's law of induction, any change in magnetic field through a
 * circuit induces an electromotive force (EMF) (ElectricInductance) in the conductors; this is known as
 * electromagnetic induction. So the changing current induces a ElectricInductance in the conductor. This induced
 * ElectricInductance is in a direction which tends to oppose the change in current (as stated by Lenz's law), so
 * it is called a back EMF. Due to this back EMF, a conductor's inductance opposes any increase or
 * decrease in electric current through it.
 *
 * Inductance is defined as the ratio of the induced ElectricInductance to the rate of change of current causing
 * it. It is a proportionality factor that depends on the geometry of circuit conductors and the
 * magnetic permeability of nearby materials. An electronic component designed to add inductance to a
 * circuit is called an inductor. It typically consists of a coil or helix of wire.
 *
 * In the SI system, the unit of inductance is the henry (H), which is the amount of inductance that
 * causes a ElectricInductance of one volt, when the current is changing at a rate of one ampere per second.
 *
 * @see https://en.wikipedia.org/wiki/Inductance
 * */
inline class ElectricInductance(val henrys: Double) : Units<ElectricInductance> {
    override fun plus(other: ElectricInductance) = ElectricInductance(henrys = henrys + other.henrys)
    override fun minus(other: ElectricInductance) = ElectricInductance(henrys = henrys - other.henrys)
    override fun times(factor: Number) = ElectricInductance(henrys = henrys * factor.toDouble())
    override fun div(factor: Number) = ElectricInductance(henrys = henrys / factor.toDouble())
    override fun compareTo(other: ElectricInductance): Int = henrys.compareTo(other.henrys)

    operator fun times(current: ElectricCurrent) = MagneticFlux(webers = henrys * current.amperes)
    operator fun div(time: Time) = ElectricResistance(ohms = henrys / time.seconds)
    operator fun div(resistance: ElectricResistance) = Time(seconds = henrys / resistance.ohms)
}

val Number.henrys get() = ElectricInductance(toDouble())
