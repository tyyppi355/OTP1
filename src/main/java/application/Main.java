package application;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import model.Kirja;
import model.Kirjatiedot;
import model.Rajapinta;
import model.Tietokanta;

public class Main {
	
	public static void main(String args[]) {
		
		Rajapinta.yhteys("9781974725915");
		Kirjatiedot k = Rajapinta.getKirjatiedot();
		System.out.println(k.getKirjoittajat());
		System.out.println(k.getNimi());
		Rajapinta.yhteys("9783453533011");
		Kirjatiedot k2 = Rajapinta.getKirjatiedot();
		System.out.println(k2.getKirjoittajat());
		System.out.println(k2.getNimi());
		LocalDate myObj = LocalDate.now();
		System.out.println(myObj.plusDays(30).toString());
		
		view.EngineUI.main(args);
		
		
	}

    
}