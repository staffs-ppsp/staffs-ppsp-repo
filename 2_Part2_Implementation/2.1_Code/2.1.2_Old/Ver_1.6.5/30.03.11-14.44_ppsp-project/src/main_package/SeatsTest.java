package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeatsTest {

	/* CONSTRUCTING ALL NECESSARY OBJECTS FOR TEST */
	static Seats screen1 = new Seats("Screen 1");
	static Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823",
			456, "Manager", "jn1", "lalalala");
	static Film flm1 = new Film("Paul", 15);
	static FilmShowing fs1 = new FilmShowing(flm1, "27/03/2011", screen1, 6.99);
	static Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113");
	Booking booking = new Booking(cst1, stf1, fs1);

	/* CONSTRUCTING BASIC SEAT BOOKINGS */
	Seats seats = new Seats(booking);
	Seats newSeats = new Seats(booking, 2, Row.A, Column.M);

	/* TESTING FOR OBJECT ORIENTATION */
	@Test
	public final void testGetIntBookingID() {
		assertNotNull("Booking ID is null", seats.getIntBookingID());
	}

	@Test
	public final void testGetIntShowingID() {
		assertNotNull("Showing ID is null", seats.getIntShowingID());
	}
	
	@Test
	public final void testGetIntCustomerID() {
		assertNotNull("Customer ID is null", seats.getIntCustomerID());
	}

	@Test
	public final void testGetStrScreen() {
		assertNotNull("Screen is null", screen1.getStrScreen());
	}

	@Test
	public final void testGetDoubleTotalPrice() {
		assertNotNull("Price is null", seats.getDoubleTotalPrice());
	}

	@Test
	public final void testScreens() {
		assertSame("Screens do not match", screen1.getStrScreen(),
				fs1.getStrScreen());
	}

	/* TESTING FOR ADDING DETAILS */

	@Test
	public final void testSetIntNumSeats() {
		int test;
		assertSame("Return error", seats.setIntNumSeats(2),
				test = seats.setIntNumSeats(2));
		assertSame("Number of seats do not match", seats.setIntNumSeats(2),
				seats.getIntNumSeats());
	}

	@Test
	public final void testGetIntNumSeats() {
		assertNotNull("Number of seats is null", seats.getIntNumSeats());
	}

	@Test
	public final void testSetObjRow() {
		assertTrue("Row is unrecognised", seats.setObjRow(Row.A));
	}

	@Test
	public final void testGetObjRow() {
		seats.setObjRow(Row.A);
		assertNotNull(seats.getObjRow());
	}

	@Test
	public final void testSetObjColumn() {
		assertTrue("Column is unrecognised", seats.setObjColumn(Column.J));
	}

	@Test
	public final void testGetObjColumn() {
		seats.setObjColumn(Column.L);
		assertNotNull("Column has not been set", seats.getObjColumn());
	}

	@Test
	public final void testAddSeat() {
		try {
			assertTrue("Adding has failed - Returned false", screen1.addSeat(seats));
		} catch (Exception e) {
			fail("Adding has failed - Exception caught");
		}
	}

	@Test
	public final void testToString() {
		screen1.addSeat(newSeats);
		assertNotNull(screen1.toString());
	}

	@Test
	public final void testGetCurrentDateTime() {
		assertNotNull("Get date/time failed",seats.getCurrentDateTime());
	}

}
