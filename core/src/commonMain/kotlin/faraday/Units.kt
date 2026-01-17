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

    override fun compareTo(other: T): Int = rawValue.compareTo(other.rawValue)
}