package faraday.derived.electromagnetic

import faraday.Units

/**
 * In electromagnetism, the absolute permittivity, often simply called permittivity and denoted by the
 * Greek letter ε (epsilon), is a measure of the electric polarizability of a dielectric. A material
 * with high permittivity polarizes more in response to an applied electric field than a material with
 * low permittivity, thereby storing more energy in the material. In electrostatics, the permittivity
 * plays an important role in determining the capacitance of a capacitor.
 *
 * @see https://en.wikipedia.org/wiki/Permittivity
 * */
inline class Permittivity(val faradsPerMeter: Double) : Units<Permittivity> {
    override fun plus(other: Permittivity) = Permittivity(faradsPerMeter = faradsPerMeter + other.faradsPerMeter)
    override fun minus(other: Permittivity) = Permittivity(faradsPerMeter = faradsPerMeter - other.faradsPerMeter)
    override fun times(factor: Number) = Permittivity(faradsPerMeter = faradsPerMeter * factor.toDouble())
    override fun div(factor: Number) = Permittivity(faradsPerMeter = faradsPerMeter / factor.toDouble())
    override fun compareTo(other: Permittivity): Int = faradsPerMeter.compareTo(other.faradsPerMeter)
}
