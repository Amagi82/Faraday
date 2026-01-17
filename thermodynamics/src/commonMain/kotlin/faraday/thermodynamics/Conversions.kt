package faraday.thermodynamics

import faraday.Conversion
import faraday.core.Distance
import faraday.core.Energy
import faraday.core.Mass
import faraday.core.Temperature

@Conversion(factor1 = HeatCapacity::class, factor2 = Temperature::class, resultType = Energy::class)
@Conversion(factor1 = TemperatureGradient::class, factor2 = Distance::class, resultType = Temperature::class)
@Conversion(factor1 = SpecificHeatCapacity::class, factor2 = Mass::class, resultType = HeatCapacity::class)
internal object Conversions