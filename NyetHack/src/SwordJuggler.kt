fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
        juggleSwords(swordsJuggling)
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: UnskilledSwordJugglerException) { // e: Exception
        println(e)
    }

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling) { "Player cannot juggle swords" }
    requireNotNull(swordsJuggling) { "Require not null!" }
    error { " Aca hubo algun error " }
}

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3) { "Juggle at least 3 swords to be exciting." }
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")