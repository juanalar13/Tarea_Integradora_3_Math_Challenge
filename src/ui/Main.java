package ui;

	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Jugador;
import model.Pregunta;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	SampleController controller;
	
	public static Jugador jugador;
	public static Pregunta pregunta;
	
	
	public Main() {
		controller = new SampleController();
	}	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("inicio.fxml"));
		fxmll.setController(controller);
		Parent root = fxmll.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Math Challenge");
		primaryStage.show();
		
		
		jugador = new Jugador("aaaa");
		pregunta = new Pregunta();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
