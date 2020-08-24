package konvert.derived

import konvert.Units

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
inline class Catalysis(val katals: Double): Units<Catalysis> {
    override val value: Double get() = katals
    override fun plus(other: Catalysis): Catalysis = Catalysis(katals + other.katals)
    override fun minus(other: Catalysis): Catalysis = Catalysis(katals - other.katals)
    override fun times(factor: Number): Catalysis = Catalysis(katals * factor.toDouble())
    override fun div(factor: Number): Catalysis = Catalysis(katals / factor.toDouble())
}

val Number.katals: Catalysis get() = Catalysis(toDouble())
