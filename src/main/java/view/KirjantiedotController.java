package view;

import java.io.IOException;
import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import org.mariadb.jdbc.Connection;

import controller.Controller;
import controller.M2V;
import controller.V2M;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import model.Kirja;
import model.Kirjatiedot;
import model.LangPackage;
import model.Tietokanta;

public class KirjantiedotController extends EngineUI implements Initializable {

	M2V getcontroller = new Controller();
	V2M postcontroller = new Controller();

	public KirjantiedotController() {

	}

	// TextFields
	@FXML
	private TextField ISBN;
	@FXML
	private TextField kirjTila;
	@FXML
	private TextField kirjaLuokka;
	@FXML
	private TextField kirjastoID;

	@FXML
	private TableView<Kirjatiedot> tableview;
	@FXML
	private TableColumn<Kirjatiedot, String> julkasuvuosi;
	@FXML
	private TableColumn<Kirjatiedot, Long> kirja_ISBN;
	@FXML
	private TableColumn<Kirjatiedot, String> kirjoittajat;
	@FXML
	private TableColumn<Kirjatiedot, String> kunstantaja;
	@FXML
	private TableColumn<Kirjatiedot, String> kuva;
	@FXML
	private TableColumn<Kirjatiedot, String> nimi;
	@FXML
	private TableColumn<Kirjatiedot, Integer> sivumäärä;

	// Buttons
	@FXML
	private Button btnClose;
	@FXML
	private Button delete;
	@FXML
	private Button edit;
	@FXML
	private Button addBook;
	@FXML
	private Button createBook;

	Connection connection;
	ResultSet res = null;
	PreparedStatement pst = null;
	ObservableList<Kirjatiedot> data;

	@FXML
	void deleteBook(ActionEvent event) throws Exception {


        Kirjatiedot selectedForDeletion = tableview.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
        	JOptionPane.showMessageDialog(null,"No book selected", "Please select a book for deletion.", 0);
            return;
        }
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting book");
        alert.setContentText("Are you sure want to delete the book " + selectedForDeletion.getNimi() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Boolean result = Tietokanta.delete_kirja(selectedForDeletion);
            if (result) {
            	JOptionPane.showMessageDialog(null,"Book deleted", selectedForDeletion.getNimi() + " was deleted successfully.", 0);
            	data.remove(selectedForDeletion);
            } else {
            	JOptionPane.showMessageDialog(null,"Failed", selectedForDeletion.getNimi() + " could not be deleted", 0);
            }
        } else {
        	JOptionPane.showMessageDialog(null,"Deletion cancelled", "Deletion process cancelled", 0);
        }
	}

	@FXML
	void addItem(ActionEvent event) {
		Kirja k = new Kirja(kirjTila.getText(), kirjaLuokka.getText(), Long.parseLong(ISBN.getText()),
				Integer.parseInt(kirjastoID.getText()));
		k = postcontroller.kirjaPost(k);
		if (k.getkTiedot() != null) {
			tableview.getItems().add(k.getkTiedot());
		}

	}

	public void initialize(URL url, ResourceBundle rb) {
		UpdateTable();
	}

	public void UpdateTable() {
		this.data = FXCollections.observableArrayList();
		ArrayList<Kirja> lista = getcontroller.haeKirjat();

		for (Kirja k : lista) {
			Kirjatiedot t = k.getkTiedot();
			data.add(t);
		}

		kirja_ISBN.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Long>("kirja_ISBN"));
		nimi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("Nimi"));
		kunstantaja.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kunstantaja"));
		kirjoittajat.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kirjoittajat"));
		kuva.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kuva"));
		julkasuvuosi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("julkasuvuosi"));
		sivumäärä.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Integer>("sivumäärä"));

		tableview.setItems(data);
	}

	@FXML
	void btnClose(ActionEvent event) throws IOException {
		// get a handle to the stage
		FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("AdminManagement.fxml"),LangPackage.rBundle);
		Scene scene = new Scene(fxmlLoader.load()); // scene

		Stage stage = EngineUI.getPrimaryStage();
		stage.hide();
		stage.setTitle("Kirjaston lainausjärjestelmä!");
		stage.setScene(scene);
		stage.show();
	}

	public void createBook(ActionEvent event) throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("CreateBook.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausjärjestelmä!");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
