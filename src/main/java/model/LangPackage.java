package model;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class LangPackage {

	@SuppressWarnings("deprecation")
	public static Locale locale = new Locale("en", "NZ");
	public static ResourceBundle rBundle = ResourceBundle.getBundle("ResourceBundle/Bundle", locale);

	public static ResourceBundle getrBundle() {
		return rBundle;
	}

	@SuppressWarnings("deprecation")
	public static void getrBundle_FI() {
		locale = new Locale("fi", "FI");
		rBundle = ResourceBundle.getBundle("ResourceBundle/Bundle", locale);
	}

	@SuppressWarnings("deprecation")
	public static void getrBundle_NZ() {
		locale = new Locale("en", "NZ");
		rBundle = ResourceBundle.getBundle("ResourceBundle/Bundle", locale);
	}

	public static void main(String args[]) {

		System.out.println(getrBundle().getString("ISBN"));

	}

}
