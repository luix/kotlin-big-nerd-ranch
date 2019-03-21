import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

const val DRAGON_COIN_VALUATION = 1.43

// the cask holds 5 gallons of Dragon's Breath, and 1 pint = 0.125 gallons
var remainingPintsOfDragonsBreath = 5.0 / 0.125

var playerGold = 10
var playerSilver = 10
var playerDragonCoin = 5.0   // 1 dragoncoin = 1.43 gold
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File("data/tavern-menu-items.txt")
                    .readText()
        .split("\n")

fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
        placeOrder(patron, "shandy,Dragon's Breath,5.91")
    }
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

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for \$$price pesos."
    println(message)

    for (i in 1..4) {
        performPurchase(price.toDouble())
    }

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName exclaims: Thanks for the $name"
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