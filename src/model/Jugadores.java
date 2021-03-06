
package model;

import java.io.Serializable;
import java.util.ArrayList;


// Clase para el Arbol de los Jugadores
public class Jugadores implements Serializable{	


	private static final long serialVersionUID = -6258461972369375109L;	
	
	public Jugador raiz;
	
	public Jugadores() {
		raiz = null;
	}
	
	public Jugador insertar(String nombre) {
		if(raiz == null) {
			raiz = new Jugador(nombre, 0);
			return raiz;
		}else {
			Jugador buscado = buscar(nombre);
			if (buscado != null) {
				buscado.puntaje = 0;
				return buscado;
			}else {
				Jugador u = new Jugador(nombre, 0);
				insertar(u, raiz);
				return u;
			}			
		}
	}
	
	
	public void insertar(Jugador g) {
		if(raiz == null) {
			raiz = g;
		}else {
			if (buscar(g.nombre) == null) {
				insertar(g, raiz);
			}			
		}
	}
	
	
	public void insertar(Jugador p, Jugador actual){
    	int c = p.nombre.compareTo(actual.nombre);
		if (c < 0) {
			if(actual.izq == null) {
				actual.izq = p;
			}else {
				insertar(p, actual.izq);
			}
		}else {
			if(actual.der == null) {
				actual.der = p;
			}else {
				insertar(p, actual.der);
			}			
		}
	}
	
	
	
	public Jugador buscar(String s, Jugador u) {
		int c = s.compareTo(u.nombre);
		if(c == 0) {
			return u;
		}else {
			if (c < 0) {
				if (u.izq != null) {
					return buscar(s, u.izq);
				}else {
					return null;
				}
			}else {
				if (u.der != null) {
					return buscar(s, u.der);
				}
				return null;
			}
		}
	}
	
	
	public Jugador buscar(String s) {
		return buscar(s, raiz);
	}
	
	
	public void inorden(Jugador u) {
		if(u != null) {
			inorden(u.izq);
			System.out.println(u.nombre);
			inorden(u.der);			
		}		
	}
	
	public void inorden() {
		inorden(raiz);		
	}
	
	
	public void ListarInorden(ArrayList<Jugador> list, Jugador g){
		if(g != null) {
			ListarInorden(list, g.izq);
			list.add(g);
			ListarInorden(list, g.der);	
		}
	}
	
	public void ListarInorden(ArrayList<Jugador> list){
		ListarInorden(list, raiz);
	}
	
	public String top5() {
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		ListarInorden(list);
		list.sort(null);
		int n = list.size() < 5? list.size(): 5;
		String s = "TOP 5\n";
		for(int i=0; i<n; i++) {
			s += list.get(i).nombre + "(" + list.get(i).puntaje + ")\n";
		}
		s += "\n";
		return s;		
	}
	
	
	public String BuscarPosicion(String s) {
		Jugador buscado = buscar(s);
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		ListarInorden(list);
		list.sort(null);
		try {
			return "Jugador: " + s + " - Puntaje: " + buscado.puntaje + " - Posicion: " +  (list.indexOf(buscado) + 1);
		}catch (Exception e) {
			return "No se encontro el jugador";
		}				
	}
	
	
	
	public void eliminar(Jugador g) {
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		ListarInorden(list);
		list.remove(g);
		raiz = null;
		for (int i = 0; i<list.size(); i++) {
			Jugador j = new Jugador(list.get(i).nombre, list.get(i).puntaje);
			insertar(j);
		}		
	}
	
	
	
	
	
	
	
	
	

}