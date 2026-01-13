package faraday.thermodynamics

import faraday.core.Distance
import faraday.core.Energy
import faraday.core.Mass
import faraday.core.Temperature

operator fun HeatCapacity.times(temperature: Temperature) = Energy(joules = joulesPerKelvin * temperature.kelvin)
operator fun Temperature.times(heatCapacity: HeatCapacity): Energy = heatCapacity * this
operator fun Energy.div(heatCapacity: HeatCapacity) = Temperature(kelvin = joules / heatCapacity.joulesPerKelvin)
operator fun Energy.div(temperature: Temperature) = HeatCapacity(joulesPerKelvin = joules / temperature.kelvin)

operator fun TemperatureGradient.times(distance: Distance) = Temperature(kelvin = kelvinsPerMeter * distance.meters)
operator fun Distance.times(tempGradient: TemperatureGradient): Temperature = tempGradient * this
operator fun Temperature.div(distance: Distance) = TemperatureGradient(kelvinsPerMeter = kelvin / distance.meters)
operator fun Temperature.div(tempGradient: TemperatureGradient) = Distance(meters = kelvin / tempGradient.kelvinsPerMeter)

operator fun SpecificHeatCapacity.times(mass: Mass) = HeatCapacity(joulesPerKelvin = joulesPerKilogramKelvin * mass.kilograms)
operator fun Mass.times(specificHeatCapacity: SpecificHeatCapacity): HeatCapacity = specificHeatCapacity * this
operator fun HeatCapacity.div(mass: Mass) = SpecificHeatCapacity(joulesPerKilogramKelvin = joulesPerKelvin / mass.kilograms)
operator fun HeatCapacity.div(specificHeatCapacity: SpecificHeatCapacity) = Mass(kilograms = joulesPerKelvin / specificHeatCapacity.joulesPerKilogramKelvin)
