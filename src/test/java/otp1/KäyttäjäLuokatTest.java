package otp1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Admin;
import model.Asiakas;

class KäyttäjäLuokatTest {
	
	private Asiakas asiakas = new Asiakas();
	private Admin admin = new Admin();
	
	@Test
    @DisplayName("Testaa palauttaako sovellus Admin tunnuksen oikein")
	void testAdmin() {
		admin.setKäyttäjätunnu("xXx_apina69_xXx");
		final String result = admin.getKäyttäjätunnu();
				assertEquals("Tiedot eivät vastaa", result, admin.getKäyttäjätunnu());
	}
	
	@Test
    @DisplayName("Hae asiakkaan etunimi")
	void testEtunimi() {
		asiakas.setEtunimi("Niko");
		final String result = asiakas.getEtunimi();
		assertEquals("Nimet eivät vastaa", result, asiakas.getEtunimi());
		
	}
	
	@Test
    @DisplayName("Hae asiakkaan sukunimi")
	void testSukunimi() {
		asiakas.setSukunimi("Ahonen");
		final String result = asiakas.getSukunimi();
		assertEquals("Nimet eivät vastaa", result, asiakas.getSukunimi());
	}

}
