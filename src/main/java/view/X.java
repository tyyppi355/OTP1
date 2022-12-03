package view;

import java.util.Locale;
import java.util.ResourceBundle;

public final class X {

	Locale l_NZ = new Locale("en", "NZ");
	ResourceBundle r_NZ = ResourceBundle.getBundle("ResourceBundle/Bundle_en_NZ", l_NZ);
	
	Locale l_FI = new Locale("fi", "FI");
	ResourceBundle r_FI;

	public void changLng() {
		r_FI = ResourceBundle.getBundle("ResourceBundle/Bundle", l_FI);
	}
	
}
