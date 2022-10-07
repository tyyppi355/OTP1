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

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
		

    	//FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/model/Dashboard.fxml"));
    	FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/model/Asiakastiedot.fxml"));
        
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/model/Kirjatiedot.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/model/LogIn.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/model/LogIn.fxml"));
        
        Scene scene = new Scene(fxmlLoader.load()); // scene

        primaryStage = stage; // current stage(primaryStage) is stage
        stage.setTitle("Book Beast!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}