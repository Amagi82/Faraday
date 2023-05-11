package faraday.derived

import faraday.Units
import faraday.base.ElectricCurrent
import faraday.base.Time
import faraday.derived.mechanical.Area
import kotlin.jvm.JvmInline

/**
 * In physics, specifically electromagnetism, the magnetic flux (often denoted Φ or ΦB) through
 * a surface is the surface integral of the normal component of the magnetic field flux density
 * B passing through that surface. The SI unit of magnetic flux is the weber (Wb; in derived units,
 * volt–seconds), and the CGS unit is the maxwell. Magnetic flux is usually measured with a
 * fluxmeter, which contains measuring coils and electronics, that evaluates the change of MagneticFlux
 * in the measuring coils to calculate the measurement of magnetic flux.
 *
 * @see [Wiki](https://en.wikipedia.org/wiki/Magnetic_flux)
 */
@JvmInline
value class MagneticFlux(val webers: Double) : Units<MagneticFlux> {
    val maxwells get() = webers / 1e-8
    override fun plus(other: MagneticFlux) = MagneticFlux(webers = webers + other.webers)
    override fun minus(other: MagneticFlux) = MagneticFlux(webers = webers - other.webers)
    override fun times(factor: Number) = MagneticFlux(webers = webers * factor.toDouble())
    override fun div(factor: Number) = MagneticFlux(webers = webers / factor.toDouble())
    override fun compareTo(other: MagneticFlux): Int = webers.compareTo(other.webers)

    operator fun div(time: Time) = Voltage(volts = webers / time.seconds)
    operator fun div(current: ElectricCurrent) = ElectricInductance(henrys = webers / current.amperes)
    operator fun div(area: Area) = MagneticFluxDensity(teslas = webers / area.squareMeters)
    operator fun div(resistance: ElectricResistance) = ElectricCharge(coulombs = webers / resistance.ohms)
    operator fun div(charge: ElectricCharge) = ElectricResistance(ohms = webers / charge.coulombs)
    operator fun div(voltage: Voltage) = Time(seconds = webers / voltage.volts)
    operator fun div(inductance: ElectricInductance) = ElectricCurrent(amperes = webers / inductance.henrys)
    operator fun div(fluxDensity: MagneticFluxDensity) = Area(webers / fluxDensity.teslas)

}

val Number.webers get() = MagneticFlux(toDouble())
