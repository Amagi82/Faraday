package faraday

import kotlin.jvm.JvmInline

/**
 * In electromagnetism, the absolute permittivity, often simply called permittivity and denoted by the
 * Greek letter ε (epsilon), is a measure of the electric polarizability of a dielectric. A material
 * with high permittivity polarizes more in response to an applied electric field than a material with
 * low permittivity, thereby storing more energy in the material. In electrostatics, the permittivity
 * plays an important role in determining the capacitance of a capacitor.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Permittivity)
 */
@JvmInline
value class Permittivity(val faradsPerMeter: Double) : Units<Permittivity> {
    @InternalUnitApi
    override val rawValue: Double get() = faradsPerMeter

    @InternalUnitApi
    override fun create(value: Double) = Permittivity(value)
}
