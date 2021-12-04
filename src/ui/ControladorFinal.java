package ui;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Jugadores;

public class ControladorFinal {
	
	   
   
    
    @FXML
    Label LabelTop;
    
    
    @FXML
    TextField TextBuscar;
    
    
    @FXML
    private Button BotonBuscar;
    
    @FXML
    Label LabelResultado;
    
    @FXML
    private Button BotonEliminar;
    
    @FXML
    private Button BotonReiniciar;
    
    
    public Stage stagefinal;
    
    
    
    
    @FXML
    public void OnBotonBuscar(ActionEvent event) {    	
    	System.out.println("buscar");
    	Main.jugador = Main.jugadores.buscar(TextBuscar.getText());
    	LabelResultado.setText(Main.jugadores.BuscarPosicion(TextBuscar.getText()));
    }
    
    @FXML
    public void OnBotonEliminar(ActionEvent event) {     	
    	System.out.println("eliminar");   	
    	Main.jugadores.eliminar(Main.jugador);
    	Main.GuardarJugadores();
    	LabelTop.setText(Main.jugadores.top5());   	
    	
    }
    
    
    @FXML
    public void OnBotonReiniciar(ActionEvent event) {    	
    	System.out.println("reiniciar");
    	try {
    		
    		Main.controllerinicio = new ControladorInicio();
    		Main.jugadores = null;
    		
    		// Cargando arbol de jugadores (persistencia)
    		FileInputStream fileInputStream = new FileInputStream("data/jugadores.bytecode");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);            
            Main.jugadores = (Jugadores) objectInputStream.readObject();            
            objectInputStream.close();
    		
            // Creando y abriendo la ventana de inicio
    		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("inicio.fxml"));			
    		fxmll.setController(Main.controllerinicio);			
    		Parent root = fxmll.load();    		
    		Stage stage = new Stage();            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Math Challenge");
            stage.show();
            
            // cerrando la ventana final
            stagefinal.close();
    		
    	}catch(Exception e) {
    		
    	}
    	
    }

}
