package model;


import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class KirjantiedotController implements Initializable{

	public KirjantiedotController() {
		
	}
	@FXML	private TableView<Kirjatiedot> tableview;
	@FXML	private TableColumn<Kirjatiedot, String> julkasuvuosi;
    @FXML	private TableColumn<Kirjatiedot, Integer> kirja_ISBN;
    @FXML	private TableColumn<Kirjatiedot, String> kirjoittajat;
    @FXML	private TableColumn<Kirjatiedot, String> kunstantaja;
    @FXML	private TableColumn<Kirjatiedot, String> kuva;
    @FXML	private TableColumn<Kirjatiedot, String> nimi;
    @FXML	private TableColumn<Kirjatiedot, Integer> sivumäärä; 
    @FXML	private TableColumn<Kirjatiedot, String> erapaiva; 
    

 	 @FXML 	private Button delete;
	 @FXML	private Button edit;
	 @FXML	private Button addBook;

	 @FXML void deleteBook(ActionEvent event) {}
	 @FXML void editBook(ActionEvent event) {}
	 @FXML void addItem(ActionEvent event) {
			 Kirjatiedot kirja = new Kirjatiedot(31223, "SceneBuilder", "Oracle", "Oracle CO.", "Java Framework", 2000, 300, "Date");
			 tableview.getItems().add(kirja);

		 
	  }
	  /*ObservableList<Kirjatiedot> data = FXCollections.observableArrayList(
			  new Kirjatiedot(1, "Java", "Oracle", "Oracle CO", "Java language", 2000, 300),
			  new Kirjatiedot(1, "JavaFX", "Oracle", "Oracle CO", "JavaFX language", 2000, 300)
		);*/
	 
	
	
	    public void initialize(URL url, ResourceBundle rb) {
					
	    	ObservableList<Kirjatiedot> data = FXCollections.observableArrayList(
	  			  new Kirjatiedot(1, "Java", "Oracle", "Oracle CO", "Java language", 2000, 300, "Date1"),
	  			  new Kirjatiedot(1, "JavaFX", "Oracle", "Oracle CO", "JavaFX language", 2000, 300, "Date2")
	  		);
	    	kirja_ISBN.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Integer>("kirja_ISBN"));
	    	nimi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("Nimi"));
	    	kunstantaja.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kunstantaja"));
	    	kirjoittajat.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kirjoittajat"));
	    	kuva.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("kuva"));
	    	julkasuvuosi.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("julkasuvuosi"));
	    	sivumäärä.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, Integer>("sivumäärä"));
	    	erapaiva.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("sivumäärä"));
			
	    	tableview.setItems(data);
	    }
}
