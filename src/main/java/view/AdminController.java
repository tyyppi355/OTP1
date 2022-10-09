package view;

import java.io.IOException;  

import application.Controller;
import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminController{

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

	@FXML	private Button btnBook;
    @FXML	private Button btnLogout;
    @FXML	private Button btnReturnBook;
    @FXML	private Button btnUsers;
    @FXML 	private Button btnBorrowBook;

    @FXML void AllBooks(ActionEvent event) {
 
    	Stage primaryStage = new Stage();
        Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Kirjatiedot.fxml"));

	        Scene scene = new Scene(root);
	        primaryStage.initModality(Modality.APPLICATION_MODAL);
	        primaryStage.initStyle(StageStyle.UNIFIED);
	        primaryStage.setOpacity(1);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
   
    @FXML void AllUsers(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("Users.fxml"));
	        Scene scene = new Scene(fxmlLoader.load()); // scene

	        Stage stage = EngineUI.getPrimaryStage();
	        stage.hide();
	        stage.setTitle("Kirjaston lainausjärjestelmä ");
	        stage.setScene(scene);
	        stage.show();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML void BorrowBook(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("BooksToBorrow.fxml"));
	        Scene scene = new Scene(fxmlLoader.load()); // scene

	        Stage stage = EngineUI.getPrimaryStage();
	        stage.hide();
	        stage.setTitle("Kirjaston lainausjärjestelmä ");
	        stage.setScene(scene);
	        stage.show();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML void ReturnBook(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("ReturnBook.fxml"));
	        Scene scene = new Scene(fxmlLoader.load()); // scene

	        Stage stage = EngineUI.getPrimaryStage();
	        stage.hide();
	        stage.setTitle("Kirjaston lainausjärjestelmä ");
	        stage.setScene(scene);
	        stage.show();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @FXML
    void userLogOut(ActionEvent event) throws IOException {
    	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("Login.fxml"));
	        Scene scene = new Scene(fxmlLoader.load()); // scene

	        Stage stage = EngineUI.getPrimaryStage();
	        stage.hide();
	        stage.setTitle("Kirjaston lainausjärjestelmä ");
	        stage.setScene(scene);
	        stage.show();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	
}
