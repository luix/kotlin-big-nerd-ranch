fun main(args: Array<String>) {
    val greetingFunction: (String) -> String = {
        val currentYear = 2019
        "Welcome to SimVillage, Major $it! (copyright $currentYear)"
    }

    println(greetingFunction("Yomero"))
}