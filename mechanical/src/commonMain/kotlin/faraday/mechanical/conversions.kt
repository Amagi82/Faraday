package faraday.mechanical

import faraday.core.*
import faraday.kinematics.Force
import faraday.kinematics.Power

operator fun Force.times(distance: Distance) = Torque(newtonMeters = newtons * distance.meters)
operator fun Distance.times(force: Force): Torque = force * this
operator fun Torque.div(force: Force) = Distance(meters = newtonMeters / force.newtons)
operator fun Torque.div(distance: Distance) = Force(newtons = newtonMeters / distance.meters)

operator fun RotationalStiffness.times(angle: Angle) = Torque(newtonMeters = newtonMetersPerRadian * angle.radians)
operator fun Angle.times(rotationalStiffness: RotationalStiffness): Torque = rotationalStiffness * this
operator fun Torque.div(angle: Angle) = RotationalStiffness(newtonMetersPerRadian = newtonMeters / angle.radians)
operator fun Torque.div(stiffness: RotationalStiffness) = Angle(radians = newtonMeters / stiffness.newtonMetersPerRadian)

operator fun Stiffness.times(distance: Distance) = Force(newtons = newtonsPerMeter * distance.meters)
operator fun Distance.times(stiffness: Stiffness): Force = stiffness * this
operator fun Force.div(distance: Distance) = Stiffness(newtonsPerMeter = newtons / distance.meters)
operator fun Force.div(stiffness: Stiffness) = Distance(meters = newtons / stiffness.newtonsPerMeter)

operator fun MassFlowRate.times(time: Time) = Mass(kilograms = kilogramsPerSecond * time.seconds)
operator fun Time.times(flowRate: MassFlowRate): Mass = flowRate * this
operator fun Mass.div(flowRate: MassFlowRate) = Time(seconds = kilograms / flowRate.kilogramsPerSecond)
operator fun Mass.div(time: Time) = MassFlowRate(kilogramsPerSecond = kilograms / time.seconds)

operator fun VolumetricFlowRate.times(time: Time) = Volume(cubicMeters = cubicMetersPerSecond * time.seconds)
operator fun Time.times(flowRate: VolumetricFlowRate): Volume = flowRate * this
operator fun Volume.div(flowRate: VolumetricFlowRate) = Time(seconds = cubicMeters / flowRate.cubicMetersPerSecond)
operator fun Volume.div(time: Time) = VolumetricFlowRate(cubicMetersPerSecond = cubicMeters / time.seconds)

operator fun PowerDensity.times(volume: Volume) = Power(watts = wattsPerCubicMeter * volume.cubicMeters)
operator fun Volume.times(powerDensity: PowerDensity) = powerDensity * this
operator fun Power.div(volume: Volume) = PowerDensity(wattsPerCubicMeter = watts / volume.cubicMeters)
operator fun Power.div(powerDensity: PowerDensity) = Volume(cubicMeters = watts / powerDensity.wattsPerCubicMeter)

operator fun FuelEfficiency.times(volume: Volume) = Distance(meters = metersPerCubicMeter * volume.cubicMeters)
operator fun Volume.times(fuelEfficiency: FuelEfficiency) = fuelEfficiency * this
operator fun Distance.div(volume: Volume) = FuelEfficiency(metersPerCubicMeter = meters / volume.cubicMeters)
operator fun Distance.div(fuelEfficiency: FuelEfficiency) = Volume(cubicMeters = meters / fuelEfficiency.metersPerCubicMeter)

operator fun SpecificVolume.times(mass: Mass) = Volume(cubicMeters = cubicMetersPerKilogram * mass.kilograms)
operator fun Mass.times(specificVolume: SpecificVolume): Volume = specificVolume * this
operator fun Volume.div(specificVolume: SpecificVolume) = Mass(kilograms = cubicMeters / specificVolume.cubicMetersPerKilogram)
operator fun Volume.div(mass: Mass) = SpecificVolume(cubicMetersPerKilogram = cubicMeters / mass.kilograms)

operator fun SpecificEnergy.times(mass: Mass) = Force(newtons = joulesPerKilogram * mass.kilograms)
operator fun Mass.times(specificEnergy: SpecificEnergy): Force = specificEnergy * this
operator fun Force.div(mass: Mass) = SpecificEnergy(joulesPerKilogram = newtons / mass.kilograms)
operator fun Force.div(specificEnergy: SpecificEnergy) = Mass(kilograms = newtons / specificEnergy.joulesPerKilogram)

operator fun MassFraction.times(mass: Mass) = Mass(kilograms = ratio * mass.kilograms)
operator fun Mass.times(massFraction: MassFraction): Mass = massFraction * this
operator fun Mass.div(mass: Mass) = MassFraction(ratio = kilograms / mass.kilograms)
operator fun Mass.div(massFraction: MassFraction) = Mass(kilograms = kilograms / massFraction.ratio)

operator fun AreaDensity.times(area: Area) = Mass(kilograms = kgPerSquareMeter * area.squareMeters)
operator fun Area.times(areaDensity: AreaDensity): Mass = areaDensity * this
operator fun Mass.div(areaDensity: AreaDensity) = Area(squareMeters = kilograms / areaDensity.kgPerSquareMeter)
operator fun Mass.div(area: Area) = AreaDensity(kgPerSquareMeter = kilograms / area.squareMeters)
