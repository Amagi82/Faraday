@file:OptIn(InternalUnitApi::class)

package faraday

@RequiresOptIn(message = "Internal unit logic. Do not use directly.")
@Retention(AnnotationRetention.BINARY)
annotation class InternalUnitApi

interface Units<T : Units<T>> : Comparable<T> {
    @InternalUnitApi
    val rawValue: Double

    @InternalUnitApi
    fun create(value: Double): T

    operator fun plus(other: T): T = create(rawValue + other.rawValue)
    operator fun minus(other: T): T = create(rawValue - other.rawValue)
    operator fun times(factor: Number): T = create(rawValue * factor.toDouble())
    operator fun div(factor: Number): T = create(rawValue / factor.toDouble())

    override fun compareTo(other: T): Int = rawValue.compareTo(other.rawValue)
}