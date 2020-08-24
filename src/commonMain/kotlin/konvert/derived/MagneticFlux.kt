package konvert.derived

import konvert.Units

/**
 * In physics, specifically electromagnetism, the magnetic flux (often denoted Φ or ΦB) through
 * a surface is the surface integral of the normal component of the magnetic field flux density
 * B passing through that surface. The SI unit of magnetic flux is the weber (Wb; in derived units,
 * volt–seconds), and the CGS unit is the maxwell. Magnetic flux is usually measured with a
 * fluxmeter, which contains measuring coils and electronics, that evaluates the change of MagneticFlux
 * in the measuring coils to calculate the measurement of magnetic flux.
 *
 * @see https://en.wikipedia.org/wiki/Magnetic_flux
 * */
inline class MagneticFlux(val webers: Double) : Units<MagneticFlux> {
    override val value: Double get() = webers
    val maxwells: Double get() = webers / 1e-8

    override fun plus(other: MagneticFlux): MagneticFlux = MagneticFlux(webers + other.webers)
    override fun minus(other: MagneticFlux): MagneticFlux = MagneticFlux(webers - other.webers)
    override fun times(factor: Number): MagneticFlux = MagneticFlux(webers * factor.toDouble())
    override fun div(factor: Number): MagneticFlux = MagneticFlux(webers / factor.toDouble())
}

val Number.webers: MagneticFlux get() = MagneticFlux(toDouble())
