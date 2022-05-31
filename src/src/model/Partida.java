package model;

import control.MainSys;

public class Partida {

    Jugador p1;
    Jugador p2;

    public Partida(Jugador p1, Jugador p2) {
        // P1 Siempre será el que ha dicho la palabra
        // P2 el que adivnia
        this.p1 = p1;
        this.p2 = p2;
        if (p1.getPuntos() < 3 && p2.getPuntos() < 3){
            // Si ninguno supera los 3 puntos arranca el juego
            juego();
        }
        else{
            // Si alguno llega o supera los 3 puntos. Se detiene el juego y te dice quién ha ganado
            // Usamos el método de abajo con nombre ganador()
            System.out.println("El ganador de la partida ha sido: " + ganador());
        }
    }

    public void juego(){
        boolean val = true; // Iniciamos el boolean del bucle While
        // J2 El que adivina la palabra
        System.out.println("\nTe toca adivinar: " + p2.getNombre() + "\n");

        while (p2.getIntentos() < 6 && val){ // Si el J2 no supera los 6 intentos continúa jugando
            System.out.println("Adivina la palabra: ");
            // Usamos el scanner de la clase MainSys (la principal)
            String word = MainSys.scan.next().toUpperCase();
            if (word.equals(p1.palabra)){ // Si la palabra del J2 es igual a la introducida por J1
                this.p2.setPuntos(this.p2.getPuntos()+1); // Gana partida + 1 punto
                val = false; // Salimos del bucle
            }
            else{
                p2.setIntentos(p2.getIntentos()+1); // Te quedan menos intentos
            }
        }

        if (this.p1.getPuntos() < 3 && this.p2.getPuntos() < 3){
            // Si ninguno de los dos jugadores supera los 3 puntos
            System.out.println("\n" + this.p1.toString()); // Muestra nombre del J1 y puntos
            System.out.println(this.p2.toString()); // Muestra nombre del J2 y puntos

            if (p2.getTurno() == 2){
                // si J2 tiene el turno 2, pasa a tener el 1
                // Pedimos por consola la palabra y la pista
                System.out.println("\nTe toca escribir la palabra jugador 2: " + p2.getNombre());
                p1.setTurno(2);
                p2.setTurno(1);
            }
            else{
                // J2 tiene el 1, pasa al 2
                // Pedimos por consola la palabra y la pista
                System.out.println("\nTe toca escribir la palabra jugador 1: " + p1.getNombre());
                p1.setTurno(1);
                p2.setTurno(2);
            }
        }
    }

    public String ganador(){
        // Comprobamos cual de los dos jugadores tiene o supera 3 puntos y devuelve su nombre
        String name;
        if (this.p1.getPuntos() == 3){
            name = p1.getNombre();
        }
        else{
            name = p2.getNombre();
        }
        return name;
    }

}
