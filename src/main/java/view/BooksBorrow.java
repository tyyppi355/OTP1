package view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Kirja;
import model.Kirjatiedot;
import model.LangPackage;
import model.Tietokanta;

// TODO: Auto-generated Javadoc
public class BooksBorrow implements Initializable {
	
	/** The getcontroller. */
	M2V getcontroller = new Controller();
	
	/** The postcontroller. */
	V2M postcontroller = new Controller();

	/**
	 * Instantiates a new books borrow.
	 */
	public BooksBorrow() {

	}

	/** The asiakas ID. */
	// TextFields
	@FXML
	private TextField asiakasID;
	
	/** The kirja ID. */
	@FXML
	private TextField kirjaID;
	
	/** The asiakas tiedot. */
	@FXML
	private Text asiakasTiedot;

	/** The tableview. */
	// Tableview
	@FXML
	private TableView<Kirjatiedot> tableview;
	
	/** The julkasuvuosi. */
	@FXML
	private TableColumn<Kirjatiedot, String> julkasuvuosi;
	
	/** The kirja ISBN. */
	@FXML
	private TableColumn<Kirjatiedot, Long> kirja_ISBN;
	
	/** The kirjoittajat. */
	@FXML
	private TableColumn<Kirjatiedot, String> kirjoittajat;
	
	/** The kunstantaja. */
	@FXML
	private TableColumn<Kirjatiedot, String> kunstantaja;
	
	/** The kuva. */
	@FXML
	private TableColumn<Kirjatiedot, String> kuva;
	
	/** The nimi. */
	@FXML
	private TableColumn<Kirjatiedot, String> nimi;
	
	/** The sivumäärä. */
	@FXML
	private TableColumn<Kirjatiedot, Integer> sivumäärä;

	/** The btn close. */
	// Buttons
	@FXML
	private Button btnClose;
	
	/** The delete. */
	@FXML
	private Button delete;
	
	/** The edit. */
	@FXML
	private Button edit;
	
	/** The add book. */
	@FXML
	private Button addBook;
	
	/** The create book. */
	@FXML
	private Button createBook;
	
	/** The isbn. */
	@FXML
	private TextField ISBN;

	/** The connection. */
	Connection connection;
	
	/** The res. */
	ResultSet res = null;
	
	/** The pst. */
	PreparedStatement pst = null;
	
	/** The data. */
	ObservableList<Kirjatiedot> data;

	/**
	 * Delete book method - method that delete the book from list and databse.
	 *
	 *@author Fatlum Gerguri
	 * @param event the event
	 * @throws Exception the exception
	 */
	@FXML
	void deleteBook(ActionEvent event) throws Exception {

		int selectedID = tableview.getSelectionModel().getSelectedIndex();
		if (selectedID == 0) {
			JOptionPane.showMessageDialog(null, "Not selected");
		} else {
			JOptionPane.showMessageDialog(null, "Delete the data");
			tableview.getItems().remove(selectedID);
		}
	}

	
	/**
	 * Adds the item.
	 *
	 * @param event the event
	 */
	@FXML
	void addItem(ActionEvent event) {
		
		System.out.println("test");
		try {
			
			postcontroller.lainaaPost(asiakasID.getText(), kirjaID.getText());
			Kirjatiedot t = Tietokanta.get_kirja(Integer.parseInt(kirjaID.getText())).getkTiedot();
			data.add(t);
			
		} catch (Exception e) {
			if (asiakasID.getText().isBlank() || kirjaID.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Please fill the data!");
			}else {
				JOptionPane.showMessageDialog(null, "Not available");
			}
			
		}
		

	}
	
	
	/**
	 * Initialize.
	 *
	 * @param url the url
	 * @param rb the rb
	 */
	public void initialize(URL url, ResourceBundle rb) {
		UpdateTable();
	}

	
	/**
	 * Update table.
	 */
	public void UpdateTable() {
		this.data = FXCollections.observableArrayList();

		kirja_ISBN.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Long>("kirja_ISBN"));
		nimi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("Nimi"));
		kunstantaja.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kunstantaja"));
		kirjoittajat.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kirjoittajat"));
		kuva.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kuva"));
		julkasuvuosi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("julkasuvuosi"));
		sivumäärä.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Integer>("sivumäärä"));

		tableview.setItems(data);
	}

}
