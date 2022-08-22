package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

class NewStage {
    
    NewStage()
    {
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");
                
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);
        
        root.getChildren().add(new Button("New Stage"));
        subStage.setScene(scene);
        subStage.show();
    }
}

