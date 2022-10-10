package otp1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Admin;
import model.Asiakas;
import model.Kirja;
import model.Kirjasto;

class Luokat {
	
	private Asiakas asiakas = new Asiakas();
	private Kirja kirja = new Kirja();
	private Kirjasto kirjasto = new Kirjasto();
	private Admin admin = new Admin();
	
	
	
	@Test
    @DisplayName("Hae asiakkaan etunimi")
	void testNimet() {
		asiakas.setEtunimi("Niko");
		final String result = asiakas.getEtunimi();
		assertEquals("Nimet eivät vastaa", result, asiakas.getEtunimi());
		
	}
	
	@Test
    @DisplayName("Hae kirjan tila")
	void testKirjanTila() {
        kirja.setTila("Lainauksessa");
        final String result = kirja.getTila();
        assertEquals("Tiedot eivät vastaa", result, kirja.getTila());
	}
	
	@Test
    @DisplayName("hae kirjaston IDn tiedot")
	void testKirjastoID() {
        kirjasto.setKirjasto_id(12);
        int result = kirjasto.getKirjasto_id();
        assertEquals("Tiedot eivät vastaa", result, kirjasto.getKirjasto_id());
	}
	
	@Test
    @DisplayName("hae Admin")
	void testAdmin() {
		admin.setKäyttäjätunnu("xXx_apina69_xXx");
		final String result = admin.getKäyttäjätunnu();
				assertEquals("Tiedot eivät vastaa", result, admin.getKäyttäjätunnu());
	}

}
