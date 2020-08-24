package konvert

interface Units<T : Units<T>> : Comparable<T> {
    val value: Double
    operator fun plus(other: T): T
    operator fun minus(other: T): T
    operator fun times(factor: Number): T
    operator fun div(factor: Number): T
    override fun compareTo(other: T): Int = value.compareTo(other.value)
}
