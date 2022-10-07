package model;

import javafx.fxml.FXML;  
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import javax.swing.JOptionPane;

import application.Controller;
import application.Main;



public class LogInController{

	public LogInController() {
		
	}
	private static Stage stage;
	@FXML
	private Button button;
	@FXML
	private Label error;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	
	public void userLogin(ActionEvent event) throws IOException{
		checkLogin();
	}
	
	public void checkLogin() throws IOException {
		
		if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
			error.setText("Success!");
			System.out.println("Success!");
			
			Stage primaryStage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("AdminManagement.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
		}else if(username.getText().isEmpty() && password.getText().isEmpty()) {
			//error.setText("Please enter your data.");
			String message = "Please enter your data.";
			JOptionPane.showMessageDialog(null, message);
		}else if(username.getText().isEmpty() || password.getText().isEmpty()) {
			//error.setText("Please enter your data.");
			String message = "Please enter your data.";
			JOptionPane.showMessageDialog(null, message);
		}else {
			//error.setText("Wrong username or password");
			String message = "Wrong username or password";
			JOptionPane.showMessageDialog(null, message);
			
			//JOptionPane.showMessageDialog(this, "Wrong username or password");
			
		}
	}
	protected void onStartButtonClick() throws IOException {
		DashboardController.changeScene();
    }
}
