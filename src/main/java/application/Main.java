package application;
import model.*;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Json; 
import model.Rajapinta;

public class Main extends Application {

	private static Stage stage;
	
	public void start(Stage primaryStage) throws Exception {
		
		this.stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/model/LogIn.fxml"));
        
		primaryStage.setScene(new Scene(root, 900, 330));
        
		primaryStage.setTitle("BookBeast");
        //stage.setScene(stage);
		primaryStage.show();
    }

	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource("/model/Dashboard.fxml"));
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
		
		//Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		//Scene scene = new Scene(pane);
		//stage.getScene().setRoot(pane);
		//this.stage.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
