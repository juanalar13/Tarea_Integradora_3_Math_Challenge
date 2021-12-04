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
    private TextField TextJugador;
    
    ControladorJuego controladorjuego;
    ControladorFinal controladorfinal;
    
    public ControladorInicio() {
    	controladorjuego = new ControladorJuego();
    	controladorfinal = new ControladorFinal(); 
    }
    
    
    
    public void AbrirVentanaFinal() {
    	try {
    		
    		Main.GuardarJugadores();    		
    		
    		// creando y abriendo la ventana Final
    		 FXMLLoader fxml2 = new FXMLLoader(getClass().getResource("final.fxml"));
    		 fxml2.setController(controladorfinal);    		
    		 Parent root = fxml2.load();    		
    		 Stage stage2 = new Stage();            
    		 Scene scene2 = new Scene(root);
    		 stage2.setScene(scene2);
    		 stage2.setTitle("Math Challenge");
    		 stage2.show();
    		 
    		 controladorfinal.stagefinal = stage2; // asignando el Stage, utilidad: para cerrar la ventana Final
    		 
    		 controladorfinal.LabelTop.setText(Main.jugadores.top5());
    		 controladorfinal.LabelResultado.setText(Main.jugadores.BuscarPosicion(Main.jugador.nombre));
    		 
    		 
    		 
    	}catch (Exception e) {

    	} 
    }
    
    
    
    
    
    @FXML
    public void OnButtonJugar(ActionEvent event) {
		try {				
			
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("juego.fxml"));			
			fxmll.setController(controladorjuego);			
			Parent root = fxmll.load();	
			
			
			Pregunta p = new Pregunta();
			p.GenerarPregunta();
			
			
			controladorjuego.LabelPuntaje.setText("Puntaje = 0");
			controladorjuego.LabelPregunta.setText(p.pregunta);
			controladorjuego.LabelA.setText(p.opcionA);
			controladorjuego.LabelB.setText(p.opcionB);
			controladorjuego.LabelC.setText(p.opcionC);
			controladorjuego.LabelD.setText(p.opcionD);
			controladorjuego.respuesta = p.respuesta;	
			
			
            Stage stageJuego = new Stage();            
            Scene scene = new Scene(root);
            stageJuego.setScene(scene);
            stageJuego.setTitle("Math Challenge");
            stageJuego.show();            
            
            
            Thread taskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                  double progress = 1.0;
                  for(int i=0; i<100; i++){

                    try {
                      Thread.sleep(100);
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }                   
                    
                    progress = (i != 99)? progress - 0.01: 0;
                    
                    final double reportedProgress = progress;

                    Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                    	  controladorjuego.BarProgressTiempo.setProgress(reportedProgress);
                    	  controladorjuego.LabelTiempo.setText("Tiempo restante = " + String.format("%.1f", reportedProgress * 10) + " seg");
                    	  
                    	  if(reportedProgress == 0) {
                			  AbrirVentanaFinal();
                			  stageJuego.close();
                		  } 
                    	  
                      }
                    });
                  }     
                  
                  
                  
                }
              });

            taskThread.start();            
            //((Node)(event.getSource())).getScene().getWindow().hide(); // escondiendo la ventana
            
            // cerrando ventana de Inicio
            Stage stageInicio = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            stageInicio.close();
			
			Main.jugador = Main.jugadores.insertar(TextJugador.getText());
			controladorjuego.LabelJugador.setText("Jugador = " + Main.jugador.nombre);
			
		}catch (Exception e) {
		    			
		}
    }
	
}
