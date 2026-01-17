package faraday.mechanical

import faraday.Conversion
import faraday.core.*
import faraday.kinematics.Force
import faraday.kinematics.Power

@Conversion(factor1 = Force::class, factor2 = Distance::class, resultType = Torque::class)
@Conversion(factor1 = RotationalStiffness::class, factor2 = Angle::class, resultType = Torque::class)
@Conversion(factor1 = Stiffness::class, factor2 = Distance::class, resultType = Force::class)
@Conversion(factor1 = MassFlowRate::class, factor2 = Time::class, resultType = Mass::class)
@Conversion(factor1 = VolumetricFlowRate::class, factor2 = Time::class, resultType = Volume::class)
@Conversion(factor1 = PowerDensity::class, factor2 = Volume::class, resultType = Power::class)
@Conversion(factor1 = FuelEfficiency::class, factor2 = Volume::class, resultType = Distance::class)
@Conversion(factor1 = SpecificVolume::class, factor2 = Mass::class, resultType = Volume::class)
@Conversion(factor1 = SpecificEnergy::class, factor2 = Mass::class, resultType = Force::class)
@Conversion(factor1 = MassFraction::class, factor2 = Mass::class, resultType = Mass::class)
@Conversion(factor1 = AreaDensity::class, factor2 = Area::class, resultType = Mass::class)
internal object Conversions
