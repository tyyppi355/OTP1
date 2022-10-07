package model;

import javafx.fxml.FXML;   
import javafx.fxml.FXMLLoader; 

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


import application.Main;

public class LogInController extends Main {

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

	public void userLogin(ActionEvent event) throws IOException {
		checkLogin();
	}

	public void checkLogin() throws IOException {

		
		
		Tietokanta tietokanta = new Tietokanta();
		
		try {
			//tietokanta.get_admin(); // no need for this
			//System.out.println("in the Login: " + tietokanta.admin.getKäyttäjätunnu());
			System.out.println("in the Login arry user name: " + tietokanta.get_admin().get(0)); // this work
			System.out.println("in the Login arry password: " + tietokanta.get_admin().get(1)); // this work
			
			// tietokanta.admin.getKäyttäjätunnu() // and this also work
			// tietokanta.admin.getSalasana() // and this also work
			
			if (username.getText().toString().equals(tietokanta.get_admin().get(0)) && password.getText().toString().equals(tietokanta.get_admin().get(1))) {
					
				error.setText("Success!");
				Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("AdminManagement.fxml"));
		        Scene scene = new Scene(root);
		        primaryStage.setScene(scene);
		        primaryStage.show();

			} else if(username.getText().isEmpty() && password.getText().isEmpty()) {
				//error.setText("Please enter your data.");
				String message1 = "Please enter your data.";
				JOptionPane.showMessageDialog(null, message1);
			} else if(username.getText().isEmpty() || password.getText().isEmpty()) {
				//error.setText("Please enter your data.");
				String message2 = "Please enter your data.";
				JOptionPane.showMessageDialog(null, message2);
			}else {
				//error.setText("Wrong username or password");
				String message3 = "Wrong username or password";
				JOptionPane.showMessageDialog(null, message3);
							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	protected void onStartButtonClick() throws IOException {
		DashboardController.changeScene();
    }
}
