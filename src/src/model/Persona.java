package model;

// Esta clase la usamos para declarar variables que usaremos en otras clases
// Es como un índice
public abstract class Persona{

    public abstract String getNombre();

    public abstract void setNombre(String namePlayer);

    public abstract int getTurno();

    public abstract void setTurno(int turnPlayer);

    public abstract int getPuntos();

    public abstract void setPuntos(int puntos);

    public abstract int getIntentos();

    public abstract void setIntentos(int intentos);

    public abstract void pedirPalabra();

    public abstract String toString();

}
