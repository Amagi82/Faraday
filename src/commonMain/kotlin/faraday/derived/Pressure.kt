package faraday.derived

import faraday.Prefixes
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Pressure (symbol: p or P) is the force applied perpendicular to the surface of an object
 * per unit area over which that force is distributed. Gauge pressure is the pressure
 * relative to the ambient pressure.
 *
 * Various units are used to express pressure. Some of these derive from a unit of force
 * divided by a unit of area; the SI unit of pressure, the pascal (Pa), for example, is one
 * newton per square metre (N/m2); similarly, the pound-force per square inch (psi) is the
 * traditional unit of pressure in the imperial and US customary systems. Pressure may also
 * be expressed in terms of standard atmospheric pressure; the atmosphere (atm) is equal
 * to this pressure, and the torr is defined as ​1⁄760 of this. Manometric units such as
 * the centimetre of water, millimetre of mercury, and inch of mercury are used to express
 * pressures in terms of the height of column of a particular fluid in a manometer.
 *
 * @see https://en.wikipedia.org/wiki/Pressure
 *
 * Energy density is the amount of energy stored in a given system or region of space per unit
 * volume. Colloquially it may also be used for energy per unit mass, though the accurate term
 * for this is specific energy. Often only the useful or extractable energy is measured, which
 * is to say that inaccessible energy (such as rest mass energy) is ignored. In cosmological and
 * other general relativistic contexts, however, the energy densities considered are those that
 * correspond to the elements of the stress–energy tensor and therefore do include mass energy
 * as well as energy densities associated with the pressures described in the next paragraph.
 *
 * Energy per unit volume has the same physical units as pressure, and in many circumstances is
 * a synonym: for example, the energy density of a magnetic field may be expressed as (and
 * behaves as) a physical pressure, and the energy required to compress a compressed gas a little
 * more may be determined by multiplying the difference between the gas pressure and the external
 * pressure by the change in volume. In short, pressure is a measure of the enthalpy per unit
 * volume of a system. A pressure gradient has the potential to perform work on the surroundings
 * by converting enthalpy to work until equilibrium is reached.
 *
 * @see https://en.wikipedia.org/wiki/Energy_density
 * */
@JvmInline
value class Pressure(val pascals: Double) : Units<Pressure> {
    val joulesPerCubicMeter: Double get() = pascals
    val kilopascals get() = pascals / Prefixes.KILO
    val gigapascals get() = pascals / Prefixes.GIGA
    val bar get() = pascals / 100_000
    val psi get() = pascals / PSI
    val atm get() = pascals / ATM

    override fun plus(other: Pressure) = Pressure(pascals = pascals + other.pascals)
    override fun minus(other: Pressure) = Pressure(pascals = pascals - other.pascals)
    override fun times(factor: Number) = Pressure(pascals = pascals * factor.toDouble())
    override fun div(factor: Number) = Pressure(pascals = pascals / factor.toDouble())
    override fun compareTo(other: Pressure): Int = pascals.compareTo(other.pascals)

    companion object {
        const val ATM = 101_325
        const val PSI = 6894.757
    }
}

typealias EnergyDensity = Pressure
typealias Stress = Pressure

val Number.pascals get() = Pressure(toDouble())
val Number.kilopascals get() = Pressure(pascals = toDouble() * Prefixes.KILO)
val Number.gigapascals get() = Pressure(pascals = toDouble() * Prefixes.GIGA)
val Number.poundsPerSquareInch get() = Pressure(pascals = toDouble() * Pressure.PSI)
val Number.atmospheres get() = Pressure(pascals = toDouble() * Pressure.ATM)

val Number.joulesPerCubicMeter get() = EnergyDensity(toDouble())
