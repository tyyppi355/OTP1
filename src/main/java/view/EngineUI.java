package view;

import java.io.IOException;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EngineUI extends Application implements IengineUI {
	
	private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
		
    	
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/model/AdminManagement.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/LogIn.fxml"));
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
