package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Kirjasto {

	private Kirjasto kirjasto = new Kirjasto();

	@Test
	void test_kirjasto_Kirjasto_id() {
		kirjasto.setKirjasto_id(1202);
		assertEquals(1202, kirjasto.getKirjasto_id(), "Tiedot eivät oikein");
	}

	@Test
	void test_kirjasto_Kirjasto_nimi() {
		kirjasto.setKirjasto_nimi("Sello Kirjasto");
		assertEquals("Sello Kirjasto", kirjasto.getKirjasto_nimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_kirjasto_Kaupunki() {
		kirjasto.setKaupunki("Espoo");
		assertEquals("Espoo", kirjasto.getKaupunki(), "Tiedot eivät oikein");
	}

	@Test
	void test_kirjasto_Osoite() {
		kirjasto.setOsoite("Leppävaara");
		assertEquals("Leppävaara", kirjasto.getOsoite(), "Tiedot eivät oikein");
	}

	@Test
	void test_kirjasto_Posti_numero() {
		kirjasto.setPosti_numero(23242);
		assertEquals(23242, kirjasto.getPosti_numero(), "Tiedot eivät oikein");
	}

	@Test
	void test_kirjasto_Puh_numero() {
		kirjasto.setPuh_numero(0434432);
		assertEquals(0434432, kirjasto.getPuh_numero(), "Tiedot eivät oikein");
	}

}
