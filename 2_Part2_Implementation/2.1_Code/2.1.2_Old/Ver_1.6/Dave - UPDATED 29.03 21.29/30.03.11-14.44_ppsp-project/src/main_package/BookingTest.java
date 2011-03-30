package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookingTest {

	Seats screen1 = new Seats("Screen 1");
	Booking booking = new Booking("Bookings");
	Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823",
			456, "Manager", "jn1", "lalalala");
	Film flm1 = new Film("Paul", 15);
	FilmShowing fs1 = new FilmShowing(flm1, "27/03/2011", screen1, 6.99);
	Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113");
	Booking staffBooking = new Booking(stf1);
	Booking testBooking;
	Booking sncBooking = new Booking(cst1, stf1);
	Booking fullBooking = new Booking(cst1, stf1, fs1);
	

	@Test
	public final void testBooking() {
		assertNotNull(testBooking = new Booking());
	}

	@Test
	public final void testBookingString() {
		assertNotNull(staffBooking.toString());
	}

	@Test
	public final void testBookingStaff() {
		assertNotNull(testBooking = new Booking(stf1));
	}

	@Test
	public final void testBookingCustomerStaff() {
		assertNotNull(testBooking = new Booking(cst1,stf1));
	}

	@Test
	public final void testBookingCustomerStaffFilmShowing() {
		assertNotNull(testBooking = new Booking(cst1, stf1, fs1));
	}

	@Test
	public final void testGetIntBookingID() {
		assertNotNull(staffBooking.getIntBookingID());
		assertNotSame(staffBooking.getIntBookingID(), sncBooking.getIntBookingID());
	}

	@Test
	public final void testGetDblTotalPrice() {
		assertNotNull(fullBooking.getDblTotalPrice());
	}

	@Test
	public final void testGetIntStaffID() {
		assertNotNull(staffBooking.getIntStaffID());
	}

	@Test
	public final void testGetIntShowingID() {
		assertNotNull(fullBooking.getIntShowingID());
	}

	@Test
	public final void testGetIntCustomerID() {
		assertNotNull(fullBooking.getIntCustomerID());
	}

	@Test
	public final void testGetIntFilmRating() {
		assertNotNull(fullBooking.getIntFilmRating());
	}

	@Test
	public final void testGetShowingTime() {
		assertNotNull(fullBooking.getShowingTime());
	}

	@Test
	public final void testAddBooking() {
		booking.addBooking(fullBooking);
		assertNotNull(booking);
	}

	@Test
	public final void testGenerateBookingID() {
		assertNotNull(fullBooking.generateBookingID());
	}

	@Test
	public final void testGetDateTime() {
		assertNotNull(fullBooking.getDateTime());
	}

	@Test
	public final void testToString() {
		assertNotNull(fullBooking.toString());
	}

}
