const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "Madrigal buys a $name ($type) for $price pesos."
    println(message)
}