fun main(args: Array<String>) {
    val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2019
        "Welcome to SimVillage, Major $playerName! (copyright $currentYear)"
    }

    println(greetingFunction("Yomero"))
}