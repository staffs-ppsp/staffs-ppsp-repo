package main_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Booking {

	private static int psintBookingID = 1;

	private int intBookingID;
	private int intStaffID;
	private int intShowingID;
	private int intCustomerID;
	private double dblTotalPrice;
	private Date dteDateTime;
	private String strDateTime;
	private String strBookings;
	private ArrayList<Booking> bookings = new ArrayList<Booking>();

	private Customer objCustomer;
	private Staff objStaff;
	private FilmShowing objFilmShowing;

	public Booking() {
		this.intBookingID = generateBookingID();
	}

	public Booking(String _strBookings) {
		strBookings = _strBookings;
		bookings = new ArrayList<Booking>();
	}
	
	public Booking(Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.objStaff = _objStaff;
	}
	
	public Booking(Customer _objCustomer, Staff _objStaff) {
		this.intBookingID = generateBookingID();
		this.objCustomer = _objCustomer;
		this.objStaff = _objStaff;
	}

	public Booking(Customer _objCustomer, Staff _objStaff,
			FilmShowing _objFilmShowing) {
		this.intBookingID = generateBookingID();
		this.objCustomer = _objCustomer;
		this.objStaff = _objStaff;
		this.objFilmShowing = _objFilmShowing;
	}

	public void addBooking(Booking _objBooking) {
		bookings.add(_objBooking);
	}

	public void showBookings() {
		for (int i = 0; i < bookings.size(); i++) {
			System.out.println(bookings.get(i).toString());
		}
	}
	
	public void setFilmShowing(FilmShowing _objFilmShowing) {
		this.objFilmShowing = _objFilmShowing;
	}
	
	public FilmShowing getFilmShowing() {
		return objFilmShowing;
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
		return "Booking ID: " + intBookingID + "\nCustomerID: " + intCustomerID
				+ "\nStaff ID: " + intStaffID + "\nShowing ID: " + intShowingID
				+ "\nTotal Price: " + dblTotalPrice + "\nDate/Time: "
				+ strDateTime;
	}

}
