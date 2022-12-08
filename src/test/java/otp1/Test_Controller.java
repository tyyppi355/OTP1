package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.Test;
import controller.*;
import model.*;

public class Test_Controller {

	private Controller controller = new Controller();
	private Tietokanta tietokanta = new Tietokanta();

	@Test
	void test_tarkistaLogin() {
		assumeTrue(controller.tarkistaLogin("admin", "123", 1));
	}

	@Test
	void test_lainaaPost() throws Exception {
		assertEquals(controller.lainaaPost("5", "51").getKirja_id(), tietokanta.get_kirjat().get(1).getKirja_id());
	}

	@Test
	void test_kirjaPost() throws Exception {
		Kirja kirja = new Kirja();
		kirja.setKirja_ISBN(131241);
		assertEquals(controller.kirjaPost(kirja).getKirja_ISBN(), kirja.getKirja_ISBN());
	}

	@Test
	void test_haeKirjat() throws Exception {
		Kirja kirja = new Kirja();
		kirja.setKirja_id(51);
		assertEquals(controller.haeKirjat().get(1).getKirja_id(), kirja.getKirja_id());
		//assertEquals(controller.haeKirjat().get(0).getKirja_id(), tietokanta.get_kirjat().get(0).getKirja_id());
	}

	@Test
	void test_kirjaTiedotPost() throws Exception {
		Kirjatiedot kirjatiedot = new Kirjatiedot(123123, "Prior", "HarperCollins Publishers", "Sinclair Lewis",
				"6376827", 123, 123);
		controller.kirjaTiedotPost(kirjatiedot.getKirja_ISBN());
	}

	@Test
	void test_palautusPost() throws Exception {
		controller.palautusPost("52");

	}

	@Test
	void test_addAsiakas() throws Exception {
		Asiakas asiakas = new Asiakas();
		controller.addAsiakas(asiakas);

	}

}
