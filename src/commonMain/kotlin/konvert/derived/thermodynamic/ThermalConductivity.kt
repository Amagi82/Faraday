package konvert.derived.thermodynamic

import konvert.Units

/**
 * The thermal conductivity of a material is a measure of its ability to conduct heat. It is
 * commonly denoted by k, λ, or κ.
 *
 * Heat transfer occurs at a lower rate in materials of low thermal conductivity than in materials
 * of high thermal conductivity. For instance, metals typically have high thermal conductivity and
 * are very efficient at conducting heat, while the opposite is true for insulating materials like
 * Styrofoam. Correspondingly, materials of high thermal conductivity are widely used in heat sink
 * applications, and materials of low thermal conductivity are used as thermal insulation. The
 * reciprocal of thermal conductivity is called thermal resistivity.
 *
 * @see https://en.wikipedia.org/wiki/Thermal_conductivity
 * */
inline class ThermalConductivity(val wattsPerMeterKelvin: Double) : Units<ThermalConductivity> {
    override val value: Double get() = wattsPerMeterKelvin
    override fun plus(other: ThermalConductivity): ThermalConductivity = ThermalConductivity(wattsPerMeterKelvin + other.wattsPerMeterKelvin)
    override fun minus(other: ThermalConductivity): ThermalConductivity = ThermalConductivity(wattsPerMeterKelvin - other.wattsPerMeterKelvin)
    override fun times(factor: Number): ThermalConductivity = ThermalConductivity(wattsPerMeterKelvin * factor.toDouble())
    override fun div(factor: Number): ThermalConductivity = ThermalConductivity(wattsPerMeterKelvin / factor.toDouble())
}
