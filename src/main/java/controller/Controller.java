package controller;

import java.util.ArrayList;
import java.util.List;

import model.Asiakas;
import model.Kirja;
import model.Kirjatiedot;
import model.Rajapinta;
import model.Tietokanta;

public class Controller implements M2V,V2M {
	

	@Override
	public boolean tarkistaLogin(String user, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void lainaaPost(List kirjat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kirjaPost(Kirja k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asiakas haeAsiakas(String tunnus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Kirja> haeKirjat(){
		
		try {
			return Tietokanta.get_kirjat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Kirjatiedot kirjaTiedotPost(Long isbn) {
		// TODO Auto-generated method stub
		try {
			Rajapinta.yhteys(String.valueOf(isbn));
			Tietokanta.post_kirjan_tiedot(Rajapinta.getKirjatiedot());
			return Rajapinta.getKirjatiedot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
