package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Asiakastiedot {

	private Asiakastiedot asiakastiedot = new Asiakastiedot();

	@Test
	void test_asiakastiedot_As_id() {
		asiakastiedot.setAs_id(1200);
		assertEquals(1200, asiakastiedot.getAs_id(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_asiakastiedot() {
		asiakastiedot.setAsiakastiedot(asiakastiedot);
		assertEquals(asiakastiedot, asiakastiedot.getAsiakastiedot(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_Etunimi() {
		asiakastiedot.setEtunimi("koo");
		assertEquals("koo", asiakastiedot.getEtunimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_Kaupunki() {
		asiakastiedot.setKaupunki("Espoo");
		assertEquals("Espoo", asiakastiedot.getKaupunki(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_Osoite() {
		asiakastiedot.setOsoite("Espoo B12");
		assertEquals("Espoo B12", asiakastiedot.getOsoite(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_Puh_numero() {
		asiakastiedot.setPuh_numero("04766224");
		assertEquals("04766224", asiakastiedot.getPuh_numero(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_Posti_numero() {
		asiakastiedot.setPosti_numero("09722");
		assertEquals("09722", asiakastiedot.getPosti_numero(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakastiedot_S_posti() {
		asiakastiedot.setS_posti("koo098@gmail.com");
		assertEquals("koo098@gmail.com", asiakastiedot.getS_posti(), "Tiedot eivät oikein");
	}

}
