package konvert.derived.mechanical

import konvert.Units
import konvert.base.Distance
import konvert.base.Mass
import konvert.base.Time
import konvert.derived.kinematic.VolumetricFlowRate

/**
 * Volume is the quantity of three-dimensional space enclosed by a closed surface, for example, the
 * space that a substance (solid, liquid, gas, or plasma) or shape occupies or contains. Volume is
 * often quantified numerically using the SI derived unit, the cubic metre. The volume of a container
 * is generally understood to be the capacity of the container; i. e., the amount of fluid (gas or
 * liquid) that the container could hold, rather than the amount of space the container itself
 * displaces. Three dimensional mathematical shapes are also assigned volumes. Volumes of some simple
 * shapes, such as regular, straight-edged, and circular shapes can be easily calculated using
 * arithmetic formulas. Volumes of complicated shapes can be calculated with integral calculus if a
 * formula exists for the shape's boundary. One-dimensional figures (such as lines) and two-dimensional
 * shapes (such as squares) are assigned zero volume in the three-dimensional space.
 *
 * The volume of a solid (whether regularly or irregularly shaped) can be determined by fluid
 * displacement. Displacement of liquid can also be used to determine the volume of a gas. The combined
 * volume of two substances is usually greater than the volume of just one of the substances. However,
 * sometimes one substance dissolves in the other and in such cases the combined volume is not additive.
 *
 * @see https://en.wikipedia.org/wiki/Volume
 * */
inline class Volume(val cubicMeters: Double) : Units<Volume> {
    override val value: Double get() = cubicMeters
    val cubicCentimeters: Double get() = cubicMeters * 1e6
    val liters: Double get() = cubicMeters * 1000

    val cubicInches: Double get() = cubicMeters / CUBIC_INCH
    val cubicFeet: Double get() = cubicMeters / CUBIC_FOOT
    val cubicYards: Double get() = cubicMeters / CUBIC_YARD

    val teaspoonsUS: Double get() = cubicMeters / TEASPOON_US
    val tablespoonsUS: Double get() = cubicMeters / TABLESPOON_US
    val fluidOuncesUS: Double get() = cubicMeters / FLUID_OUNCE_US
    val cupsUS: Double get() = cubicMeters / CUP_US
    val pintsUS: Double get() = cubicMeters / PINT_US
    val quartsUS: Double get() = cubicMeters / QUART_US
    val gallonsUS: Double get() = cubicMeters / GALLON_US
    val barrelsUS: Double get() = cubicMeters / BARREL_US

    val teaspoonsImp: Double get() = cubicMeters / TEASPOON_IMP
    val tablespoonsImp: Double get() = cubicMeters / TABLESPOON_IMP
    val fluidOuncesImp: Double get() = cubicMeters / FLUID_OUNCE_IMP
    val gillsImp: Double get() = cubicMeters / GILL_IMP
    val pintsImp: Double get() = cubicMeters / PINT_IMP
    val quartsImp: Double get() = cubicMeters / QUART_IMP
    val gallonsImp: Double get() = liters / GALLON_IMP
    val barrelsImp: Double get() = cubicMeters / BARREL_IMP

    val barrelsOil: Double get() = cubicMeters / BARREL_OIL

    override fun plus(other: Volume): Volume = Volume(cubicMeters + other.cubicMeters)
    override fun minus(other: Volume): Volume = Volume(cubicMeters - other.cubicMeters)
    override fun times(factor: Number): Volume = Volume(cubicMeters * factor.toDouble())
    override fun div(factor: Number): Volume = Volume(cubicMeters / factor.toDouble())

    operator fun times(density: Density): Mass = Mass(kilograms = cubicMeters * density.kgPerCubicMeter)
    operator fun div(flowRate: VolumetricFlowRate): Time = Time(seconds = cubicMeters / flowRate.cubicMetersPerSecond)

    companion object {
        const val CUBIC_INCH = Distance.INCH * Distance.INCH * Distance.INCH
        const val CUBIC_FOOT = Distance.FOOT * Distance.FOOT * Distance.FOOT
        const val CUBIC_YARD = Distance.YARD * Distance.YARD * Distance.YARD

        const val GALLON_US = CUBIC_INCH * 231
        const val BARREL_US = GALLON_US * 31.5
        const val QUART_US = GALLON_US / 4
        const val PINT_US = GALLON_US / 8
        const val CUP_US = GALLON_US / 16
        const val FLUID_OUNCE_US = GALLON_US / 128
        const val TABLESPOON_US = FLUID_OUNCE_US / 2
        const val TEASPOON_US = FLUID_OUNCE_US / 6

        const val GALLON_IMP = 4.54609e-3
        const val BARREL_IMP = GALLON_IMP * 36
        const val QUART_IMP = GALLON_IMP / 4
        const val PINT_IMP = GALLON_IMP / 8
        const val FLUID_OUNCE_IMP = GALLON_IMP / 160
        const val GILL_IMP = FLUID_OUNCE_IMP * 5
        const val TABLESPOON_IMP = FLUID_OUNCE_IMP * 5 / 8.0
        const val TEASPOON_IMP = GILL_IMP / 24

        const val BARREL_OIL = GALLON_US * 42
    }
}

val Number.cubicCentimeters: Volume get() = Volume(cubicMeters = toDouble() / 1e6)
val Number.liters: Volume get() = Volume(cubicMeters = toDouble() / 1000)
val Number.cubicMeters: Volume get() = Volume(cubicMeters = toDouble())
