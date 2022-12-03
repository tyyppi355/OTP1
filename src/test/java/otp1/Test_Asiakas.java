package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Asiakas {

	private Asiakas asiakas = new Asiakas();

	@Test
	void test_asiakas_ID() {
		asiakas.setAs_id(1100);
		assertEquals(1100, asiakas.getAs_id(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakas_Etunimi() {
		asiakas.setEtunimi("jack");
		assertEquals("jack", asiakas.getEtunimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakas_Kirja_id() {
		asiakas.setKirja_id(12);
		assertEquals(12, asiakas.getKirja_id(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakas_Puhelinnum() {
		asiakas.setPuhelinnum("04233425");
		assertEquals("04233425", asiakas.getPuhelinnum(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakas_Sukunimi() {
		asiakas.setSukunimi("joy");
		assertEquals("joy", asiakas.getSukunimi(), "Tiedot eivät oikein");
	}

	@Test
	void test_asiakas_Asiakastiedot() {
		Asiakastiedot s = new Asiakastiedot();
		asiakas.setAsiakastiedot(s);
		assertEquals(s, asiakas.getAsiakastiedot(), "Tiedot eivät oikein");
	}

}
