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
	private TableView<Kirja> tableview;
	@FXML
	private TableColumn<Kirja, Integer> kirja_ISBN;
	@FXML
	private TableColumn<Kirja, String> nimi;
	@FXML
	private TableColumn<Kirja, String> kunstantaja;
	@FXML
	private TableColumn<Kirja, Long> kirjoittajat;
	@FXML
	private TableColumn<Kirja, Integer> kuva;
	@FXML
	private TableColumn<Kirja, String> julkasuvuosi;
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
	ObservableList<Kirja> data;

	@FXML
	void deleteBook(ActionEvent event) throws Exception {


        Kirja selectedForDeletion = tableview.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
        	JOptionPane.showMessageDialog(null,"No book selected", "Please select a book for deletion.", 0);
            return;
        }
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting book");
        alert.setContentText("Are you sure want to delete the book " + selectedForDeletion.getkTiedot().getNimi() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Boolean result = Tietokanta.delete_kirja(selectedForDeletion.getKirja_id());
            if (result) {
            	JOptionPane.showMessageDialog(null,"Book deleted", selectedForDeletion.getkTiedot().getNimi() + " was deleted successfully.", 0);
            	data.remove(selectedForDeletion);
            } else {
            	JOptionPane.showMessageDialog(null,"Failed", selectedForDeletion.getkTiedot().getNimi() + " could not be deleted", 0);
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
		UpdateTable();

	}

	public void initialize(URL url, ResourceBundle rb) {
		
		kirja_ISBN.setText(LangPackage.rBundle.getString("Book_ID"));
		nimi.setText(LangPackage.rBundle.getString("Status"));
		kunstantaja.setText(LangPackage.rBundle.getString("Class"));
		kirjoittajat.setText(LangPackage.rBundle.getString("Book_ISBN"));
		kuva.setText(LangPackage.rBundle.getString("Library_id"));
		UpdateTable();
	}

	public void UpdateTable() {
		this.data = FXCollections.observableArrayList();
		ArrayList<Kirja> lista = getcontroller.haeKirjat();

		for (Kirja k : lista) {
			data.add(k);
		}
		

		kirja_ISBN.setCellValueFactory(new PropertyValueFactory<Kirja, Integer>("kirja_id"));
		nimi.setCellValueFactory(new PropertyValueFactory<Kirja, String>("tila"));
		kunstantaja.setCellValueFactory(new PropertyValueFactory<Kirja, String>("luokka"));
		kirjoittajat.setCellValueFactory(new PropertyValueFactory<Kirja, Long>("kirja_ISBN"));
		kuva.setCellValueFactory(new PropertyValueFactory<Kirja, Integer>("kirjasto_id"));

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
