package main_package;

import java.util.ArrayList;

/**
 * 
 * @author Dave Russell
 * @version 1.0
 * @since 1.6
 * 
 */

/**
 * Enumerated type 'SeatType', to indicate whether or not the type of seat is
 * Premium or Standard
 */
enum SeatType {
    PREMIUM, STANDARD
}

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
}

/**
 * Enumerated type 'Column', to indicate which Column the booking is in
 */
enum Column {
    J(0), K(1), L(2), M(3), N(4), O(5), P(6), Q(7), R(8);
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
}

public class Seats {

    // Variable declarations

    private int intBookingID; // Number to represent the Booking ID belonging to
			      // a seat
    private int intShowingID; // Number to represent the Showing ID that the
			      // seat belongs to
    private Row rowRow; // Enumerated data type Row, represents which row the
			// seat is in
    private Column clmColumn; // Enumerated data type Column, represents which
			      // column the seat is in
    private SeatType stSeatType; // Enumerated data type SeatType, represents
				 // the type of seat
    private int[][] arrSeats; // 2 Dimensional array to represent the seat
			      // layout
    private String strScreen; // String to represent the screen

    private ArrayList<String> bookings = new ArrayList<String>(); // Temporary
								  // storage to
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
	arrSeats = new int[9][9];
    }

    /**
     * Method to add a Booking ID to a seat
     * 
     * @param _rowRow
     *            the row which the seat is in
     * @param _clmColumn
     *            the column which the seat is in
     * @param _intBookingID
     *            the booking id to be assigned to the seat
     */
    public void addSeat(Row _rowRow, Column _clmColumn, int _intBookingID)
	    throws Exception {
	try {
	    if (arrSeats[_rowRow.getRowNum()][_clmColumn.getColNum()] == 0) {
		arrSeats[_rowRow.getRowNum()][_clmColumn.getColNum()] = _intBookingID;
		bookings.add("Booking ID: " + _intBookingID + "\n" + "Row: "
			+ _rowRow + "\n" + "Column: " + _clmColumn);
	    } else
		throw new Exception();
	} catch (Exception e) {
	    System.out.println("Seat Already Booked: " + _rowRow + _clmColumn);
	}

    }

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

    public SeatType getStSeatType() {
	return stSeatType;
    }

    public void setStSeatType(SeatType _stSeatType) {
	this.stSeatType = _stSeatType;
    }

    public void setStrScreen(String strScreen) {
	this.strScreen = strScreen;
    }

    public String getStrScreen() {
	return strScreen;
    }

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

    public void listByBooking() {
	for (int i = 0; i < bookings.size(); i++) {
	    System.out.println(bookings.get(i));
	}
    }
}
