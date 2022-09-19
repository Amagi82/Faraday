package faraday

enum class MetricFactor(override val value: Double) : Factor {
    Yocto(value = 1e-24),
    Zepto(value = 1e-21),
    Atto(value = 1e-18),
    Femto(value = 1e-15),
    Pico(value = 1e-12),
    Nano(value = 1e-9),
    Micro(value = 1e-6),
    Milli(value = 1e-3),
    Centi(value = 1e-2),
    Deci(value = 1e-1),
    Deca(value = 1e1),
    Hecto(value = 1e2),
    Kilo(value = 1e3),
    Mega(value = 1e6),
    Giga(value = 1e9),
    Tera(value = 1e12),
    Peta(value = 1e15),
    Exa(value = 1e18),
    Zetta(value = 1e21),
    Yotta(value = 1e24)
}
