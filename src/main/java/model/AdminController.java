package model;

import java.io.IOException;

import application.Controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminController extends Main{

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

	@FXML
    private Button btnBook;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnReturnBook;
    @FXML
    private Button btnUsers;
    @FXML
    void AllBooks(ActionEvent event) {
 
    	Stage primaryStage = new Stage();
        Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Kirjatiedot.fxml"));

	        Scene scene = new Scene(root);
	        primaryStage.initModality(Modality.APPLICATION_MODAL);
	        primaryStage.setOpacity(1);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
   
    @FXML
    void AllUsers(ActionEvent event) {

    }

    @FXML
    void ReturnBook(ActionEvent event) {

    }

    @FXML
    void userLogOut(ActionEvent event) throws IOException {
 
    	btnLogout.getScene().getWindow().hide();
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root, 600, 400);
		
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BookBeast");
		primaryStage.show();
    }
    
    
}
