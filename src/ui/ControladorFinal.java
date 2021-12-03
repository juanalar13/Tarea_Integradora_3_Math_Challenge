package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorFinal {
	
	   
   
    
    @FXML
    private Label LabelTop;
    
    
    @FXML
    private TextField TextBuscar;
    
    
    @FXML
    private Button BotonBuscar;
    
    @FXML
    private Label LabelResultado;
    
    @FXML
    private Button BotonEliminar;
    
    @FXML
    private Button BotonReiniciar;
    
    
    
    
    @FXML
    public void OnBotonBuscar(ActionEvent event) {    	
    	System.out.print("buscar");
    }
    
    @FXML
    public void OnBotonEliminar(ActionEvent event) {    	
    	System.out.print("eliminar");
    }
    
    
    @FXML
    public void OnBotonReiniciar(ActionEvent event) {    	
    	System.out.print("reiniciar");
    }

}
