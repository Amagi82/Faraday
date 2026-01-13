package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In physics, specifically electromagnetism, the magnetic flux (often denoted Φ or ΦB) through a surface is the surface integral of the normal component of the magnetic field flux density B passing through that surface. The SI unit of magnetic flux is the weber (Wb; in derived units, volt–seconds), and the CGS unit is the maxwell. Magnetic flux is usually measured with a fluxmeter, which contains measuring coils and electronics, that evaluates the change of MagneticFlux in the measuring coils to calculate the measurement of magnetic flux.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Magnetic_flux)
 */
@JvmInline
value class MagneticFlux(val webers: Double) : Units<MagneticFlux> {
    val maxwells get() = webers / 1e-8
    @InternalUnitApi
    override val rawValue: Double get() = webers

    @InternalUnitApi
    override fun create(value: Double) = MagneticFlux(value)
}

val Number.webers get() = MagneticFlux(toDouble())