import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

// the cask holds 5 gallons of Dragon's Breath, and 1 pint = 0.125 gallons
var remainingPintsOfDragonsBreath = 5.0 / 0.125

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
                    .readText()
        .split("\n")
val patronGold = mutableMapOf<String, Double>()

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

    println("Initial pints of Dragon's Breath: $remainingPintsOfDragonsBreath")
    remainingPintsChallenge()

    runExample()

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    displayPatronBalances()

    var orderCount = 0
    while (orderCount < 10) {
        val patron = uniquePatrons.shuffled().first()
        val menuData = menuList.shuffled().first()
        placeOrder(patron, menuData)
        orderCount++
    }

    displayPatronBalances()
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

fun nameIsLong(name: String) = name.length >= 20

fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}

private fun runExample() {
    "Polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for \$$price pesos."
    println(message)

    val phrase = if (!performPurchase(price.toDouble(), patronName)) {
        "$patronName exclaims: the Tavern Bouncer is a !@#$!"
    } else if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName exclaims: Thanks for the $name"
    }
    println(phrase)
}

fun performPurchase(price: Double, patronName: String): Boolean {
    try {
        val totalPurse = patronGold.getValue(patronName)
        if (price > totalPurse) {
            // Challenge: Tavern Bouncer
            println("$patronName is bounced from tavern since not enough founds")
            uniquePatrons.remove(patronName)
            patronGold.remove(patronName)
            return false
        } else {
            patronGold[patronName] = totalPurse - price
            return true
        }
    } catch (ex: NoSuchElementException) {
        return false
    }
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
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

fun printFormattedTavernMenu(menuList: List<String>) {
    println()
    println("*** Welcome to Taernyl's Folly ***")
    println()

    val menuGroups = readGroupsFromMenuList(menuList)
    val mutableMenuList = menuList.toMutableList()

    while (!menuGroups.isEmpty()) {
        val group = menuGroups.first()
        println("${formatGroupElement(group)}")
        mutableMenuList.forEach {
            val (type, name, price) = it.split(',')
            if (type == group) {
                val dots = menuDotsPerName(name.length, price.length)
                println("${capitalizeMenuItem(name)}$dots$price")
                //mutableMenuList.removeAt(it.in)
            }
        }
        menuGroups.remove(group)
    }
}

fun menuDotsPerName(nameLenght: Int, priceLength: Int, maxLength: Int = 33): String {
    val max = maxLength - nameLenght - priceLength
    val sb = StringBuffer().append("")
    (0..max).forEach {
      sb.append('.')
    }
    return sb.toString()
}

fun capitalizeMenuItem(item: String): String {
    val sb = StringBuffer()
    item.split(' ').forEach {
        if (it.length > 2) {
            sb.append(it.capitalize())
        } else {
            sb.append(it)
        }
        sb.append(' ')
    }
    sb.deleteCharAt(sb.length - 1)
    return sb.toString()
}

fun formatGroupElement(type: String, maxLength: Int = 33): String {
    val sb = StringBuffer()
    val length = maxLength / 2 - type.length / 2 - 2
    (0..length).forEach {
        sb.append(' ')
    }
    sb.append("~[$type]~")
    return sb.toString()
}

fun readGroupsFromMenuList(menuList: List<String>): MutableSet<String> {
    val groups = mutableSetOf<String>()
    menuList.forEach {
        var (group,_,_) = it.split(',')
        groups.add(group)
    }
    return groups
}
