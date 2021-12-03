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

public class ControladorInicio {	
	
	
	@FXML
    private Button ButtonJugar;
	
	
    
    @FXML
    private TextField TextUsuario;
    
    ControladorJuego controladorjuego;
    ControladorFinal controladorfinal;
    
    public ControladorInicio() {
    	controladorjuego = new ControladorJuego();
    	controladorfinal = new ControladorFinal(); 
    }
    
    
    
    public void AbrirVentanaFinal() {
    	try {
    		
    		 System.out.print("vea");
    		 FXMLLoader fxml2 = new FXMLLoader(getClass().getResource("final.fxml"));
    		 fxml2.setController(controladorfinal);    		
    		 Parent root = fxml2.load();    		
    		 Stage stage2 = new Stage();            
    		 Scene scene2 = new Scene(root);
    		 stage2.setScene(scene2);
    		 stage2.setTitle("Math Challenge");
    		 stage2.show();      
    	}catch (Exception e) {

    	} 
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
            
            //controladorjuego.scene = scene;
            
            
            Thread taskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                  double progress = 1.0;
                  for(int i=0; i<10; i++){

                    try {
                      Thread.sleep(100);
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }                   
                    
                    progress = (i != 9)? progress - 0.01: 0;
                    
                    final double reportedProgress = progress;

                    Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                    	  controladorjuego.BarProgressTiempo.setProgress(reportedProgress);
                    	  controladorjuego.LabelTiempo.setText("Tiempo restante = " + String.format("%.1f", reportedProgress * 1.0));
                    	  
                    	  if(reportedProgress == 0) {
                			  AbrirVentanaFinal();
                			  stage.close();//scene.getWindow().hide();
                		  } 
                    	  
                      }
                    });
                  }
                  
                 
                  
                  
                  
                }
              });

              taskThread.start();          
            
            
            //((Node)(event.getSource())).getScene().getWindow().hide(); // escondiendo la ventana
              
              Stage stage2 = (Stage) ((Node)(event.getSource())).getScene().getWindow();
              stage2.close();
			
			TextUsuario.setText("Carlos");	
			
		}catch (Exception e) {
		    			
		}
    }
	
}
