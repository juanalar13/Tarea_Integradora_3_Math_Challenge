package model;
import java.io.Serializable;

public class Jugador implements Serializable {
	
	String nombre;
	public int puntaje;
	
	Jugador izq;
	Jugador der;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		puntaje = 0;
	}
	
	public void incPuntaje(int cantidad) {
		puntaje += cantidad;
	}

}
