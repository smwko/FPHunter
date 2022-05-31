package control;

/*=================================
* JUEGO DEL AHORCADO POR CONSOLA ||
* =================================

Para comenzar con el juego, se pedirán los nombres de los dos jugadores. El primer jugador deberá introducir la palabra a descifrar,
* y los demás intentarán adivinarla, y por ende el ganador dictará la siguiente palabra.
* Por otro lado se deberá introducir una pista, para hacer de este más fácil. Por ejemplo, si la palabra es "Madrid" podríamos poner de pista
* "Ciudad"
* Cada jugador puede tiene 6 intentos para poder adivinar la palabra, y se mostrarán las "vidas" que le quedan.
* Si varios jugadores dicen una misma palabra solo se contará como vida restante la primera vez que se introduce.
* Para finalizar se muestra la cantidad de palabras acertadas, a la tercera el juego se da por finalizado y se muestra el ganador.
 */

import model.Jugador;
import model.Partida;
import java.util.Scanner;

public class MainSys {

    public static Scanner scan = new Scanner(System.in); // Iniciamos entrada por teclado

    public static void main(String[] args) {

        // Función Nombre esta abajo del archivo. Pide que se introduzca el nombre por consola
        Jugador p1 = new Jugador(Nombre("primer"), 1); // Declaramos jugador 1 (Clase Jugador)
        p1.pedirPalabra(); // Dice la palabra que tiene que adivinar el J2
        Jugador p2 = new Jugador(Nombre("segundo"), 2); // Declaramos jugador 2 (Clase Jugador)

        boolean val = true;
        // Aquel jugador que tenga el turno Nº 1 es el que dice la palabra. El del turno 2 adivina
        while (val){
            if (p1.getPuntos() >= 3 || p2.getPuntos() >= 3){ // Si alguno de los 2 jugadores gana 3 veces termina el juego
                new Partida(p1, p2);
                val = false;
            }
            else{
                // Si el J1 tiene el turno 1, el que adivina es el J2
                if (p1.getTurno() == 1){
                    new Partida(p1, p2); // Iniciamos partida (Archivo Partida)
                }
                // En caso contrario, el que adivina es el J1
                else{
                    new Partida(p2, p1); // Iniciamos partida (Archivo Partida)
                }
            }
        }
    }

    // Pide al jugador que introduzca su nombre por consola
    public static String Nombre(String d){
        System.out.print("Introduce el nombre del " + d + " jugador: ");
        return scan.next(); // Retornamos el nombre para construir la instancia del jugador en cuestión
    }

}
