package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Admin {

	private Admin admin = new Admin();

	@Test
	void testAdminKäyttäjätunnu() {
		admin.setKäyttäjätunnu("Admin");
		String result = admin.getKäyttäjätunnu();
		assertEquals("Admin", result, "Tiedot eivät vastaa");
	}

	@Test
	void testAdminSalasana() {
		admin.setSalasana("123");
		assertEquals("123", admin.getSalasana(), "Tiedot eivät oikein");
	}

	@Test
	void testAdminKirjastoID() {
		admin.setKirjasto_id(1001);
		assertEquals(1001, admin.getKirjasto_id(), "Tiedot eivät oikein");
	}

}
