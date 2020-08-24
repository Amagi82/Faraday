package konvert.derived

import konvert.Units

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
 * */
inline class Pressure(val pascals: Double) : Units<Pressure> {
    override val value: Double get() = pascals
    val kPa: Double get() = pascals / 1000
    val bar get() = pascals / 100_000
    val psi get() = pascals / PSI
    val atm: Double get() = pascals / ATM

    override fun plus(other: Pressure): Pressure = Pressure(pascals + other.pascals)
    override fun minus(other: Pressure): Pressure = Pressure(pascals - other.pascals)
    override fun times(factor: Number): Pressure = Pressure(pascals * factor.toDouble())
    override fun div(factor: Number): Pressure = Pressure(pascals / factor.toDouble())

    companion object {
        const val ATM = 101_325
        const val PSI = 6894.757
    }
}

val Number.pascals: Pressure get() = Pressure(toDouble())
val Number.kilopascals: Pressure get() = Pressure(toDouble() * 1000)
val Number.poundsPerSquareInch: Pressure get() = Pressure(toDouble() * Pressure.PSI)
val Number.atmospheres: Pressure get() = Pressure(toDouble() * Pressure.ATM)
