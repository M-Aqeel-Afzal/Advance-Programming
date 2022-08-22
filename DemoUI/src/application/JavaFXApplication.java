package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("PrimaryStage");
        
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 700, 200);
      
        Button btn = new Button("Open New Stage");
        btn.setOnAction(eve-> new NewStage());
            
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}