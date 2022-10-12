package otp1;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Kirja;
import model.Kirjasto;

class KirjastoDataTest {
	
	private Kirja kirja = new Kirja();
	private Kirjasto kirjasto = new Kirjasto();

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

}
