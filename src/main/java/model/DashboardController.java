package model;


import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import application.Main;



public class DashboardController {

	public DashboardController() {
		
	}
	
	
	@FXML
	private Button buttonLogOut;
	@FXML
	private TextField search;
	@FXML
	private Button searchButton;
	@FXML
	private Button lainaaButton;
	@FXML
	private Button lainassaButton;
	@FXML
	private Button palautusButton;
	@FXML
	private Button palauttaaButtonBottom;
	@FXML
	private Button lainaaButtonBottom;
	
	
	//Search kenta metodi TODO
	//public void searchBook(ActionEvent event) throws IOException{
	//}
	
	//Logout
	public void userLogOut(ActionEvent event) throws IOException{
		buttonLogOut.getScene().getWindow().hide();
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root, 900, 330);
		
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BookBeast");
		primaryStage.show();

	}
}
