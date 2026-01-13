package faraday.electromagnetics

import faraday.core.Area
import faraday.core.Energy
import faraday.core.Time
import faraday.kinematics.Frequency
import faraday.kinematics.Power

operator fun ElectricCurrent.times(resistance: ElectricResistance) = Voltage(volts = amperes * resistance.ohms)
operator fun ElectricResistance.times(current: ElectricCurrent): Voltage = current * this
operator fun Voltage.div(current: ElectricCurrent) = ElectricResistance(ohms = volts / current.amperes)
operator fun Voltage.div(resistance: ElectricResistance) = ElectricCurrent(amperes = volts / resistance.ohms)

operator fun ElectricCurrent.times(voltage: Voltage) = Power(watts = amperes * voltage.volts)
operator fun Voltage.times(current: ElectricCurrent): Power = current * this
operator fun Power.div(current: ElectricCurrent) = Voltage(volts = watts / current.amperes)
operator fun Power.div(voltage: Voltage) = ElectricCurrent(amperes = watts / voltage.volts)

operator fun ElectricCurrent.times(time: Time) = ElectricCharge(coulombs = amperes * time.seconds)
operator fun Time.times(current: ElectricCurrent): ElectricCharge = current * this
operator fun ElectricCharge.div(current: ElectricCurrent) = Time(seconds = coulombs / current.amperes)
operator fun ElectricCharge.div(time: Time) = ElectricCurrent(amperes = coulombs / time.seconds)

operator fun ElectricCapacitance.times(voltage: Voltage) = ElectricCharge(coulombs = farads * voltage.volts)
operator fun Voltage.times(capacitance: ElectricCapacitance): ElectricCharge = capacitance * this
operator fun ElectricCharge.div(voltage: Voltage) = ElectricCapacitance(farads = coulombs / voltage.volts)
operator fun ElectricCharge.div(capacitance: ElectricCapacitance) = Voltage(volts = coulombs / capacitance.farads)

operator fun ElectricCapacitance.times(resistance: ElectricResistance) = Time(seconds = farads * resistance.ohms)
operator fun ElectricResistance.times(capacitance: ElectricCapacitance): Time = capacitance * this
operator fun Time.div(capacitance: ElectricCapacitance) = ElectricResistance(ohms = seconds / capacitance.farads)
operator fun Time.div(resistance: ElectricResistance) = ElectricCapacitance(farads = seconds / resistance.ohms)

operator fun ElectricInductance.times(current: ElectricCurrent) = MagneticFlux(webers = henrys * current.amperes)
operator fun ElectricCurrent.times(inductance: ElectricInductance): MagneticFlux = inductance * this
operator fun MagneticFlux.div(current: ElectricCurrent) = ElectricInductance(henrys = webers / current.amperes)
operator fun MagneticFlux.div(inductance: ElectricInductance) = ElectricCurrent(amperes = webers / inductance.henrys)

operator fun MagneticInduction.times(area: Area) = MagneticFlux(webers = teslas * area.squareMeters)
operator fun Area.times(induction: MagneticInduction): MagneticFlux = induction * this
operator fun MagneticFlux.div(area: Area) = MagneticInduction(teslas = webers / area.squareMeters)
operator fun MagneticFlux.div(induction: MagneticInduction) = Area(squareMeters = webers / induction.teslas)

operator fun Voltage.times(time: Time) = MagneticFlux(webers = volts * time.seconds)
operator fun Time.times(voltage: Voltage): MagneticFlux = voltage * this
operator fun MagneticFlux.div(voltage: Voltage) = Time(seconds = webers / voltage.volts)
operator fun MagneticFlux.div(time: Time) = Voltage(volts = webers / time.seconds)

operator fun ElectricCapacitance.times(frequency: Frequency) = ElectricConductance(siemens = farads * frequency.hertz)
operator fun Frequency.times(capacitance: ElectricCapacitance): ElectricConductance = capacitance * this
operator fun ElectricConductance.div(frequency: Frequency) = ElectricCapacitance(farads = siemens / frequency.hertz)
operator fun ElectricConductance.div(capacitance: ElectricCapacitance) = Frequency(hertz = siemens / capacitance.farads)

operator fun MagneticFlux.times(current: ElectricCurrent) = Energy(joules = webers * current.amperes)
operator fun ElectricCurrent.times(flux: MagneticFlux): Energy = flux * this
operator fun Energy.div(flux: MagneticFlux) = ElectricCurrent(amperes = joules / flux.webers)
operator fun Energy.div(current: ElectricCurrent) = MagneticFlux(webers = joules / current.amperes)

operator fun ElectricResistance.times(time: Time) = ElectricInductance(henrys = ohms * time.seconds)
operator fun Time.times(resistance: ElectricResistance): ElectricInductance = resistance * this
operator fun ElectricInductance.div(time: Time) = ElectricResistance(ohms = henrys / time.seconds)
operator fun ElectricInductance.div(resistance: ElectricResistance) = Time(seconds = henrys / resistance.ohms)

operator fun ElectricResistance.times(charge: ElectricCharge) = MagneticFlux(webers = ohms * charge.coulombs)
operator fun ElectricCharge.times(resistance: ElectricResistance): MagneticFlux = resistance * this
operator fun MagneticFlux.div(resistance: ElectricResistance) = ElectricCharge(coulombs = webers / resistance.ohms)
operator fun MagneticFlux.div(charge: ElectricCharge) = ElectricResistance(ohms = webers / charge.coulombs)

operator fun ElectricCharge.times(voltage: Voltage) = Energy(joules = coulombs * voltage.volts)
operator fun Voltage.times(charge: ElectricCharge): Energy = charge * this
operator fun Energy.div(charge: ElectricCharge) = Voltage(volts = joules / charge.coulombs)
operator fun Energy.div(voltage: Voltage) = ElectricCharge(coulombs = joules / voltage.volts)

fun ElectricConductance.asResistance() = ElectricResistance(ohms = 1 / siemens)
fun ElectricResistance.asConductance() = ElectricConductance(siemens = 1 / ohms)
