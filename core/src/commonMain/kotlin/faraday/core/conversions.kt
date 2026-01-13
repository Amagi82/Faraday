package faraday.core

operator fun Distance.times(distance: Distance) = Area(squareMeters = meters * distance.meters)
operator fun Area.div(distance: Distance) = Distance(meters = squareMeters / distance.meters)

operator fun Area.times(distance: Distance) = Volume(cubicMeters = squareMeters * distance.meters)
operator fun Distance.times(area: Area): Volume = area * this
operator fun Volume.div(area: Area) = Distance(meters = cubicMeters / area.squareMeters)
operator fun Volume.div(distance: Distance) = Area(squareMeters = cubicMeters / distance.meters)

operator fun Density.times(volume: Volume) = Mass(kilograms = volume.cubicMeters * kgPerCubicMeter)
operator fun Volume.times(density: Density): Mass = density * this
operator fun Mass.div(density: Density) = Volume(cubicMeters = kilograms / density.kgPerCubicMeter)
operator fun Mass.div(volume: Volume) = Density(kgPerCubicMeter = kilograms / volume.cubicMeters)

operator fun Pressure.times(volume: Volume) = Energy(joules = pascals * volume.cubicMeters)
operator fun Volume.times(pressure: Pressure): Energy = pressure * this
operator fun Energy.div(volume: Volume) = Pressure(pascals = joules / volume.cubicMeters)
operator fun Energy.div(pressure: Pressure) = Volume(cubicMeters = joules / pressure.pascals)
