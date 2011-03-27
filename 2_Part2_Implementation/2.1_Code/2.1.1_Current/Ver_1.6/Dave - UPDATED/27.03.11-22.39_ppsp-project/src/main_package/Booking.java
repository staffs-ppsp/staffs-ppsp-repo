package main_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private static int psintBookingID = 1;

	private int intBookingID;
	private int intStaffID;
	private int intShowingID;
	private int intCustomerID;
	private int intFilmRating;
	private double dblTotalPrice;
	private Date dteDateTime;
	private String strDateTime;
	private ArrayList<Booking> bookings = new ArrayList<Booking>();

	public Booking() {
		this.intBookingID = generateBookingID();
	}

	public Booking(String _strBookings) {
		bookings = new ArrayList<Booking>();
	}

	public Booking(Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.intStaffID = _objStaff.getStaffID();
	}

	public Booking(Customer _objCustomer, Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.intCustomerID = _objCustomer.getCustomerID();
		this.intStaffID = _objStaff.getStaffID();
	}

	public Booking(Customer _objCustomer, Staff _objStaff,
			FilmShowing _objFilmShowing) {
		this.intBookingID = generateBookingID();
		this.intCustomerID = _objCustomer.getCustomerID();
		this.intStaffID = _objStaff.getStaffID();
		this.intShowingID = _objFilmShowing.getIntShowingID();
		this.strDateTime = _objFilmShowing.getDateTime();
		this.dblTotalPrice = _objFilmShowing.getDblPrice();
	}

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

	public void addBooking(Booking _objBooking) {
		bookings.add(_objBooking);
	}

	public void showBookings() {
		for (int i = 0; i < bookings.size(); i++) {
			System.out.println(bookings.get(i).toString());
		}
	}

	public int generateBookingID() {
		psintBookingID++;
		return intBookingID = psintBookingID;
	}

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
