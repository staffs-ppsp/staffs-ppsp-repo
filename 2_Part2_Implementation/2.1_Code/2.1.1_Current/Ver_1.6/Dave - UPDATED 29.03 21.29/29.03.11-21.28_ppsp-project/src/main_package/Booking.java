package main_package;

/**
 * @author Dave Russell, James Nightingale
 * @version 1.6
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private static int psintBookingID = 1;

	private int intBookingID; // the booking ID
	private int intStaffID; // the staff ID
	private int intShowingID; // the showing ID
	private int intCustomerID; // the customer ID
	private int intFilmRating; // the rating of the film
	private double dblTotalPrice; // the total price of the booking
	private Date dteDateTime; // the date and time from Date class
	private String strDateTime; // the string representation of the date
	private ArrayList<Booking> bookings = new ArrayList<Booking>(); // array
																	// list to
																	// hold the
																	// bookings

	// default constructor
	public Booking() {
		this.intBookingID = generateBookingID();
	}

	// constructor to create the array list
	public Booking(String _strBookings) {
		bookings = new ArrayList<Booking>();
	}

	// constructor to create a booking with a known staff object
	public Booking(Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.intStaffID = _objStaff.getStaffID();
	}

	// constructor to create a booking with a known customer and staff object
	public Booking(Customer _objCustomer, Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.intCustomerID = _objCustomer.getCustomerID();
		this.intStaffID = _objStaff.getStaffID();
	}

	// constructor to create a booking with a known customer, staff and filmshowing object
	public Booking(Customer _objCustomer, Staff _objStaff,
			FilmShowing _objFilmShowing) {
		this.intBookingID = generateBookingID();
		this.intCustomerID = _objCustomer.getCustomerID();
		this.intStaffID = _objStaff.getStaffID();
		this.intShowingID = _objFilmShowing.getIntShowingID();
		this.strDateTime = _objFilmShowing.getDateTime();
		this.dblTotalPrice = _objFilmShowing.getDblPrice();
	}

	/* GETTERS AND SETTERS */
	public int getIntBookingID() {
		return intBookingID;
	}

	public void setIntBookingID(int intBookingID) {
		this.intBookingID = intBookingID;
	}

	public void setDblTotalPrice(double dblTotalPrice) {
		this.dblTotalPrice = dblTotalPrice;
	}

	public double getDblTotalPrice() {
		return dblTotalPrice;
	}

	public int getIntStaffID() {
		return intStaffID;
	}

	public void setIntStaffID(int intStaffID) {
		this.intStaffID = intStaffID;
	}

	public int getIntShowingID() {
		return intShowingID;
	}

	public void setIntShowingID(int intShowingID) {
		this.intShowingID = intShowingID;
	}

	public int getIntCustomerID() {
		return intCustomerID;
	}

	public void setIntCustomerID(int intCustomerID) {
		this.intCustomerID = intCustomerID;
	}

	public int getIntFilmRating() {
		return intFilmRating;
	}

	public void setIntFilmRating(int _intFilmRating) {
		this.intFilmRating = _intFilmRating;
	}

	public void setStrDateTime(FilmShowing _objFilmShowing) {
		this.strDateTime = _objFilmShowing.getStrDate();
	}

	public String getShowingTime() {
		return strDateTime;
	}

	/**
	 * method to add bookings
	 * @param _objBooking the passed booking object to add to the array
	 */
	public void addBooking(Booking _objBooking) {
		bookings.add(_objBooking);
	}

	/**
	 * method to show all the bookings
	 */
	public void showBookings() {
		for (int i = 0; i < bookings.size(); i++) {
			System.out.println(bookings.get(i).toString());
		}
	}

	/**
	 * method to generate a bookingID
	 * @return the booking ID
	 */
	public int generateBookingID() {
		psintBookingID++;
		return intBookingID = psintBookingID;
	}

	/**
	 * method to get the date and time
	 * @return the date and time as a string
	 */
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
		dteDateTime = new Date();
		strDateTime = dateFormat.format(dteDateTime);
		return strDateTime;
	}

	// toString override
	@Override
	public String toString() {
		super.toString();
		return "Booking ID: " + intBookingID + "\nCustomerID: "
				+ getIntCustomerID() + "\nStaff ID: " + getIntStaffID()
				+ "\nShowing ID: " + getIntShowingID() + "\nTotal Price: "
				+ getDblTotalPrice() + "\nBooking Made At: " + getDateTime();
	}

}
