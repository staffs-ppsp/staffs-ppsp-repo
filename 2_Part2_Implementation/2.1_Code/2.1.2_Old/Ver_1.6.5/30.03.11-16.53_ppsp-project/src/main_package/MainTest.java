package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public final void testLoginAdminFunction() {
		assertNotNull(main_package.Main.loginAdminFunction());
	}

	@Test
	public final void testPremiumSeatPrice() {
		assertNotNull(main_package.Main.premiumSeatPrice());
	}

	@Test
	public final void testLoginUserFunction() {
		assertNotNull(main_package.Main.loginUserFunction());
	}

	@Test
	public final void testAddFilmFunction() {
		assertNotNull(main_package.Main.addFilmFunction());
	}

	@Test
	public final void testAdvancedBooking() {
		try {
			assertTrue(main_package.Main.advancedBooking());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public final void testMakeBooking() {
		try {
			assertTrue(main_package.Main.makeBooking());
		} catch (Exception e) {
			fail("Will fail regardless. Has no showings to reference");
		}
	}
}
