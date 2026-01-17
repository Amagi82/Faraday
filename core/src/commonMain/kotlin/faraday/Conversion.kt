package faraday

import kotlin.reflect.KClass

/**
 * Annotate an internal object and the annotation processor will generate operator functions to convert between units
 *
 * For example, to add Force = Mass * Acceleration:
 * @Conversion(Mass::class, Acceleration::class, Force::class)
 * internal object Conversions
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation class Conversion(
    val factor1: KClass<*>,
    val factor2: KClass<*>,
    val resultType: KClass<*>,
)