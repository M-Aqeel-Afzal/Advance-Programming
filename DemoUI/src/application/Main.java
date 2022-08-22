package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	//Inside the main() method, we can launch our application using Application.launch().
	public static void main(String[] args) {
		launch(args);
		}
	
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("My First JavaFX GUI"); //add some nice caption to our window.
		Button btnHello= new Button("Hello"); //Create GUI Elements

		StackPane layout= new StackPane(); 
		layout.getChildren().add(btnHello);  
		
		Scene scene1= new Scene(layout, 300, 250); //create a scene
		primaryStage.setScene(scene1);
		        
		primaryStage.show(); // It is hidden by default. 
		}      
		}



