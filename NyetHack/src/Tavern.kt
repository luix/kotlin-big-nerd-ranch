import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

const val DRAGON_COIN_VALUATION = 1.43

// the cask holds 5 gallons of Dragon's Breath, and 1 pint = 0.125 gallons
var remainingPintsOfDragonsBreath = 5.0 / 0.125

var playerGold = 10
var playerSilver = 10
var playerDragonCoin = 5.0   // 1 dragoncoin = 1.43 gold
val patronList = listOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")

    println("Initial pints of Dragon's Breath: $remainingPintsOfDragonsBreath")
    remainingPintsChallenge()

    println(patronList.getOrElse(4) { "Unknown Patron" })
}

fun remainingPintsChallenge() {
    for (i in 1..12) {
        sellOneDragonsBreathPint()
    }
    println("Remaining pints of Dragon's Breath: $remainingPintsOfDragonsBreath")
}

fun sellOneDragonsBreathPint() {
    // dragonsBreathQuantity -= 0.125   // 1 pint = 0.125 gallons
    --remainingPintsOfDragonsBreath
}

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Please, go straight back - your table is ready."
    } ?: "Welcome to the tavern. You'll be seated soon."
}

fun performPurchase(price: Double) {
    displayBalance()
    //val totalPurse = playerGold + (playerSilver / 100.0)
    val totalPurse = playerDragonCoin * DRAGON_COIN_VALUATION
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    if (totalPurse < price) {
        println("Customer has not enough silver, gold neither enough dragoncoin to buy a delicious drink")
        return
    }
    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    playerDragonCoin = (playerGold / DRAGON_COIN_VALUATION) + (playerSilver / DRAGON_COIN_VALUATION / 100)
    displayBalance()
}

fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
    println("Dragoncoin balance: $playerDragonCoin")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for \$$price pesos."
    println(message)

    for (i in 1..4) {
        performPurchase(price.toDouble())
    }

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal exclaims: Thanks for the $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }