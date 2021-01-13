package faraday.derived.electromagnetic

import faraday.Units

/**
 * In electromagnetism, permeability is the measure of the resistance of a material against the
 * formation of a magnetic field, otherwise known as distributed inductance in transmission line
 * theory. Hence, it is the degree of magnetization that a material obtains in response to an
 * applied magnetic field. Magnetic permeability is typically represented by the (italicized)
 * Greek letter μ. The term was coined in September 1885 by Oliver Heaviside. The reciprocal
 * of magnetic permeability is magnetic reluctivity.
 *
 * @see https://en.wikipedia.org/wiki/Permeability_(electromagnetism)
 * */
inline class MagneticPermeability(val henrysPerMeter: Double) : Units<MagneticPermeability> {
    override fun plus(other: MagneticPermeability) = MagneticPermeability(henrysPerMeter = henrysPerMeter + other.henrysPerMeter)
    override fun minus(other: MagneticPermeability) = MagneticPermeability(henrysPerMeter = henrysPerMeter - other.henrysPerMeter)
    override fun times(factor: Number) = MagneticPermeability(henrysPerMeter = henrysPerMeter * factor.toDouble())
    override fun div(factor: Number) = MagneticPermeability(henrysPerMeter = henrysPerMeter / factor.toDouble())
    override fun compareTo(other: MagneticPermeability): Int = henrysPerMeter.compareTo(other.henrysPerMeter)
}
