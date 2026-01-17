package faraday.core

import faraday.Conversion

@Conversion(factor1 = Distance::class, factor2 = Distance::class, resultType = Area::class)
@Conversion(factor1 = Area::class, factor2 = Distance::class, resultType = Volume::class)
@Conversion(factor1 = Density::class, factor2 = Volume::class, resultType = Mass::class)
@Conversion(factor1 = Pressure::class, factor2 = Volume::class, resultType = Energy::class)
internal object Conversions