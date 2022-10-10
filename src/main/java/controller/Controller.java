package controller;

import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Asiakas;
import model.Kirja;
import model.Kirjatiedot;
import model.Rajapinta;
import model.Tietokanta;

public class Controller implements M2V,V2M {
	

	@Override
	public boolean tarkistaLogin(String user, String pwd) {
		// TODO Auto-generated method stub
		try {
			Admin a = Tietokanta.get_admin(1);
			if(user.equals(a.getKäyttäjätunnu()) && pwd.equals(a.getSalasana())) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Kirja lainaaPost(String asiakas_id,String kirja_id) {
		// TODO Auto-generated method stub
		try {
			return Tietokanta.lainaus(asiakas_id, kirja_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Kirja kirjaPost(Kirja k) {
		// TODO Auto-generated method stub
		try {
			if(Tietokanta.get_Kirjatiedot(k.getKirja_ISBN()) == null) {
				Rajapinta.yhteys(String.valueOf(k.getKirja_ISBN()));
				Rajapinta.getKirjatiedot().setKirja_ISBN(k.getKirja_ISBN());
				Tietokanta.post_kirjan_tiedot(Rajapinta.getKirjatiedot());
				k.setkTiedot(Rajapinta.getKirjatiedot());
				System.out.println("toimii");
			}
			Tietokanta.post_kirja(k);
			return k;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return k;
		}
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

	@Override
	public Kirja palautusPost(String kirja_id) {
		// TODO Auto-generated method stub
		try {
			return Tietokanta.palautus(kirja_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addAsiakas(Asiakas asiakas) {
		// TODO Auto-generated method stub
		try {
			Tietokanta.post_asiakas_tiedot(asiakas.getAsiakastiedot());
			Tietokanta.post_asiakas(asiakas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
