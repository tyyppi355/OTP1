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

public class LogInController extends Main {

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
				changeScene("Dashboard.fxml");

			} else if (username.getText().isEmpty() && password.getText().isEmpty()) {
				error.setText("Please enter your data.");
			} else {
				error.setText("Wrong username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
