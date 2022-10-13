package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.V2M;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Asiakas;
import model.Asiakastiedot;

public class CreateUser {

	V2M postcontroller = new Controller();

	@FXML
	private TextField luoEtunimi;
	@FXML
	private TextField luoKaupunki;
	@FXML
	private TextField luoOsoite;
	@FXML
	private TextField luoPNumero;
	@FXML
	private TextField luoPuheNumero;
	@FXML
	private TextField luoSPosti;
	@FXML
	private TextField luoSukunimi;

	@FXML
	private Button luoBtn;
	@FXML
	private Button peruuttaa;

	@FXML
	private void luoKayttajaa(ActionEvent event) throws IOException {
		String etunimi = luoEtunimi.getText();
		String sukunimi = luoSukunimi.getText();

		if (etunimi.isEmpty() || sukunimi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill the data!");
			return;
		}

		postcontroller.addAsiakas(new Asiakas(luoEtunimi.getText(), luoSukunimi.getText(), luoPuheNumero.getText(),
				new Asiakastiedot(luoKaupunki.getText(), luoSPosti.getText(), luoPNumero.getText(), luoOsoite.getText(),
						luoPuheNumero.getText())));

		JOptionPane.showMessageDialog(null, "New User is added!");

		changeScene();
	}

	@FXML
	private void peruuttaa(ActionEvent event) throws IOException {

		changeScene();
	}

	public void changeScene() throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("AdminManagement.fxml"));
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
