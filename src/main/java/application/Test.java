package application;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {

		Locale l_NZ = new Locale("en", "NZ");
		ResourceBundle r_NZ = ResourceBundle.getBundle("ResourceBundle/Bundle_en_NZ", l_NZ);

		System.out.println(r_NZ.getString("Title"));
		System.out.println(r_NZ.getString("Number_of_pages"));
		System.out.println(r_NZ.getString("Add_Books") + "\n");

		Locale l_FI = new Locale("fi", "FI");
		ResourceBundle r_FI = ResourceBundle.getBundle("ResourceBundle/Bundle", l_FI);

		System.out.println(r_FI.getString("Status"));
		System.out.println(r_FI.getString("Username"));

	}

}
