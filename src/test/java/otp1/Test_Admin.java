package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.*;

public class Test_Admin {

	private Admin admin = new Admin("Admin", "1234", 1);

	@Test
    @DisplayName("Testaa palauttaako sovellus Admin tunnuksen oikein")
	void testAdmin() {
			assertEquals(admin.getKäyttäjätunnu(), "Admin");
	}
	
	@Test
    @DisplayName("Testaa palauttaako sovellus salasanan oikein")
	void testSalasana() {
			assertEquals(admin.getSalasana(), "1234");
	}
	
	@Test
    @DisplayName("hae kirjaston IDn tiedot")
	void testKirjastoID() {
        assertEquals(admin.getKirjasto_id(), 1);
	}
}
