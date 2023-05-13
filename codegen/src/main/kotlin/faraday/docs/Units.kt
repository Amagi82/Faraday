/**package faraday

interface Units<T : Units<T>> : Comparable<T> {
    operator fun plus(other: T): T
    operator fun minus(other: T): T
    operator fun times(factor: Number): T
    operator fun div(factor: Number): T
}
*/