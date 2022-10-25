/**
 * Juega varias partidas del juego del 21 y dicta un ganador entre 2 jugadores
 */
fun main() {
    val puntosRonda = crearArrayPuntos()
    for (i in puntosRonda.indices) {
        puntosRonda[i] = partida()
        // recuento(puntosRonda)
        println("Ha ganado el jugador ${puntosRonda[i]}")
    }
    println("${puntosRonda.contentToString()}")
    finalChampion(puntosRonda)
}


/**
 * Realiza una partida
 * @return winner
 */
fun partida(): Int {
    var player1 = 0
    var player2 = 0
    for (i in 1..2) {
        val puntuacion = turno(i)
        /*
        if (i == 1) {
            player1 = puntuacion
        } else if (i == 2) {
            player2 = puntuacion
        }
         */
        when (i) {
            1 -> player1 = puntuacion
            2 -> player2 = puntuacion
        }
    }
    return winner(player1, player2)
}

/**
 * Crea el array para almacenar los resultados de las partidas según el número de parti
 * @return Array de puntuación
 */
fun crearArrayPuntos(): IntArray {
    println("Cuantas partidas quieres jugar?")
    var numberofgames: Int = 0
    do {
        numberofgames = readln().toInt()
        if (numberofgames <= 0) {
            println("Número no válido")
        }
    } while (numberofgames <= 0)
    var arrayPuntos = IntArray(numberofgames) { 0 }
    return arrayPuntos
}

/**
 * Realiza un turno del juego
 * @param turn
 * @return puntuacion
 */
fun turno(turn: Int): Int {
    var puntuacion = 0
    var retry = true
    do {
        println("Turno jugador $turn")
        print("Pulsa enter")
        readln()
        val result = (1..6).random()
        println("Has sacado: $result")
        puntuacion += result
        if (puntuacion == 21) {
            println("Yasss queen has sacado un 21!!!")
            retry = false
        } else if (puntuacion < 21) {
            println("Jugador $turn, puntuacion $puntuacion")
            retry = yesNo("¿Quieres tirar otra vez? (y/n)")

        } else {
            println("Te pasaste NUUUUUUUUUUUUUUUUUUUUUUUUUU")
            retry = false
        }
    } while (retry)
    for (i in 1..20) {
        println(" ")
    }
    return puntuacion
}

/**
 * Devuelve verdadero o falso en una pregunta de si o no
 * @param message hace la pregunta al usuario
 * @return true or false
 */
fun yesNo(message: String): Boolean {
    var answer: String
    do {
        print(message)
        answer = readln()
        if (answer != "y" && answer != "n") {
            println("Introduce una respuesta válida")
        }
    } while (answer != "y" && answer != "n")
    when (answer) {
        "y" -> return true
        "n" -> return false
        // Caso por defecto
        else -> return true
    }
}

/**
 * Devuelve un valor entero correspondiente al jugador ganador
 * @param player1
 * @param player2
 * @return Int
 */
fun winner(player1: Int, player2: Int): Int {
    if (player1 <= 21 && player2 <= 21) {
        if (player1 < player2) {
            return 2
        } else if (player2 < player1) {
            return 1
        } else {
            return 0
        }
    } else if (player1 > 21 && player2 > 21) {
        if (player1 < player2) {
            return 1
        } else if (player2 < player1) {
            return 2
        } else {
            return 0
        }
    } else if (player1 > 21 && player2 <= 21) {
        return 2
    } else if (player2 > 21 && player1 <= 21) {
        return 1
    } else {
        println("No ha ganado nadie :(")
    }
    println("Jugador 1 $player1, jugador 2 $player2")
    return 0
}

/**
 * Calcula el ganador del juego en total
 * @param puntosRonda
 */
fun finalChampion(puntosRonda: IntArray) {
    var draws = 0
    var winsPlayer1 = 0
    var winsPlayer2 = 0
    for (i in puntosRonda) {
        if (i == 1) {
            winsPlayer1++
        } else if (i == 2) {
            winsPlayer2++
        } else {
            draws++
        }
    }
    comparator(draws, winsPlayer1, winsPlayer2)
}

/**
 * Decide cual es el ganador basado en las partidas ganadas
 * @param draws
 * @param winsPlayer1
 * @param winsPlayer2
 */
fun comparator(draws: Int, winsPlayer1: Int, winsPlayer2: Int) {
    if (winsPlayer1 > winsPlayer2) {
        println("Ha ganado el juego el jugador 1")
    } else if (winsPlayer2 > winsPlayer1) {
        println("Ha ganado el juego el jugador 2")
    } else {
        println("Nadie ha ganado el juego :(")
    }
}

/*fun comparator2(p1: Int, p2: Int, draws: Int): Int {
    if (p1 > p2) {
        println("Ha ganado el jugador 1")
    } else if (p2 > p1) {
        println("Ha ganado el jugador 2")
    }
}
*/

/*
fun recuento(arrayPuntos: IntArray) {
    var p1 = 0
    var p2 = 0
    var draws = 0
    for (i in arrayPuntos) {
        when (i) {
            1 -> p1++
            2 -> p2++
            0 -> draws++
        }
    }
    println("El jugador 1 lleva $p1 partidas ganadas")
    println("El jugador 2 lleva $p2 partidas ganadas")
    println("Ha habido $draws empates")
}
 */

/*
/**
 * Versión optimizada de winner
 * @param player1 Puntuación del jugador 1
 * @param player2 Puntuación del jugador 2
 * @return Int correspondiente al jugador ganador (1, 2, o 0 en caso de empate)
 */
fun winnerShort(player1: Int, player2: Int): Int {
    return when {
        player1 <= 21 && player2 <= 21 -> {
            if (player1 > player2) 1 else if (player1 < player2) 2 else 0
        }

        player1 > 21 -> 2
        player2 > 21 -> 1
        else -> 0
    }
}
*/

/*
/**
 * Añade un punto al ganador de el turno
 * @param winner
 * @param arrayPuntos
 * @return arrayPuntos con el ganador anotado
 */
fun puntos(winner: Int, arrayPuntos: IntArray): IntArray {
    for (i in arrayPuntos) {
        arrayPuntos[i] = winner
    }
    return arrayPuntos
}

 */