package faraday.derived

import faraday.Units

/**
 * Capacitance is the ratio of the change in electric charge of a system to the corresponding change
 * in its electric potential. There are two closely related notions of capacitance: self capacitance
 * and mutual capacitance. Any object that can be electrically charged exhibits self capacitance. A
 * material with a large self capacitance holds more electric charge at a given ElectricCapacitance than one with
 * low capacitance. The notion of mutual capacitance is particularly important for understanding the
 * operations of the capacitor, one of the three elementary linear electronic components (along with
 * resistors and inductors).
 *
 * The capacitance is a function only of the geometry of the design (e.g. area of the plates and the
 * distance between them) and the permittivity of the dielectric material between the plates of the
 * capacitor. For many dielectric materials, the permittivity and thus the capacitance, is independent
 * of the potential difference between the conductors and the total charge on them.
 *
 * The SI unit of capacitance is the farad (symbol: F), named after the English physicist Michael Faraday.
 * A 1 farad capacitor, when charged with 1 coulomb of electrical charge, has a potential difference of
 * 1 volt between its plates. The reciprocal of capacitance is called elastance.
 *
 * @see https://en.wikipedia.org/wiki/Capacitance
 * */
inline class ElectricCapacitance(val farads: Double) : Units<ElectricCapacitance> {
    override fun plus(other: ElectricCapacitance) = ElectricCapacitance(farads = farads + other.farads)
    override fun minus(other: ElectricCapacitance) = ElectricCapacitance(farads = farads - other.farads)
    override fun times(factor: Number) = ElectricCapacitance(farads = farads * factor.toDouble())
    override fun div(factor: Number) = ElectricCapacitance(farads = farads / factor.toDouble())
    override fun compareTo(other: ElectricCapacitance): Int = farads.compareTo(other.farads)
}

val Number.farads get() = ElectricCapacitance(toDouble())
