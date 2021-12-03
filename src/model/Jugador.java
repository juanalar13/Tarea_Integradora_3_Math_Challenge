package model;
import java.io.Serializable;


public class Jugador implements Serializable, Comparable<Jugador> {
	
	
	private static final long serialVersionUID = -5440237478856765514L;
	
	public String nombre;
	public int puntaje;
	
	Jugador izq;
	Jugador der;
	
	public Jugador(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	
	public void incPuntaje(int cantidad) {
		puntaje += cantidad;
	}
	
	@Override
    public int compareTo(Jugador o) {
        return -this.puntaje + o.puntaje;
    }

}
