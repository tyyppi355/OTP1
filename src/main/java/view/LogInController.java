package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import application.Main;
import controller.Controller;
import controller.V2M;

public class LogInController extends Main {

	private String inputNullError = "Please enter your data.";
	private String inputWrongError = "Wrong username or password";

	V2M postController = new Controller();

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

		try {

			if (postController.tarkistaLogin(username.getText(), password.getText())) {

				error.setText("Success!");

				changeScene();

			} else if (username.getText().isEmpty() && password.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, inputNullError);
			} else if (username.getText().isEmpty() || password.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, inputNullError);
			} else {

				JOptionPane.showMessageDialog(null, inputWrongError);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void changeScene() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("AdminManagement.fxml"));
		Scene scene = new Scene(fxmlLoader.load()); // scene

		Stage stage = EngineUI.getPrimaryStage();
		stage.hide();
		stage.setTitle("Kirjaston lainausjärjestelmä!");
		stage.setScene(scene);
		stage.show();
	}

	protected void onStartButtonClick() throws IOException {
		DashboardController.changeScene();
	}
}
