enum class Operation(val symbol: String) {
    Plus("+"),
    Minus("-"),
    Times("*"),
    Div("/");

    val operator: String get() = name.lowercase()
}