package faraday

import kotlin.math.PI
import kotlin.reflect.KClass

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class FaradayUnit(val siUnit: String, val metricUnits: Array<MetricFactor>, val additionalUnits: Array<Unit>, val conversions: Array<Conversion>)

@Retention(AnnotationRetention.SOURCE)
@Target()
annotation class Unit(val unit: String, val factor: Double)


@Retention(AnnotationRetention.SOURCE)
annotation class Conversion(val numerator: KClass<*>, val denominator: KClass<*>)


fun conversion() {
    FaradayUnits.ConversionBuilder().times<Distance>().div<Area>().equals<Volume>()
}


@FaradayUnit(
    siUnit = "meters",
    metricUnits = [MetricFactor.Nano, MetricFactor.Micro, MetricFactor.Milli, MetricFactor.Centi, MetricFactor.Kilo],
    additionalUnits = [Unit(unit = "angstroms", factor = Distance.ANGSTROM)],
    conversions = [Conversion(numerator = Volume::class, denominator = Area::class)]
)
interface Distance : FaradayUnits {
    companion object {
        const val LIGHT_SECOND = 299_792_458.0

        //        const val LIGHT_YEAR = LIGHT_SECOND * Time.JULIAN_YEAR
        const val ASTRONOMICAL_UNIT = 149_597_870_700.0
        const val PARSEC = (648_000.0 / PI) * ASTRONOMICAL_UNIT
        const val ANGSTROM = 1e-10

        const val INCH = 0.0254
        const val FOOT = INCH * 12
        const val YARD = FOOT * 3
        const val MILE = YARD * 1760
        const val NAUTICAL_MILE = 1852.0
    }
}

interface FaradayUnits {
    class Conversion
    class ConversionBuilder() {
        fun <T : FaradayUnits> times(): ConversionBuilder {
            TODO()
        }

        fun <T : FaradayUnits> div(): ConversionBuilder {
            TODO()
        }

        fun <T : FaradayUnits> equals(): Conversion {
            TODO()
        }
    }
}

@FaradayUnit(
    siUnit = "squareMeters",
    metricUnits = [],
    additionalUnits = [],
    conversions = []
)
interface Area : FaradayUnits {
    companion object {
        const val HECTARE = 1e4
        const val SQ_KILO = 1e6
        const val SQ_CENTI = 1e-4
        const val SQ_INCH = Distance.INCH * Distance.INCH
        const val SQ_FOOT = Distance.FOOT * Distance.FOOT
        const val SQ_YARD = Distance.YARD * Distance.YARD
        const val ACRE = 4046.8564224
        const val SQ_MILE = Distance.MILE * Distance.MILE
    }
}

@FaradayUnit(
    siUnit = "cubicMeters",
    metricUnits = [],
    additionalUnits = [],
    conversions = []
)
interface Volume : FaradayUnits {
    companion object {
        const val LITER = 1e-3
        const val CUBIC_CENTIMETER = 1e-6

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


enum class MetricFactor(val factor: Double) {
    Yocto(factor = 1e-24),
    Zepto(factor = 1e-21),
    Atto(factor = 1e-18),
    Femto(factor = 1e-15),
    Pico(factor = 1e-12),
    Nano(factor = 1e-9),
    Micro(factor = 1e-6),
    Milli(factor = 1e-3),
    Centi(factor = 1e-2),
    Deci(factor = 1e-1),
    Deca(factor = 1e1),
    Hecto(factor = 1e2),
    Kilo(factor = 1e3),
    Mega(factor = 1e6),
    Giga(factor = 1e9),
    Tera(factor = 1e12),
    Peta(factor = 1e15),
    Exa(factor = 1e18),
    Zetta(factor = 1e21),
    Yotta(factor = 1e24)
}
