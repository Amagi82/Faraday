package faraday

import kotlin.math.pow

operator fun Mass.times(acceleration: Acceleration) = Force(newtons = kilograms * acceleration.metersPerSecondSquared)
operator fun Acceleration.times(mass: Mass): Force = mass * this
operator fun Force.div(mass: Mass) = Acceleration(metersPerSecondSquared = newtons / mass.kilograms)
operator fun Force.div(acceleration: Acceleration) = Mass(kilograms = newtons / acceleration.metersPerSecondSquared)

operator fun Acceleration.times(time: Time) = Velocity(metersPerSecond = metersPerSecondSquared * time.seconds)
operator fun Time.times(acceleration: Acceleration): Velocity = acceleration * this
operator fun Velocity.div(acceleration: Acceleration) = Time(seconds = metersPerSecond / acceleration.metersPerSecondSquared)
operator fun Velocity.div(time: Time) = Acceleration(metersPerSecondSquared = metersPerSecond / time.seconds)

operator fun Force.times(distance: Distance) = Energy(joules = newtons * distance.meters)
operator fun Distance.times(force: Force): Energy = force * this
operator fun Energy.div(force: Force) = Distance(meters = joules / force.newtons)
operator fun Energy.div(distance: Distance) = Force(newtons = joules / distance.meters)

operator fun Velocity.times(time: Time) = Distance(meters = metersPerSecond * time.seconds)
operator fun Time.times(velocity: Velocity): Distance = velocity * this
operator fun Distance.div(time: Time) = Velocity(metersPerSecond = meters / time.seconds)
operator fun Distance.div(velocity: Velocity) = Time(seconds = meters / velocity.metersPerSecond)

operator fun Power.times(time: Time) = Energy(joules = watts * time.seconds)
operator fun Time.times(power: Power): Energy = power * this
operator fun Energy.div(time: Time) = Power(watts = joules / time.seconds)
operator fun Energy.div(power: Power) = Time(seconds = joules / power.watts)

operator fun Pressure.times(area: Area) = Force(newtons = pascals * area.squareMeters)
operator fun Area.times(pressure: Pressure): Force = pressure * this
operator fun Force.div(area: Area) = Pressure(pascals = newtons / area.squareMeters)
operator fun Force.div(pressure: Pressure) = Area(squareMeters = newtons / pressure.pascals)

operator fun Mass.times(velocity: Velocity) = Momentum(newtonSeconds = kilograms * velocity.metersPerSecond)
operator fun Velocity.times(mass: Mass): Momentum = mass * this
operator fun Momentum.div(mass: Mass) = Velocity(metersPerSecond = newtonSeconds / mass.kilograms)
operator fun Momentum.div(velocity: Velocity) = Mass(kilograms = newtonSeconds / velocity.metersPerSecond)

operator fun Time.times(flowRate: VolumetricFlowRate) = Volume(cubicMeters = seconds * flowRate.cubicMetersPerSecond)
operator fun VolumetricFlowRate.times(time: Time): Volume = time * this
operator fun Volume.div(flowRate: VolumetricFlowRate) = Time(seconds = cubicMeters / flowRate.cubicMetersPerSecond)
operator fun Volume.div(time: Time) = VolumetricFlowRate(cubicMetersPerSecond = cubicMeters / time.seconds)

fun Energy.toMass() = Mass(joules / Velocity.LIGHT.pow(2))
fun Mass.toEnergy() = Energy(joules = kilograms * Velocity.LIGHT.pow(2))
