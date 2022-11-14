package otp1;






import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Admin;
import model.Asiakas;

class KäyttäjäLuokatTest {
	
	private Asiakas asiakas = new Asiakas();
	private Admin admin = new Admin();
	
	@Test
	void testAdmin() {
		admin.setKäyttäjätunnu("xXx_apina69_xXx");
		String result = admin.getKäyttäjätunnu();
				assertEquals(result, admin.getKäyttäjätunnu(), "Tiedot vastaa");
	}
	
	@Test
	void testEtunimi() {
		asiakas.setEtunimi("Niko");
		String result = asiakas.getEtunimi();
		assertEquals(result, asiakas.getEtunimi(), "Vastaavatko etunimet");
		
	}
	
	@Test
	void testSukunimi() {
		asiakas.setSukunimi("Ahonen");
		String result = asiakas.getSukunimi();
		assertEquals( result, asiakas.getSukunimi(), "Nimet vastaa");
	}

}
