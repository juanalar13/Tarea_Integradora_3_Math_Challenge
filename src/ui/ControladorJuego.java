package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class ControladorJuego {
	
	String respuesta = "";
	
	@FXML
	ProgressBar BarProgressTiempo;
	
	@FXML
    Label LabelPuntaje;
	
	@FXML
    Label LabelPregunta;
	
	@FXML
    Label LabelA;
	
	@FXML
    Label LabelB;
	
	@FXML
    Label LabelC;
	
	@FXML
    Label LabelD;
    
    @FXML
    private Button BontonA;
    
    @FXML
    private Button BontonB;
    
    @FXML
    private Button BontonC;
    
    @FXML
    private Button BontonD;
    
    @FXML
    Label LabelTiempo;
    
    
    public Scene scene;
    
    
    void testRespuesta(String r) {
    	if (respuesta.equals(r)) {
    		Main.jugador.incPuntaje(10);
    	}else {
    		Main.jugador.incPuntaje(-10);
    	}
    	Main.pregunta.GenerarPregunta();
    	LabelPuntaje.setText("Puntaje = " + Main.jugador.puntaje);
		LabelPregunta.setText(Main.pregunta.pregunta);
		respuesta = Main.pregunta.respuesta;
		LabelA.setText(Main.pregunta.opcionA);
		LabelB.setText(Main.pregunta.opcionB);
		LabelC.setText(Main.pregunta.opcionC);
		LabelD.setText(Main.pregunta.opcionD);
		
    }
    
    
    @FXML
    public void OnButonA(ActionEvent event) {    	
    	testRespuesta("A");
    }
    
    @FXML
    public void OnButonB(ActionEvent event) {
    	testRespuesta("B");

    }
    
    @FXML
    public void OnButonC(ActionEvent event) {
    	testRespuesta("C");

    }
    
    @FXML
    public void OnButonD(ActionEvent event) {
    	testRespuesta("D");

    }
 
    
	

}
