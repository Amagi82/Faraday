package faraday.derived

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In electronics and electromagnetism, the electrical resistance of an object is a measure of its
 * opposition to the flow of electric current. The inverse quantity is electrical conductance, and
 * is the ease with which an electric current passes. Electrical resistance shares some conceptual
 * parallels with the notion of faraday.derived.mechanical friction. The SI unit of electrical resistance is the ohm
 * (Ω), while electrical conductance is measured in siemens (S).
 *
 * The resistance of an object depends in large part on the material it is made of. Objects made of
 * electrical insulators like rubber tend to have very high resistance and low conductivity, while
 * objects made of electrical conductors like metals tend to have very low resistance and high
 * conductivity. This relationship is quantified by resistivity or conductivity. The nature of a
 * material is not the only factor in resistance and conductance, however; it also depends on the
 * size and shape of an object because these properties are extensive rather than intensive. For
 * example, a wire's resistance is higher if it is long and thin, and lower if it is short and thick.
 * All objects resist electrical current, except for superconductors, which have a resistance of zero.
 *
 * The resistance R of an object is defined as the ratio of ElectricConductance V across it to current I through
 * it, while the conductance G is the reciprocal: R=V/I, G=I/V = 1/R
 *
 * For a wide variety of materials and conditions, V and I are directly proportional to each other,
 * and therefore R and G are constants (although they will depend on the size and shape of the object,
 * the material it is made of, and other factors like temperature or strain). This proportionality is
 * called Ohm's law, and materials that satisfy it are called ohmic materials.
 *
 * In other cases, such as a transformer, diode or battery, V and I are not directly proportional.
 * The ratio V over I is sometimes still useful, and is referred to as a chordal resistance or static
 * resistance, since it corresponds to the inverse slope of a chord between the origin and an I–V
 * curve. In other situations, the derivative dV/dI may be most useful; this is called the differential
 * resistance.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Electrical_resistance_and_conductance)
 */
@JvmInline
value class ElectricConductance(val siemens: Double) : Units<ElectricConductance> {
    override fun plus(other: ElectricConductance) = ElectricConductance(siemens = siemens + other.siemens)
    override fun minus(other: ElectricConductance) = ElectricConductance(siemens = siemens - other.siemens)
    override fun times(factor: Number) = ElectricConductance(siemens = siemens * factor.toDouble())
    override fun div(factor: Number) = ElectricConductance(siemens = siemens / factor.toDouble())
    override fun compareTo(other: ElectricConductance): Int = siemens.compareTo(other.siemens)

    fun asResistance() = ElectricResistance(ohms = 1 / siemens)
}

val Number.siemens get() = ElectricConductance(toDouble())
