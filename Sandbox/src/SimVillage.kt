fun main(args: Array<String>) {
    val greetingFunction: () -> String = {
        val currentYear = 2019
        "Welcome to SimVillage, Major! (copyright $currentYear)"
    }

    println(greetingFunction())
}