import random
import os


def partida():
    player1 = 0
    player2 = 0
    for i in range(2):
        turn = i + 1
        retry = True
        puntuacion = 0
        while retry:
            print("Jugador", turn, "Puntuación =", puntuacion)
            input("Pulsa enter")
            resultado = random.randint(1, 6)
            puntuacion += resultado
            print("Has sacado", resultado, "Tienes una puntuación de", puntuacion)
            if puntuacion == 21:
                print("Yassss queen has sacado 21")
                retry = False
            elif puntuacion < 21:
                valid = False
                while not valid:
                    respuesta = input("Quieres tirar otra vez? (y/n)")
                    if respuesta == "y":
                        valid = True
                    elif respuesta == "n":
                        valid = True
                        retry = False
                    else:
                        print("Introduce una respuesta válida")
            else:
                print("LOCOOOOOO te pasate nuuuuuuuuuuuuuu")
                retry = False
        if turn == 1:
            player1 = puntuacion
        elif turn == 2:
            player2 = puntuacion
        os.system("cls")

    winner = 0
    if player1 <= 21 and player2 <= 21:
        if player1 > player2:
            winner = 1
        elif player2 > player1:
            winner = 2
    elif player1 > 21 and player2 > 21:
        if player1 > player2:
            winner = 2
        elif player2 > player1:
            winner = 1
    elif player1 > 21:
        winner = 2
    elif player2 > 21:
        winner = 1

    if winner == 0:
        print("No habeis ganado ninguno pringaossssssss")
    else:
        print("Ha ganado el jugador", winner, "Felicidadesssssss")
    print("Jugador 1", player1, "Jugador 2", player2)

    return winner


def again():
    rejugar = False
    valid = False
    while not valid:
        respuesta = input("Quieres jugar otra vez? (y/n)")
        if respuesta == "y":
            valid = True
            rejugar = True
        elif respuesta == "n":
            valid = True
    return rejugar


def puntos(lista):
    jugador1 = 0
    jugador2 = 0
    empates = 0
    for resultado in lista:
        if resultado == 1:
            jugador1 += 1
        elif resultado == 2:
            jugador2 += 1
        else:
            empates += 1
    return jugador1, jugador2, empates


ganadas = []
ganadas.append(partida())
while again():
    ganadas.append(partida())

j1, j2, em = puntos(ganadas)

print("Jugador 1 ha ganado", j1, "veces")
print("Jugador 2 ha ganado", j2, "veces")
print("Se ha empatado", em, "veces")
