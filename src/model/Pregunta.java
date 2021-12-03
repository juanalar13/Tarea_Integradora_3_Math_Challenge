package model;
import java.util.Random;
import java.util.*;

public class Pregunta {
	
	public String pregunta;
	public String respuesta;
	public String opcionA;
	public String opcionB;
	public String opcionC;
	public String opcionD;
	public Random random;
	
	Vector<Integer> vector = new Vector<Integer>(20);
	
	
	public Pregunta() {
		random = new Random();
		for (int i = -10; i <= 10; i++) {
			if (i != 0) {
				vector.add(i);
			}			
		}         		
	}
	
	public void GenerarPregunta() {
		int a = random.nextInt(100);
		int b = random.nextInt(100);
		String o = "+";
		int r = 0;
		switch(random.nextInt(4)){
		    case 0: 
				r = a+b;
			    o = "+";
			    break;
		    case 1:
				r = a-b;
		    	o = "-";
		    	break;
		    case 2:
		    	r = a*b;
		    	o = "*";
		    	break;
		    case 3:
		    	r = a/b;
		    	o = "/";
		    	break;			
		}
		
		pregunta = "¿Cuanto es " + a + o + b + "?";
		
		Collections.shuffle(vector);
		
		switch(random.nextInt(4)){
		    case 0: 
		    	respuesta = "A";
		    	opcionA = "" + (r);
		    	opcionB = "" + (r+vector.get(0));
		    	opcionC = "" + (r+vector.get(1));
		    	opcionD = "" + (r+vector.get(2));
		    	break;
		    case 1:
		    	respuesta = "B";
		    	opcionA = "" + (r+vector.get(0));
		    	opcionB = "" + (r);
		    	opcionC = "" + (r+vector.get(1));
		    	opcionD = "" + (r+vector.get(2));
		    	break;
		    case 2:
		    	respuesta = "C";
		    	opcionA = "" + (r+vector.get(0));
		    	opcionB = "" + (r+vector.get(1));
		    	opcionC = "" + (r);
		    	opcionD = "" + (r+vector.get(2));
		    	break;
		    case 3:
		    	respuesta = "D";
		    	opcionA = "" + (r+vector.get(0));
		    	opcionB = "" + (r+vector.get(1));
		    	opcionC = "" + (r+vector.get(2));
		    	opcionD = "" + (r);
		    	break;		   
		}
		
		
		
		
		
		
	}

}
