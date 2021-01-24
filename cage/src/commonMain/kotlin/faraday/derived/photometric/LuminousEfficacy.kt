package faraday.derived.photometric

import faraday.Units
import kotlin.jvm.JvmInline

/**
 * Luminous efficacy is a measure of how well a light source produces visible light. It is the ratio
 * of luminous flux to power, measured in lumens per watt in the International System of Units (SI).
 * Depending on context, the power can be either the radiant flux of the source's output, or it can
 * be the total power (electric power, chemical energy, or others) consumed by the source. Which
 * sense of the term is intended must usually be inferred from the context, and is sometimes unclear.
 * The former sense is sometimes called luminous efficacy of radiation, and the latter luminous
 * efficacy of a source or overall luminous efficacy.
 *
 * [Wiki](https://en.wikipedia.org/wiki/Luminous_efficacy)
 */
@JvmInline
value class LuminousEfficacy(val lumensPerWatt: Double) : Units<LuminousEfficacy> {
    override fun plus(other: LuminousEfficacy): LuminousEfficacy = LuminousEfficacy(lumensPerWatt + other.lumensPerWatt)
    override fun minus(other: LuminousEfficacy): LuminousEfficacy = LuminousEfficacy(lumensPerWatt - other.lumensPerWatt)
    override fun times(factor: Number): LuminousEfficacy = LuminousEfficacy(lumensPerWatt * factor.toDouble())
    override fun div(factor: Number): LuminousEfficacy = LuminousEfficacy(lumensPerWatt / factor.toDouble())
    override fun compareTo(other: LuminousEfficacy): Int = lumensPerWatt.compareTo(other.lumensPerWatt)
}
