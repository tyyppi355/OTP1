package otp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

import controller.Controller;
import model.*;

public class Test_Controller {
	
	Controller controller = new Controller();
	
	@Test
	void test_tarkistaLogin() {
		assumeTrue(controller.tarkistaLogin("admin", "123", 1));
	}

}
