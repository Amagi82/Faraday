package faraday.electromagnetics

import faraday.Conversion
import faraday.core.Area
import faraday.core.Energy
import faraday.core.Time
import faraday.kinematics.Frequency
import faraday.kinematics.Power

@Conversion(factor1 = ElectricCurrent::class, factor2 = ElectricResistance::class, resultType = Voltage::class)
@Conversion(factor1 = ElectricCurrent::class, factor2 = Voltage::class, resultType = Power::class)
@Conversion(factor1 = ElectricCurrent::class, factor2 = Time::class, resultType = ElectricCharge::class)
@Conversion(factor1 = ElectricCapacitance::class, factor2 = Voltage::class, resultType = ElectricCharge::class)
@Conversion(factor1 = ElectricCapacitance::class, factor2 = ElectricResistance::class, resultType = Time::class)
@Conversion(factor1 = ElectricInductance::class, factor2 = ElectricCurrent::class, resultType = MagneticFlux::class)
@Conversion(factor1 = MagneticInduction::class, factor2 = Area::class, resultType = MagneticFlux::class)
@Conversion(factor1 = Voltage::class, factor2 = Time::class, resultType = MagneticFlux::class)
@Conversion(factor1 = ElectricCapacitance::class, factor2 = Frequency::class, resultType = ElectricConductance::class)
@Conversion(factor1 = MagneticFlux::class, factor2 = ElectricCurrent::class, resultType = Energy::class)
@Conversion(factor1 = ElectricResistance::class, factor2 = Time::class, resultType = ElectricInductance::class)
@Conversion(factor1 = ElectricResistance::class, factor2 = ElectricCharge::class, resultType = MagneticFlux::class)
@Conversion(factor1 = ElectricCharge::class, factor2 = Voltage::class, resultType = Energy::class)
internal object Conversions

fun ElectricConductance.asResistance() = ElectricResistance(ohms = 1 / siemens)
fun ElectricResistance.asConductance() = ElectricConductance(siemens = 1 / ohms)
