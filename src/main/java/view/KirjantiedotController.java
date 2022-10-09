package view;


import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Kirja;
import model.Kirjatiedot;

public class KirjantiedotController extends EngineUI implements Initializable{
	
	M2V getcontroller = new Controller();
	V2M postcontroller = new Controller();
		
	private	Stage stage;
	private	Pane container;
	private Parent root;
	private String sql = "SELECT FROM kirjan_tiedot WHERE id = ?";
	
	
	public KirjantiedotController() {
		
	}
	
	//TextFields
	@FXML	private TextField ISBN;
	@FXML	private TextField kirjTila;
	@FXML	private TextField kirjaLuokka;
    @FXML	private TextField kirjastoID;
	
	
	@FXML	private TableView<Kirjatiedot> tableview;
	@FXML	private TableColumn<Kirjatiedot, String> julkasuvuosi;
    @FXML	private TableColumn<Kirjatiedot, Long> kirja_ISBN;
    @FXML	private TableColumn<Kirjatiedot, String> kirjoittajat;
    @FXML	private TableColumn<Kirjatiedot, String> kunstantaja;
    @FXML	private TableColumn<Kirjatiedot, String> kuva;
    @FXML	private TableColumn<Kirjatiedot, String> nimi;
    @FXML	private TableColumn<Kirjatiedot, Integer> sivumäärä; 
    @FXML	private TableColumn<Kirjatiedot, String> erapaiva;
    

    //Buttons
    @FXML	private Button btnClose;
 	 @FXML 	private Button delete;
	 @FXML	private Button edit;
	 @FXML	private Button addBook;    
	 @FXML	private Button createBook;
	 

	 Connection connection;
	 ResultSet res = null;
	 PreparedStatement  pst = null;
	 ObservableList<Kirjatiedot> data;
	 
	 
	 
	 
	 
	 @FXML void deleteBook(ActionEvent event) throws Exception {
		/* Kirjatiedot selectedID = (Kirjatiedot) tableview.getSelectionModel().getSelectedItems();
		 //tableview.getItems().remove(selectedID);
		 
		 
		 String sql = "DELETE from kirjan_tiedot kirja WHERE  kirja_id = ?";
		 if(selectedID !=null) {
			 		
				 pst = connection.prepareStatement("DELETE from kirjan_tiedot library WHERE  kirja_ISBN = ?");
				 pst.setLong(1, selectedID.getKirja_ISBN());
				 pst.executeUpdate();
				 
				 JOptionPane.showMessageDialog(null, "Delete");
				 
				 
				 UpdateTable(); 
		 }*/
		 int selectedID = tableview.getSelectionModel().getSelectedIndex();
		 if(selectedID == 0) { 
			JOptionPane.showMessageDialog(null, "Not selected");
		 }else {
			 JOptionPane.showMessageDialog(null, "Delete the data");
			 tableview.getItems().remove(selectedID);
		 }
	 }
	 @FXML void addItem(ActionEvent event) {
			 Kirjatiedot kt = postcontroller.kirjaTiedotPost(Long.parseLong(ISBN.getText().toString()));
			 
			 tableview.getItems().add(kt);

		 
	  }
	  /*ObservableList<Kirjatiedot> data = FXCollections.observableArrayList(
			  new Kirjatiedot(1, "Java", "Oracle", "Oracle CO", "Java language", 2000, 300),
			  new Kirjatiedot(1, "JavaFX", "Oracle", "Oracle CO", "JavaFX language", 2000, 300)
		);*/
	 
	
	
	    public void initialize(URL url, ResourceBundle rb) {UpdateTable();}
	    
	    public void UpdateTable() {
	    	this.data = FXCollections.observableArrayList() ;
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
		    	erapaiva.setCellValueFactory(new PropertyValueFactory<Kirjatiedot, String>("sivumäärä"));
		    	
				
				tableview.setItems(data);	    	
	    }
	    
	    @FXML	void btnClose(ActionEvent event) throws IOException {
	    	// get a handle to the stage
	        Stage stage = (Stage) btnClose.getScene().getWindow();
	        // do what you have to do
	        stage.close();
	    }
	    
	   public void createBook(ActionEvent event) throws IOException {
		   try {
				FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("CreateBook.fxml"));
		        Scene scene = new Scene(fxmlLoader.load()); // scene

		        Stage stage = EngineUI.getPrimaryStage();
		        stage.hide();
		        stage.setTitle("Kirjaston lainausjärjestelmä!");
		        stage.setScene(scene);
		        stage.show();		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}

