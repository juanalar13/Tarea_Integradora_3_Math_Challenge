package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Jugador;
import model.Jugadores;
import model.Pregunta;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	ControladorInicio controllerinicio;
	
	public static Jugador jugador;
	public static Pregunta pregunta;
	
	public static Jugadores jugadores;
	
	
	public Main() {
		controllerinicio = new ControladorInicio();
	}	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("inicio.fxml"));
		fxmll.setController(controllerinicio);
		Parent root = fxmll.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Math Challenge");
		primaryStage.show();	
		
	}
	
	public static void main(String[] args) {
		
		
		jugador = new Jugador("aaaa", 0);
		pregunta = new Pregunta();		
		
		/*
		 * Guardado Inicial
		 * 
		 * 
		jugadores = new Jugadores();
		
		Jugador j1 = new Jugador("delta", 30);
		Jugador j2 = new Jugador("beta", 10);
		Jugador j3 = new Jugador("alfa", 40);
		Jugador j4 = new Jugador("gamma", 20);
		
		jugadores.insertar(j1);
		jugadores.insertar(j2);
		jugadores.insertar(j3);
		jugadores.insertar(j4);
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("data/jugadores.bytecode");
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);		     
		    objectOutputStream.writeObject(jugadores);
		    objectOutputStream.close();
		}catch(Exception e) {
			
		}
		*/
		
		
		jugadores = null;
		
		
		// Cargando el arbol de jugadores
		try {
			FileInputStream fileInputStream = new FileInputStream("data/jugadores.bytecode");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);            
            jugadores = (Jugadores) objectInputStream.readObject();            
            objectInputStream.close();
		}catch(Exception e) {
			
		}
		
		
		
		System.out.println(jugadores.StringTop5());
		
		
		
		launch(args);
	}
}
