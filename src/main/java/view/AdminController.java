package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.LangPackage;

public class AdminController {

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
	private Button btnBorrowBook;

	@FXML
	void AllBooks(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("Kirjatiedot.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä ");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void AllUsers(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("Users.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä ");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	void BorrowBook(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("BooksToBorrow.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä ");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	void ReturnBook(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("ReturnBook.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä ");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	void userLogOut(ActionEvent event) throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("Login.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä ");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
