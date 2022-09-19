package faraday

fun main() {
    buildUnits {
        // Base units
        val chemicalAmount by unit(base = "moles", enableExtensions = true)
        val distance by unit(base = "meters", enableExtensions = true)
        val electricCurrent by unit(base = "amperes", enableExtensions = true)
        val luminousIntensity by unit(base = "candelas", enableExtensions = true)
        val mass by unit(base = "kilograms", enableExtensions = true) {
            val carat = constant(name = "CARAT", value = 2e-4)
            val pound = constant(name = "POUND", value = 0.45359237)

            unit("milligrams", factor = MetricFactor.Milli.value / 1000, createNumberExtension = true)
            unit("grams", factor = 1e-3, createNumberExtension = true)
            unit("tonnes", factor = 1e3, createNumberExtension = false)
            unit("carats", factor = carat, createNumberExtension = true)
            unit("pounds", factor = pound, createNumberExtension = true)
        }
        val temperature by unit("kelvin", enableExtensions = true)
        val time by unit("seconds", enableExtensions = true)

        // Derived units
        val acceleration by unit("metersPerSecondSquared", enableExtensions = true)
        val angle by unit("radians", enableExtensions = true)
        val area by unit("squareMeters", enableExtensions = true)
        val catalysis by unit("katals", enableExtensions = true)
        val electricCapacitance by unit("farads", enableExtensions = true)
        val electricCharge by unit("coulombs", enableExtensions = true)
        val electricConductance by unit("siemens", enableExtensions = true)
        val electricInductance by unit("henrys", enableExtensions = true)
        val electricResistance by unit("ohms", enableExtensions = true)
        val energy by unit("joules", enableExtensions = true)
        val force by unit("newtons", enableExtensions = true)
        val frequency by unit("hertz", enableExtensions = true)
        val illuminance by unit("lux", enableExtensions = true)
        val luminousFlux by unit("lumens", enableExtensions = true)
        val magneticFlux by unit("webers", enableExtensions = true)
        val magneticInduction by unit("teslas", enableExtensions = true)
        val power by unit("watts", enableExtensions = true)
        val pressure by unit("pascals", enableExtensions = true)
        val radiationAbsorbedDose by unit("grays", enableExtensions = true)
        val radiationEquivalentDose by unit("sieverts", enableExtensions = true)
        val radioactivity by unit("becquerels", enableExtensions = true)
        val solidAngle by unit("steradians", enableExtensions = true)
        val voltage by unit("volts", enableExtensions = true)
        val volume by unit("cubicMeters", enableExtensions = true)

        conversions += catalysis equalTo chemicalAmount / time
        conversions += electricCapacitance equalTo electricCharge / voltage
        conversions += electricCapacitance equalTo time / electricResistance
        conversions += electricCapacitance equalTo electricConductance / frequency
        conversions += electricCharge equalTo electricCurrent * time
        conversions += electricConductance equalTo electricCurrent / voltage
        conversions += electricResistance equalTo voltage / electricCurrent
        conversions += electricResistance equalTo electricInductance / time
        conversions += energy equalTo force * distance
        conversions += energy equalTo pressure * volume
        conversions += energy equalTo power * time
        conversions += energy equalTo electricCharge * voltage
        conversions += force equalTo mass * acceleration
        conversions += illuminance equalTo luminousFlux / area
        conversions += luminousFlux equalTo luminousIntensity * solidAngle
        conversions += magneticFlux equalTo electricResistance * electricCharge
        conversions += magneticFlux equalTo voltage * time
        conversions += magneticFlux equalTo electricInductance * electricCurrent
        conversions += magneticFlux equalTo energy / electricCurrent
        conversions += magneticInduction equalTo magneticFlux / area
        conversions += power equalTo voltage * electricCurrent
        conversions += pressure equalTo force / area
        conversions += voltage equalTo power / electricCurrent
        conversions += volume equalTo area * distance

        // Kinematic
        val angularAcceleration by unit("radiansPerSecondSquared", enableExtensions = false)
        val angularVelocity by unit("radiansPerSecond", enableExtensions = false)
        val velocity by unit("metersPerSecond", enableExtensions = true)

        conversions += acceleration equalTo velocity * time
        conversions += angularAcceleration equalTo angularVelocity / time
        conversions += angularVelocity equalTo angle / time
        conversions += velocity equalTo distance / time


        // Mechanical
        val areaDensity by unit("kgPerSquareMeter", enableExtensions = false)
        val density by unit("kgPerCubicMeter", enableExtensions = true)
        val energyFluxDensity by unit("joulesPerSquareMeterSecond", enableExtensions = false)
        val fuelEfficiency by unit("metersPerCubicMeter", enableExtensions = false)
        val irradiance by unit("wattsPerSquareMeter", enableExtensions = false)
        val massFlowRate by unit("kilogramsPerSecond", enableExtensions = false)
        val massFraction by unit("ppm", enableExtensions = false)
        val momentOfInertia by unit("kilogramMetersPerSecond", enableExtensions = false)
        val momentum by unit("kilogramMetersPerSecond", enableExtensions = false){
            unit("newtonSecond", factor = 1)
        }
        val powerDensity by unit("wattsPerCubicMeter", enableExtensions = false)
        val radiance by unit("wattsPerSteradianSquareMeter", enableExtensions = false)
        val radiantExposure by unit("joulesPerSquareMeter", enableExtensions = false)
        val radiantIntensity by unit("wattsPerSteradian", enableExtensions = false)
        val specificEnergy by unit("joulesPerKilogram", enableExtensions = false)
        val specificImpulse by unit("isp", enableExtensions = false)
        val specificVolume by unit("cubicMetersPerKilogram", enableExtensions = false)
        val spectralIntensity by unit("wattsPerSteradianMeter", enableExtensions = false)
        val spectralIrradiance by unit("wattsPerCubicMeter", enableExtensions = false)
        val spectralPower by unit("wattsPerMeter", enableExtensions = false)
        val spectralRadiance by unit("wattsPerSteradianCubicMeter", enableExtensions = false)
        val stiffness by unit("joulesPerSquareMeter", enableExtensions = false)
        val surfaceTension by unit("newtonsPerMeter", enableExtensions = false)
        val torque by unit("newtonMeters", enableExtensions = false)
        val volumetricFlowRate by unit("cubicMetersPerSecond", enableExtensions = false)

        conversions += area equalTo distance * distance
        conversions += areaDensity equalTo mass / area
        conversions += density equalTo mass / volume
        conversions += energyFluxDensity equalTo radiantExposure / time
        conversions += fuelEfficiency equalTo distance / volume
        conversions += irradiance equalTo power / area
        conversions += massFlowRate equalTo mass / time
        conversions += massFraction equalTo mass / mass
        conversions += momentOfInertia equalTo mass * velocity
        conversions += momentum equalTo mass * velocity
        conversions += momentum equalTo force * time
        conversions += powerDensity equalTo power / volume
        conversions += radiance equalTo radiantIntensity / area
        conversions += radiantExposure equalTo energy / area
        conversions += radiantIntensity equalTo power / solidAngle
        conversions += specificEnergy equalTo energy / mass
        conversions += specificVolume equalTo volume / mass
        conversions += spectralRadiance equalTo radiantIntensity / volume
        conversions += spectralIntensity equalTo radiantIntensity / area
        conversions += spectralIrradiance equalTo power / volume
        conversions += spectralPower equalTo power / distance
        conversions += stiffness equalTo energy / area
        conversions += surfaceTension equalTo force / distance
        conversions += torque equalTo force * distance
        conversions += volumetricFlowRate equalTo volume / time


        // Electromagnetic
        val electricalConductivity by unit("siemensPerMeter", enableExtensions = false)
        val electricalResistivity by unit("ohmMeters", enableExtensions = false)
        val electricChargeDensity by unit("coulombsPerCubicMeter", enableExtensions = false)
        val electricCurrentDensity by unit("amperesPerSquareMeter", enableExtensions = false)
        val electricFieldStrength by unit("voltsPerMeter", enableExtensions = false)
        val electricInduction by unit("coulombsPerSquareMeter", enableExtensions = false)
        val electronMobility by unit("squareMetersPerVoltSecond", enableExtensions = false)
        val linearChargeDensity by unit("coulombsPerMeter", enableExtensions = false)
        val magneticDipoleMoment by unit("joulesPerTesla", enableExtensions = false)
        val magneticMoment by unit("weberMeters", enableExtensions = false)
        val magneticPermeability by unit("henrysPerMeter", enableExtensions = false)
        val magneticRigidity by unit("teslaMeters", enableExtensions = false)
        val magneticSusceptibility by unit("metersPerHenry", enableExtensions = false)
        val magneticVectorPotential by unit("webersPerMeter", enableExtensions = false)
        val magnetization by unit("amperesPerMeter", enableExtensions = false)
        val magnetomotiveForce by unit("ampereRadians", enableExtensions = false)
        val permittivity by unit("faradsPerMeter", enableExtensions = false)
        val polarizationDensity by unit("coulombsPerSquareMeter", enableExtensions = false)
        val radiationExposure by unit("coulombsPerKg", enableExtensions = false)

        conversions += electricalConductivity equalTo electricConductance / distance
        conversions += electricalResistivity equalTo electricResistance * distance
        conversions += electricChargeDensity equalTo electricCharge / volume
        conversions += electricCurrentDensity equalTo electricCurrent / area
        conversions += electricFieldStrength equalTo voltage / distance
        conversions += electricInduction equalTo electricCharge / area
        conversions += linearChargeDensity equalTo electricCharge / distance
        conversions += magneticDipoleMoment equalTo energy / magneticInduction
        conversions += magneticMoment equalTo magneticFlux * distance
        conversions += magneticPermeability equalTo electricInductance / distance
        conversions += magneticRigidity equalTo magneticInduction * distance
        conversions += magneticSusceptibility equalTo distance / electricInductance
        conversions += magneticVectorPotential equalTo magneticFlux / distance
        conversions += magnetization equalTo electricCurrent / distance
        conversions += magnetomotiveForce equalTo electricCurrent / angle
        conversions += permittivity equalTo electricCapacitance / distance
        conversions += polarizationDensity equalTo electricCharge / area
        conversions += radiationExposure equalTo electricCharge / mass


        // Thermodynamic
        val heatCapacity by unit("joulesPerKelvin", enableExtensions = false)
        val specificHeatCapacity by unit("joulesPerKilogramKelvin", enableExtensions = false)
        val temperatureGradient by unit("kelvinsPerMeter", enableExtensions = false)
        val thermalConductivity by unit("wattsPerMeterKelvin", enableExtensions = false)
        val thermalResistance by unit("kelvinsPerWatt", enableExtensions = false)

        conversions += heatCapacity equalTo energy / temperature
        conversions += specificHeatCapacity equalTo heatCapacity / temperature
        conversions += temperatureGradient equalTo temperature / distance
        conversions += thermalConductivity equalTo spectralPower / temperature
        conversions += thermalResistance equalTo temperature / power

        // Molar
        val catalyticEfficiency by unit("cubicMetersPerMoleSecond", enableExtensions = false)
        val molality by unit("molesPerKilogram", enableExtensions = false)
        val molarConductivity by unit("siemensSquareMetersPerMole", enableExtensions = false)
        val molarEnergy by unit("joulesPerMole", enableExtensions = false)
        val molarHeatCapacity by unit("joulesPerKelvinMole", enableExtensions = false)
        val molarity by unit("molesPerCubicMeter", enableExtensions = false)
        val molarMass by unit("kilogramsPerMole", enableExtensions = false)
        val molarVolume by unit("cubicMetersPerMole", enableExtensions = false)

        conversions += catalyticEfficiency equalTo molarVolume / time
        conversions += molality equalTo chemicalAmount / mass
        conversions += molarEnergy equalTo energy / chemicalAmount
        conversions += molarHeatCapacity equalTo heatCapacity / chemicalAmount
        conversions += molarity equalTo chemicalAmount / volume
        conversions += molarMass equalTo mass / chemicalAmount
        conversions += molarVolume equalTo volume / chemicalAmount

        // Photometric
        val luminance by unit("candelasPerSquareMeter", enableExtensions = false)
        val luminousEfficacy by unit("lumensPerWatt", enableExtensions = false)
        val luminousEnergy by unit("lumenSeconds", enableExtensions = false)
        val luminousExposure by unit("luxSeconds", enableExtensions = false)

        conversions += luminance equalTo luminousIntensity / area
        conversions += luminousEfficacy equalTo luminousFlux / power
        conversions += luminousEnergy equalTo luminousFlux / time
        conversions += luminousExposure equalTo illuminance / time
    }
}
