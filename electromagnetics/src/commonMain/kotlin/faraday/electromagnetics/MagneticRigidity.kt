package faraday.electromagnetics

import faraday.InternalUnitApi
import faraday.Units
import kotlin.jvm.JvmInline

/**
 * In accelerator physics, rigidity is the effect of particular magnetic fields on the motion of the charged particles.
 *
 * It is a measure of the momentum of the particle, and it refers to the fact that a higher momentum particle will have a higher resistance to deflection by a magnetic field. It is defined as R = Bρ = p/q, where B is the magnetic field, ρ is the gyroradius of the particle due to this field, p is the particle momentum, and q is its charge. It is frequently referred to as simply "Bρ".
 *
 * [Wiki](https://en.wikipedia.org/wiki/Rigidity_(electromagnetism)
 */
@JvmInline
value class MagneticRigidity(val teslaMeters: Double) : Units<MagneticRigidity> {
    @InternalUnitApi
    override val rawValue: Double get() = teslaMeters

    @InternalUnitApi
    override fun create(value: Double) = MagneticRigidity(value)
}
