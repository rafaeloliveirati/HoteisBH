package br.com.hoteisbh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.hoteisbh.controller.TestHotelController;
import br.com.hoteisbh.controller.TestReservaController;
import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ TestHotelController.class, TestReservaController.class })
public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test para Hoteis");
		suite.addTestSuite(TestHotelController.class);
		suite.addTestSuite(TestReservaController.class);
		return suite;
	}
}
