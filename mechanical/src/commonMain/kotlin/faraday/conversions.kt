package faraday

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

operator fun FuelEfficiency.times(volume: Volume) = Distance(meters = metersPerCubicMeter * volume.cubicMeters)
operator fun Volume.times(fuelEfficiency: FuelEfficiency) = fuelEfficiency * this
operator fun Distance.div(volume: Volume) = FuelEfficiency(metersPerCubicMeter = meters / volume.cubicMeters)
operator fun Distance.div(fuelEfficiency: FuelEfficiency) = Volume(cubicMeters = meters / fuelEfficiency.metersPerCubicMeter)
