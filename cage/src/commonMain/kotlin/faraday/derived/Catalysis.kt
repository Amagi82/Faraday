package faraday.derived

import faraday.Units
import faraday.base.ChemicalAmount
import faraday.base.Time

/**
 * Catalysis is the process of increasing the rate of a chemical reaction by adding a
 * substance known as a catalyst, which is not consumed in the catalyzed reaction and
 * can continue to act repeatedly. Because of this, only very small amounts of catalyst
 * are required to alter the reaction rate in most cases.
 *
 * In general, chemical reactions occur faster in the presence of a catalyst because
 * the catalyst provides an alternative reaction pathway with a lower activation energy
 * than the non-catalyzed mechanism. In catalyzed mechanisms, the catalyst usually
 * reacts to form a temporary intermediate, which then regenerates the original catalyst
 * in a cyclic process. A substance which provides a mechanism with a higher activation
 * energy does not decrease the rate because the reaction can still occur by the
 * non-catalyzed route. An added substance which does reduce the reaction rate is not
 * considered a catalyst but a reaction inhibitor. Catalysis may be classified as either
 * homogeneous or heterogeneous. A homogeneous catalysis is one whose molecules are
 * dispersed in the same phase (usually gaseous or liquid) as the reactant's molecules.
 * A heterogeneous catalysis is one whose molecules are not in the same phase as the
 * reactant's, which are typically gases or liquids that are adsorbed onto the surface
 * of the solid catalyst. Enzymes and other biocatalysts are often considered as a
 * third category.
 *
 * @see https://en.wikipedia.org/wiki/Catalysis
 * */
inline class Catalysis(val katals: Double) : Units<Catalysis> {
    override fun plus(other: Catalysis) = Catalysis(katals = katals + other.katals)
    override fun minus(other: Catalysis) = Catalysis(katals = katals - other.katals)
    override fun times(factor: Number) = Catalysis(katals = katals * factor.toDouble())
    override fun div(factor: Number) = Catalysis(katals = katals / factor.toDouble())
    override fun compareTo(other: Catalysis): Int = katals.compareTo(other.katals)

    operator fun times(time: Time) = ChemicalAmount(moles = katals * time.seconds)
}

val Number.katals get() = Catalysis(toDouble())
