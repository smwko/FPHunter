package model;

import control.MainSys;

public class Jugador extends Persona {

    // Puedes encontrarte con esto toUpperCase().strip(). Significa que esté en
    // Mayusculas y elimine saltos de línea y espacios.

    protected String nombre;
    protected int turno;
    protected int puntos = 0;
    protected int intentos = 0;
    public String palabra;
    public String pista;
    // Array Partes del cuerpo
    private final String[] partes = {"Cabeza", "Cuerpo", "Brazo izquierdo", "Brazo derecho", "Pierna Izquierda", "Pierna Derecha"};

    // Constructor
    public Jugador(String namePlayer, int turnPlayer) {
        // Para crear una instancia, el constructor nos solicita 2 datos. Nombre y turno
        /*Añadimos valor a los atributos del jugador*/
        this.nombre = namePlayer;
        this.turno = turnPlayer;
    }

    // Getters = Conseguir el atributo desde otro archivo
    // Setter = Modificar el atributo de esta instancia

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String namePlayer) {
        this.nombre = namePlayer;
    }

    @Override
    public int getTurno() {
        return turno;
    }

    @Override
    public void setTurno(int turnPlayer) {
        this.turno = turnPlayer;
        this.pedirPalabra(); // Si el jugador es el primero, pedimos por consola la plabara y la pista
    }

    @Override
    public int getPuntos() {
        return puntos;
    }

    @Override
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public int getIntentos() {
        return intentos;
    }

    @Override
    public void setIntentos(int intentos) {
        // Basándote en los intentos restantes, te mostrará que
        // partes del cuerpo te quedan en el juego. Si no te queda ninguno pierdes.
        this.intentos = intentos;
        System.out.println("Te queda/n "+(this.partes.length - this.intentos)+" intento/s: ");
        for (int i = this.intentos; i < this.partes.length; i++) {
            System.out.println("\t" + this.partes[i]);
        }
    }

    @Override
    public void pedirPalabra(){
        // Pedimos palabra al jugador que tenga el turno 1.
        if (this.getTurno() == 1){
            System.out.print("Introduce la palabra: ");
            this.palabra = MainSys.scan.next().toUpperCase().strip();
            System.out.print("Introduce una pista: ");
            this.pista = MainSys.scan.next().strip();
        }
        else {
            // El jugador con turno 2, le desasignamos la palabra que tenía.
            this.palabra = "";
            this.pista = "";
        }
    }

    @Override
    public String toString() {
        // Mostrar los atributos de la instancia.
        return "Partida{\n" +
                "Jugador "+ this.nombre +" -> Puntos:" + this.getPuntos() +
                "\n}\n";
    }
}
