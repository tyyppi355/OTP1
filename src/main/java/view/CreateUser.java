package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUser {

	
	  	@FXML	private Button luoBtn;
	    @FXML	private TextField luoEtunimi;
	    @FXML	private TextField luoSukunimi;
	    @FXML	private Button peruuttaa;
	    @FXML	private void luoKayttajaa(ActionEvent event) throws IOException {
	    	String etunimi = luoEtunimi.getText();
	    	String sukunimi = luoSukunimi.getText();
	    	
	    	
	    	if(etunimi.isEmpty() || sukunimi.isEmpty() ){ 
	    			JOptionPane.showMessageDialog(null, "Please fill the data!");
	    			return;
	    		}

	    	String query ="INSERT INTO kirjan_tiedot (kirja_ISBN, nimi, kustantaja, kirjoittajat, kuva, julkaisuvuosi, sivumäärä) VALUES ("+
	    					"'" + etunimi + "', '" + sukunimi + "', '"
	    					+"')";
	    	System.out.println(query);
	    	//TODO add into database:
	    	JOptionPane.showMessageDialog(null, "New User is added!");
	    	
	    	
	    	
	    	changeScene();
	     	}

	    @FXML	private void peruuttaa(ActionEvent event) throws IOException {
	    	
	    	changeScene();
	    	/*	Stage stage = (Stage) peruuttaa.getScene().getWindow();
	    		stage.close();*/
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        /*Stage stage = (Stage) peruuttaa.getScene().getWindow();
	        root = FXMLLoader.load(getClass().getResource("Kirjatiedot.fxml"));
	        Scene scene = new Scene(root);
	        stage.setOpacity(1);
	        stage.setScene(scene);
	        stage.close();*/
			       
	    }
		
	}
