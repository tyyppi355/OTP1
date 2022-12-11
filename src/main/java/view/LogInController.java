package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.LangPackage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import application.Main;
import controller.Controller;
import controller.V2M;

public class LogInController extends Main {

	private String inputNullError = "Please enter your data.";
	private String inputWrongError = "Wrong username or password";

	V2M postController = new Controller();
	LangPackage lang;

	public LogInController() {

	}

	@FXML
	private Button button;
	@FXML
	private Button enlag;
	@FXML
	private Label error;
	@FXML
	private Button finlang;
	@FXML
	private Label userText;
	@FXML
	private Label passText;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	@FXML
	void enlag(ActionEvent event) {
		LangPackage.getrBundle_NZ();
		changeText();
	}

	@FXML
	void finlang(ActionEvent event) {
		LangPackage.getrBundle_FI();
		changeText();
	}

	void changeText() {
		userText.setText(LangPackage.rBundle.getString("Username"));
		passText.setText(LangPackage.rBundle.getString("Password"));
		password.setPromptText(LangPackage.rBundle.getString("Password"));
		username.setPromptText(LangPackage.rBundle.getString("Username"));
	}

	@FXML
	public void initialize() {
	}

	public void userLogin(ActionEvent event) throws IOException {
		checkLogin();
	}

	public void checkLogin() throws IOException {

		try {

			if (postController.tarkistaLogin(username.getText(), password.getText(), 1)) {

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

		FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("AdminManagement.fxml"), LangPackage.rBundle);
		Scene scene = new Scene(fxmlLoader.load()); // scene

		Stage stage = EngineUI.getPrimaryStage();
		stage.hide();
		stage.setTitle(LangPackage.rBundle.getString("Title"));
		stage.setScene(scene);
		stage.show();
	}

	protected void onStartButtonClick() throws IOException {
		DashboardController.changeScene();
	}
}
