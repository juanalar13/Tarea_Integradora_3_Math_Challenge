package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pregunta;

public class SampleController {	
	
	
	@FXML
    private Button ButtonJugar;
	
	
    
    @FXML
    private TextField TextUsuario;
    
    ControladorJuego controladorjuego;
    
    public SampleController() {
    	controladorjuego = new ControladorJuego();
    }
    
    @FXML
    public void OnButtonJugar(ActionEvent event) {
		try {				
			
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("juego.fxml"));
			
			fxmll.setController(controladorjuego);		
			
			Parent root = fxmll.load();
			
			//System.out.print("vea");
			
			
			
			Pregunta p = new Pregunta();
			p.GenerarPregunta();
			
			controladorjuego.LabelPuntaje.setText("Puntaje = 0");
			controladorjuego.LabelPregunta.setText(p.pregunta);
			controladorjuego.LabelA.setText(p.opcionA);
			controladorjuego.LabelB.setText(p.opcionB);
			controladorjuego.LabelC.setText(p.opcionC);
			controladorjuego.LabelD.setText(p.opcionD);
			controladorjuego.respuesta = p.respuesta;			

			
			
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Math Challenge");
            stage.show(); 
            
            
            Thread taskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                  double progress = 0;
                  for(int i=0; i<10; i++){

                    try {
                      Thread.sleep(1000);
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }

                    progress += 0.1;
                    final double reportedProgress = progress;

                    Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                    	  controladorjuego.BarProgressTiempo.setProgress(reportedProgress);
                      }
                    });
                  }
                }
              });

              taskThread.start();
            
            
            
            
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
			
			
			TextUsuario.setText("Carlos");	
			
		}catch (Exception e) {
		    			
		}
    }
	
}
