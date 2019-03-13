fun main(args: Array<String>) {
    var beverage = readLine()
    // beverage = null

    beverage?.let {
        beverage.capitalize()
    } ?: "Butter Ale"

    println(beverage)
}