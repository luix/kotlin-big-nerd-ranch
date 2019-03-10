fun main(args: Array<String>) {
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2019
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, Major $playerName! (copyright $currentYear)"
    }

    runSimulation("Yomero", greetingFunction)
}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()     // Randomly selects 1, 2 or 3
    println(greetingFunction(playerName, numBuildings))
}