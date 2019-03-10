fun main(args: Array<String>) {
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2019
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, Major $playerName! (copyright $currentYear)"
    }

    println(greetingFunction("Yomero", 3))
}