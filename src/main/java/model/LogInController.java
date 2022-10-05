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

import application.Main;



public class LogInController {

	public LogInController() {
		
	}
	
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
		Main main = new Main();
		if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
			error.setText("Success!");
			
			main.changeScene("Dashboard.fxml");
			
		}else if(username.getText().isEmpty() && password.getText().isEmpty()) {
			error.setText("Please enter your data.");
		}else {
			error.setText("Wrong username or password");
		}
	}
}
