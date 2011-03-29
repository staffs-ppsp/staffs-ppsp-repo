package main_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Dave Russell
 * @version 1.6
 * @since 1.6
 * 
 */

/**
 * Enumerated type 'Row', to indicate which Row the booking is in
 */
enum Row {
	A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8);
	private int intRowNum; // Integer value for enum Row

	/**
	 * Constructor for Row
	 * 
	 * @param _intRowNum
	 *            passed in integer value of enum Row
	 */
	Row(int _intRowNum) {
		this.intRowNum = _intRowNum;
	}

	/**
	 * @return Returns integer value denoting the Row number
	 */
	public int getRowNum() {
		return intRowNum;
	}

	/**
	 * method to set which row number
	 * 
	 * @param _intNum
	 *            passed row number
	 */
	public void setRowNum(int _intNum) {
		this.intRowNum = _intNum;
	}
}

/**
 * Enumerated type 'Column', to indicate which Column the booking is in
 */
enum Column {
	J(0), K(1), L(2), M(3), N(4), O(5), P(6), Q(7), R(8), S(9), T(10), U(11), V(
			12), W(13), X(14), Y(15);
	private int intColNum; // Integer value of enum Column

	/**
	 * @param _intColNum
	 *            passed in integer value of enum Column
	 */
	Column(int _intColNum) {
		this.intColNum = _intColNum;
	}

	/**
	 * @return Returns integer value denoting the Column number
	 */
	public int getColNum() {
		return intColNum;
	}

	public void setColNum(int _intNum) {
		this.intColNum = _intNum;
	}
}

public class Seats {

	// Variable declarations

	private Booking objBooking; // booking object
	private Date dteCurrentDateTime; // Date type to get the current date and
										// time
	private String strCurrentDateTime; // String to get initialise the date and
										// time to
	private int intBookingID; // Number to represent the Booking ID belonging to
								// a seat
	private int intShowingID; // Number to represent the Showing ID that the
								// seat belongs to
	private double dblTotalPrice;
	private Row objRow; // Enumerated data type Row, represents which row the
						// seat is in
	private Column objColumn; // Enumerated data type Column, represents which
								// column the seat is in
	private int intNumSeats; // Number of seats booked
	private int[][] arrSeats; // 2 Dimensional array to represent the seat
								// layout
	private String strScreen; // String to represent the screen
	private ArrayList<String> bookings = new ArrayList<String>(); // Storage to
																	// hold
																	// bookings

	/**
	 * Default constructor for Seats class
	 * 
	 * @param _strScreen
	 *            value to assign to the string strScreen
	 */
	public Seats(String _strScreen) {
		setStrScreen(_strScreen);
		arrSeats = new int[9][16];
	}

	/**
	 * overloaded constructor for Seats class
	 * 
	 * @param _objBooking
	 *            the booking object to be associated with the seats booked
	 */
	public Seats(Booking _objBooking) {
		this.objBooking = _objBooking;
		this.intNumSeats = getIntNumSeats();
		this.dblTotalPrice = getDoubleTotalPrice();
		this.objRow = getObjRow();
		this.objColumn = getObjColumn();
	}

	/**
	 * overloaded constructor, this includes everything that is necessary for a
	 * seat booking to be made
	 * 
	 * @param _objBooking
	 *            the passed booking object
	 * @param _intNumSeats
	 *            the number of seats required
	 * @param _objRow
	 *            the row at which the customer would like to be sat
	 * @param _objColumn
	 *            the column at which the customer would like to be sat
	 */
	public Seats(Booking _objBooking, int _intNumSeats, Row _objRow,
			Column _objColumn) {
		this.objBooking = _objBooking;
		this.intNumSeats = _intNumSeats;
		this.dblTotalPrice = getDoubleTotalPrice();
		this.objRow = _objRow;
		this.objColumn = _objColumn;
	}

	/**
	 * Method to add a booking to the requested number of seats
	 * 
	 * @param _objSeats
	 *            passed seats object, this represents the screen
	 * @throws Exception
	 *             custom exception which is thrown when the seat is already
	 *             booked
	 */
	public void addSeat(Seats _objSeats) throws Exception {
		try {

			if (!getCurrentDateTime().equalsIgnoreCase(
					objBooking.getShowingTime())) {
				for (int i = 0; i < _objSeats.intNumSeats; i++) {
					if (arrSeats[_objSeats.objRow.getRowNum()][_objSeats.objColumn
							.getColNum() + i] == 0) {
						arrSeats[_objSeats.objRow.getRowNum()][_objSeats.objColumn
								.getColNum() + i] = _objSeats.objBooking
								.getIntBookingID();
						bookings.add("Booking ID: "
								+ _objSeats.objBooking.getIntBookingID() + "\n"
								+ "Row: " + _objSeats.objRow.getRowNum() + 1
								+ "\n" + "Column: " + _objSeats.objColumn);
					} else
						throw new Exception();
				}
			} else {
				System.out.println("Unable to book at this time");
			}
		} catch (Exception e) {
			System.out.println("Seat Already Booked: " + _objSeats.objRow
					+ _objSeats.objColumn);
		}
	}

	/* Getters and Setters for Seats class */

	public int getIntBookingID() {
		return intBookingID;
	}

	public void setIntBookingID(int _intBookingID) {
		this.intBookingID = _intBookingID;
	}

	public int getIntShowingID() {
		return intShowingID;
	}

	public void setIntShowingID(int _intShowingID) {
		this.intShowingID = _intShowingID;
	}

	public void setStrScreen(String strScreen) {
		this.strScreen = strScreen;
	}

	public String getStrScreen() {
		return strScreen;
	}

	public void setObjRow(Row _objRow) {
		this.objRow = _objRow;
	}

	public Row getObjRow() {
		return objRow;
	}

	public void setObjColumn(Column _objColumn) {
		this.objColumn = _objColumn;
	}

	public Column getObjColumn() {
		return objColumn;
	}

	public int getIntNumSeats() {
		return intNumSeats;
	}

	public int setIntNumSeats(int intNumSeats) {
		this.intNumSeats = intNumSeats;
		return intNumSeats;
	}

	public void setDblTotalPrice(int _dblTotalPrice) {
		this.dblTotalPrice = _dblTotalPrice;
	}

	public double getDoubleTotalPrice() {
		return dblTotalPrice;
	}

	/**
	 * Overridden toString method, returns the booked seats in a nice format
	 */
	@Override
	public String toString() {
		for (int i = 0; i < arrSeats.length; i++) {
			for (int j = 0; j < arrSeats[i].length; j++) {
				if (arrSeats[i][j] == 0) {
					System.out.print("[ ]");
				} else {
					System.out.print("[X]");
				}
			}

			System.out.print("\n");
		}
		return strScreen;
	}

	/**
	 * lists the bookings
	 */
	public void listByBooking() {
		for (int i = 0; i < bookings.size(); i++) {
			System.out.println(bookings.get(i));
		}
	}

	/**
	 * method to get the current date and time
	 * 
	 * @return the date formatted in the format dd/MM/yyyy HH:mm (03/09/2009
	 *         15:32)
	 */
	public String getCurrentDateTime() {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		dteCurrentDateTime = new Date();
		strCurrentDateTime = sdf.format(dteCurrentDateTime);
		return strCurrentDateTime;
	}

}
