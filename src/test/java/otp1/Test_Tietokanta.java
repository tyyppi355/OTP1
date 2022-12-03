package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Tietokanta {

	private Tietokanta tietokanta = new Tietokanta();

	@Test
	void test_Tietokanta_admin_Käyttäjätunnu() throws Exception {
		String getKäyttäjätunnu = tietokanta.get_admin(1).getKäyttäjätunnu();
		assertEquals("admin", getKäyttäjätunnu, "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_admin_salasana() throws Exception {
		assertEquals("123", tietokanta.get_admin(1).getSalasana(), "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_get_asiakas() throws Exception {
		assertEquals("erd", tietokanta.get_asiakas(5).getEtunimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_get_kirja() throws Exception {
		assertEquals("1.7", tietokanta.get_kirja(31).getLuokka(), "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_get_kirjasto() throws Exception {
		assertEquals("tapiola", tietokanta.get_kirjasto(1).getKirjasto_nimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_get_kirjat() throws Exception {
		assertEquals("hyllyssä", tietokanta.get_kirjat().get(0).getTila(), "Tiedot eivät oikein");
	}

	@Test
	void test_Tietokanta_get_Kirjatiedot() throws Exception {
		assertEquals("Creative Gene", tietokanta.get_Kirjatiedot(213).getNimi(), "Tiedot eivät oikein");
	}

}
