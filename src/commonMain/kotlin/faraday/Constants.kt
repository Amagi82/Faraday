package faraday

object Constants {
    /**
     * The gravitational constant (also known as the universal gravitational constant, the Newtonian constant of
     * gravitation, or the Cavendish gravitational constant), denoted by the letter G, is an empirical physical
     * constant involved in the calculation of gravitational effects in Sir Isaac Newton's law of universal
     * gravitation and in Albert Einstein's general theory of relativity.
     *
     * In Newton's law, it is the proportionality constant connecting the gravitational force between two bodies
     * with the product of their masses and the inverse square of their distance. In the Einstein field equations,
     * it quantifies the relation between the geometry of spacetime and the energy–momentum tensor (also referred
     * to as the stress–energy tensor).
     *
     * [Wiki](https://en.wikipedia.org/wiki/Gravitational_constant)
     */
    const val GRAVITATIONAL_CONSTANT = 6.6743015e-11

    /**
     * The Avogadro constant (NA or L) is the proportionality factor that relates the number of constituent
     * particles (usually molecules, atoms or ions) in a sample with the amount of substance in that sample.
     * Its SI unit is the reciprocal mole, and it is defined as NA = 6.02214076×1023 mol−1.
     *
     * The numeric value of the Avogadro constant expressed in reciprocal mole, a dimensionless number, is
     * called the Avogadro number, which is thus the number of particles that are contained in one mole.
     *
     * The value of the Avogadro constant was chosen so that the mass of one mole of a chemical compound, in
     * grams, is numerically equal (for all practical purposes) to the average mass of one molecule of the
     * compound, in daltons (universal atomic mass units); one dalton being 1/12 of the mass of one carbon-12
     * atom, which is approximately the mass of one nucleon (proton or neutron). For example, the average mass
     * of one molecule of water is about 18.0153 daltons, and one mole of water (N molecules) is about 18.0153
     * grams. Thus, the Avogadro constant NA is the proportionality factor that relates the molar mass of a
     * substance to the average mass of one molecule, and the Avogadro number is also the approximate number of
     * nucleons in one gram of ordinary matter.
     *
     * The Avogadro constant also relates the molar volume of a substance to the average volume nominally
     * occupied by one of its particles, when both are expressed in the same units of volume. For example, since
     * the molar volume of water in ordinary conditions is about 18 mL/mol, the volume occupied by one molecule
     * of water is about 18/6.022e−23 mL, or about 30 Å3 (cubic angstroms). For a crystalline substance, it
     * similarly relates its molar volume (in mL/mol), the volume of the repeating unit cell of the crystals
     * (in mL), and the number of molecules in that cell.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Avogadro_constant)
     */
    const val AVOGADRO_CONSTANT = 6.02214076e23

    /**
     * The Boltzmann constant (kB or k) is the proportionality factor that relates the average relative kinetic
     * energy of particles in a gas with the thermodynamic temperature of the gas. It occurs in the definitions
     * of the kelvin and the gas constant, and in Planck's law of black-body radiation and Boltzmann's entropy
     * formula. The Boltzmann constant has the dimension energy divided by temperature, the same as entropy.
     *
     * As part of the 2019 redefinition of SI base units, the Boltzmann constant is one of the seven "defining
     * constants" that have been given exact definitions. They are used in various combinations to define the
     * seven SI base units.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Boltzmann_constant)
     */
    const val BOLTZMANN_CONSTANT = 1.380649e-23

    /**
     * The gas constant (also known as the molar, universal, or ideal gas constant) is denoted by the symbol R
     * or R. It is equivalent to the Boltzmann constant, but expressed in units of energy per temperature
     * increment per mole, i.e. the pressure–volume product, rather than energy per temperature increment per
     * particle. The constant is also a combination of the constants from Boyle's law, Charles's law, Avogadro's
     * law, and Gay-Lussac's law. It is a physical constant that is featured in many fundamental equations in the
     * physical sciences, such as the ideal gas law, the Arrhenius equation, and the Nernst equation.
     *
     * Physically, the gas constant is the constant of proportionality that relates the energy scale in physics
     * to the temperature scale, when a mole of particles at the stated temperature is being considered. Thus,
     * the value of the gas constant ultimately derives from historical decisions and accidents in the setting
     * of the energy and temperature scales, plus similar historical setting of the value of the molar scale
     * used for the counting of particles. The last factor is not a consideration in the value of the Boltzmann
     * constant, which does a similar job of equating linear energy and temperature scales.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Gas_constant)
     */
    const val GAS_CONSTANT = AVOGADRO_CONSTANT * BOLTZMANN_CONSTANT

    /**
     * The speed of light in vacuum, commonly denoted c, is a universal physical constant important in many areas
     * of physics. It is exact because, by international agreement, a metre is defined as the length of the path
     * travelled by light in vacuum during a time interval of 1⁄299792458 second. According to special relativity,
     * c is the upper limit for the speed at which conventional matter and information can travel. Though this
     * speed is most commonly associated with light, it is also the speed at which all massless particles and
     * field perturbations travel in vacuum, including electromagnetic radiation and gravitational waves. Such
     * particles and waves travel at c regardless of the motion of the source or the inertial reference frame of
     * the observer. Particles with nonzero rest mass can approach c, but can never actually reach it. In the
     * special and general theories of relativity, c interrelates space and time, and also appears in the famous
     * equation of mass–energy equivalence E = mc2.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Speed_of_light)
     */
    const val LIGHT_SPEED = 299_792_458.0

    /**
     * The elementary charge, usually denoted by e or sometimes qe, is the electric charge carried by a single
     * proton or, equivalently, the magnitude of the negative electric charge carried by a single electron, which
     * has charge −1 e. This elementary charge is a fundamental physical constant. To avoid confusion over its
     * sign, e is sometimes called the elementary positive charge.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Elementary_charge)
     */
    const val ELEMENTARY_CHARGE = 1.602176634e-19

    /**
     * The Planck constant, or Planck's constant, is the quantum of electromagnetic action that relates a photon's
     * energy to its frequency. The Planck constant multiplied by a photon's frequency is equal to a photon's
     * energy. The Planck constant is a fundamental physical constant denoted as h, and of fundamental importance
     * in quantum mechanics. In metrology it is used to define the kilogram in SI units.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Planck_constant)
     */
    const val PLANCK_CONSTANT = 6.62607015e-34

    /**
     * The caesium standard is a primary frequency standard in which the photon absorption by transitions between
     * the two hyperfine ground states of caesium-133 atoms are used to control the output frequency.
     *
     * Caesium atomic clocks are the most accurate time and frequency standards, and serve as the primary standard
     * for the definition of the second in the International System of Units (SI). By definition, radiation
     * produced by the transition between the two hyperfine ground states of caesium (in the absence of external
     * influences such as the Earth's magnetic field) has a frequency, ΔνCs, of exactly 9192631770 Hz. That value
     * was chosen so that the caesium second equalled, to the limit of human measuring ability in 1960 when it was
     * adopted, the existing standard ephemeris second based on the Earth's orbit around the Sun. Because no other
     * measurement involving time had been as precise, the effect of the change was less than the experimental
     * uncertainty of all existing measurements.
     *
     * [Wiki](https://en.wikipedia.org/wiki/Caesium_standard)
     */
    const val CAESIUM_STANDARD_FREQUENCY = 9_192_631_770
}
