package faraday.kinematics

import faraday.Conversion
import faraday.core.*
import kotlin.math.pow

@Conversion(factor1 = Mass::class, factor2 = Acceleration::class, resultType = Force::class)
@Conversion(factor1 = Mass::class, factor2 = Velocity::class, resultType = Momentum::class)
@Conversion(factor1 = Force::class, factor2 = Distance::class, resultType = Energy::class)
@Conversion(factor1 = Acceleration::class, factor2 = Time::class, resultType = Velocity::class)
@Conversion(factor1 = Velocity::class, factor2 = Time::class, resultType = Distance::class)
@Conversion(factor1 = AngularVelocity::class, factor2 = Time::class, resultType = Angle::class)
@Conversion(factor1 = AngularAcceleration::class, factor2 = Time::class, resultType = AngularVelocity::class)
@Conversion(factor1 = Time::class, factor2 = VolumetricFlowRate::class, resultType = Volume::class)
@Conversion(factor1 = Power::class, factor2 = Time::class, resultType = Energy::class)
@Conversion(factor1 = Pressure::class, factor2 = Area::class, resultType = Force::class)
internal object Conversions

fun Energy.toMass() = Mass(joules / Velocity.LIGHT.pow(2))
fun Mass.toEnergy() = Energy(joules = kilograms * Velocity.LIGHT.pow(2))
