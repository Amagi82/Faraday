# Faraday

Faraday is a Kotlin Multiplatform library that adds type-safe units of measurement, allowing for easy conversion between metric & imperial units, as well as automatic type conversion for many simple equations. The type safety makes it way harder to make mistakes, and the built-in conversions save a bunch of time looking everything up. 

Usage examples: 

```
val distance: Distance = 1215.meters
val time: Time = 6.7.seconds
val velocity: Velocity = distance / time

println(velocity.metersPerSecond)     // 181.34328358208955
println(velocity.kilometersPerHour)   // 671.6417910447761
println(velocity.kilometersPerSecond) // 0.18134328358208956
println(velocity.milesPerHour)        // 405.6533723650894
println(velocity.knots)               // 352.80794471223646
```

```
val volume: Volume = 3.3.meters * 1.5.meters * 0.4.meters
val density: Density = 819.kgPerCubicMeter
val mass: Mass = volume * density

println(volume.quartsUS)                  // 2092.2426546765355
println(volume.quartsImp)                 // 1742.156446528775
println(density.gramsPerCubicCentimeter)  // 0.819
println(mass.pounds)                      // 3575.0601360424116
```

#### Faraday is easily extensible:
```
// Working with small amounts of energy?
val Number.millijoules get() = Energy(joules = toDouble() * Prefixes.MILLI)
val Energy.millijoules: Double get() = joules / Prefixes.MILLI

val energy: Energy = 800.millijoules
println(energy.millijoules)           // 800.0
println(energy.btus)                  // 7.586533902323376E-4
```

Conversion between units is handled with operator functions, which you can extend like this: 
```
operator fun Force.times(distance: Distance) = Energy(joules = newtons * distance.meters)
operator fun Force.div(area: Area) = Pressure(pascals = newtons / area.squareMeters)
```

Find a mistake? Missing a unit? Contributions welcome, feel free to open a PR.
