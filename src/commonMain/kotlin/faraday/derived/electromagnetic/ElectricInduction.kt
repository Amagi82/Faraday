package faraday.derived.electromagnetic

import faraday.Units

/**
 * In physics, the electric displacement field (denoted by D) or electric induction is a vector field
 * that appears in Maxwell's equations. It accounts for the effects of free and bound charge within
 * materials. "D" stands for "displacement", as in the related concept of displacement current in
 * dielectrics. In free space, the electric displacement field is equivalent to flux density, a concept
 * that lends understanding to Gauss's law. In the International System of Units (SI), it is expressed
 * in units of coulomb per meter square.
 *
 * @see https://en.wikipedia.org/wiki/Electric_displacement_field
 * */
inline class ElectricInduction(val coulombsPerSquareMeter: Double) : Units<ElectricInduction> {
    override fun plus(other: ElectricInduction) = ElectricInduction(coulombsPerSquareMeter = coulombsPerSquareMeter + other.coulombsPerSquareMeter)
    override fun minus(other: ElectricInduction) = ElectricInduction(coulombsPerSquareMeter = coulombsPerSquareMeter - other.coulombsPerSquareMeter)
    override fun times(factor: Number) = ElectricInduction(coulombsPerSquareMeter = coulombsPerSquareMeter * factor.toDouble())
    override fun div(factor: Number) = ElectricInduction(coulombsPerSquareMeter = coulombsPerSquareMeter / factor.toDouble())
    override fun compareTo(other: ElectricInduction): Int = coulombsPerSquareMeter.compareTo(other.coulombsPerSquareMeter)
}
typealias ElectricDisplacementField = ElectricInduction
