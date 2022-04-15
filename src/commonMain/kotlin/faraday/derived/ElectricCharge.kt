package faraday.derived

import faraday.Constants
import faraday.Units
import faraday.base.ElectricCurrent
import faraday.base.Time
import kotlin.jvm.JvmInline

/**
 * Electric charge is the physical property of matter that causes it to experience a force when placed
 * in an electromagnetic field. There are two types of electric charge: positive and negative (commonly
 * carried by protons and electrons respectively). Like charges repel each other and unlike charges
 * attract each other. An object with an absence of net charge is referred to as neutral. Early
 * knowledge of how charged substances interact is now called classical electrodynamics, and is still
 * accurate for problems that do not require consideration of quantum effects.
 *
 * Electric charge is a conserved property; the net charge of an isolated system, the amount of positive
 * charge minus the amount of negative charge, cannot change. Electric charge is carried by subatomic
 * particles. In ordinary matter, negative charge is carried by electrons, and positive charge is carried
 * by the protons in the nuclei of atoms. If there are more electrons than protons in a piece of matter,
 * it will have a negative charge, if there are fewer it will have a positive charge, and if there are
 * equal numbers it will be neutral. Charge is quantized; it comes in integer multiples of individual
 * small units called the elementary charge, e, about 1.602×10−19 coulombs, which is the smallest
 * charge which can exist freely (particles called quarks have smaller charges, multiples of 1/3e, but
 * they are only found in combination, and always combine to form particles with integer charge). The
 * proton has a charge of +e, and the electron has a charge of −e.
 *
 * An electric charge has an electric field, and if the charge is moving it also generates a magnetic
 * field. The combination of the electric and magnetic field is called the electromagnetic field, and
 * its interaction with charges is the source of the electromagnetic force, which is one of the four
 * fundamental forces in physics. The study of photon-mediated interactions among charged particles is
 * called quantum electrodynamics.
 *
 * The SI derived unit of electric charge is the coulomb (C) named after French physicist
 * Charles-Augustin de Coulomb. In electrical engineering, it is also common to use the ampere-hour
 * (Ah); in physics and chemistry, it is common to use the elementary charge (e as a unit). Chemistry
 * also uses the Faraday constant as the charge on a mole of electrons. The lowercase symbol q often
 * denotes charge.
 *
 * @see https://en.wikipedia.org/wiki/Electric_charge
 * */
@JvmInline
value class ElectricCharge(val coulombs: Double) : Units<ElectricCharge> {
    override fun plus(other: ElectricCharge) = ElectricCharge(coulombs = coulombs + other.coulombs)
    override fun minus(other: ElectricCharge) = ElectricCharge(coulombs = coulombs - other.coulombs)
    override fun times(factor: Number) = ElectricCharge(coulombs = coulombs * factor.toDouble())
    override fun div(factor: Number) = ElectricCharge(coulombs = coulombs / factor.toDouble())
    override fun compareTo(other: ElectricCharge): Int = coulombs.compareTo(coulombs)

    operator fun times(voltage: Voltage) = Energy(joules = coulombs * voltage.volts)
    operator fun times(resistance: ElectricResistance): MagneticFlux = resistance * this
    operator fun div(current: ElectricCurrent) = Time(seconds = coulombs / current.amperes)
    operator fun div(time: Time) = ElectricCurrent(amperes = coulombs / time.seconds)
    operator fun div(voltage: Voltage) = ElectricCapacitance(coulombs / voltage.volts)

    companion object {
        val ELEMENTARY_CHARGE get() = Constants.ELEMENTARY_CHARGE
    }
}

val Number.coulombs get() = ElectricCharge(toDouble())
