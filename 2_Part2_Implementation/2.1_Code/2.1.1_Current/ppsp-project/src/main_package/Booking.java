package main_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private int intBookingID;
	private int intStaffID;
	private int intShowingID;
	private int intCustomerID;

	private double dblTotalPrice;
	private Date dteDateTime;
	private String strDateTime;
	
	private String strBookings;
	
	private ArrayList<Booking> bookings = new ArrayList<Booking>();

	public Booking(String _strBookings) {
		strBookings = _strBookings;
		bookings = new ArrayList<Booking>();
	}

	public Booking(int _intBookingID, int _intCustomerID, int _intStaffID,
			int _intShowingID, double _dblPrice, String _strDateTime) {
		this.intBookingID = _intBookingID;
		this.intCustomerID = _intCustomerID;
		this.intStaffID = _intStaffID;
		this.intShowingID = _intShowingID;
		this.dblTotalPrice = _dblPrice;
		this.strDateTime = _strDateTime;
	}
	
	public void addBooking(Booking _objBooking) {
		bookings.add(_objBooking);
	}
	
	public void showBookings() {
		for (int i = 0; i < bookings.size(); i++) {
			System.out.println(bookings.get(i).toString());
		}
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

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
		dteDateTime = new Date();
		strDateTime = dateFormat.format(dteDateTime);
		return strDateTime;
	}

	// toString overide
	@Override
	public String toString() {
		super.toString();
		return "Booking ID: " + intBookingID + "\nCustomerID: " + intCustomerID
				+ "\nStaff ID: " + intStaffID + "\nShowing ID: " + intShowingID
				+ "\nTotal Price: " + dblTotalPrice + "\nDate/Time: "
				+ strDateTime;
	}

}
