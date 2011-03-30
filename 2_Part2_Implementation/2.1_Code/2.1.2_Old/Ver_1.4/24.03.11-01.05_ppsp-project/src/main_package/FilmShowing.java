package main_package;

/**
 * @author 	Dave Rusell
 * @version 	1.0
 * @since 	1.6
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilmShowing extends Film {

	// FilmShowing Variable Declarations

	private Film objFilm;
	private int intShowingID; // ID of showing
	private int intFilmID; // ID of film
	private String strDateTime; // Date and time in String format
	private Date dteDateTime; // Date and time in Date format
	private String strScreenNum; // Number of the screen
	private double dblPrice; // Price of the showing
	private ArrayList<FilmShowing> arrFSArray; // Container for film showings
	private String strShowings; // String to denote the title of the container

	/**
	 * Default constructor - Used in conjunction with setters when not all
	 * components are known
	 */
	public FilmShowing() {

	}

	/**
	 * Overloaded constructor - Used as a container, hence the ArrayList
	 * 
	 * @param _strShowings
	 *            passed in value for the title of the container
	 */
	public FilmShowing(String _strShowings) {
		strShowings = _strShowings;
		arrFSArray = new ArrayList<FilmShowing>();
	}

	/**
	 * Overloaded constructor - Used for constructing a new FilmShowing object
	 * when all components are known
	 * 
	 * @param _intShowingID
	 *            passed Showing ID
	 * @param _intFilmID
	 *            passed Film ID
	 * @param _strDate
	 *            passed Date in String format
	 * @param _intScreenNum
	 *            passed Screen Number
	 * @param _dblPrice
	 *            passed Price
	 */
	public FilmShowing(int _intShowingID, int _intFilmID, String _strDate,
			String _strScreenNum, double _dblPrice) {
		intShowingID = _intShowingID;
		
		intFilmID = _intFilmID;
		strDateTime = _strDate;
		strScreenNum = _strScreenNum;
		dblPrice = _dblPrice;
	}

	/**
	 * Adds a FilmShowing object to the ArrayList
	 * 
	 * @param _fsShowing
	 *            passed FilmShowing object
	 */
	public void addFilmShowing(FilmShowing _fsShowing) {
		arrFSArray.add(_fsShowing);
	}
	
	public void showShowings() {
		for (FilmShowing fs : arrFSArray) {
			System.out.println(fs);
		}
	}

	public int getIntShowingID() {
		return intShowingID;
	}

	public void setIntShowingID(int _intShowingID) {
		this.intShowingID = _intShowingID;
	}

	public int getIntFilmID() {
		return intFilmID;
	}

	public void setIntFilmID(int _intFilmID) {
		this.intFilmID = _intFilmID;
	}

	public String getStrScreenNum() {
		return strScreenNum;
	}

	public void setStrScreenNum(String _strScreenNum) {
		this.strScreenNum = _strScreenNum;
	}

	public double getDblPrice() {
		return dblPrice;
	}

	public void setIntPrice(double _dblPrice) {
		this.dblPrice = _dblPrice;
	}

	/**
	 * Declares a new DateFormat object - dateFormat and assigns it a new
	 * SimpleDateFormat assigns variable dteDateTime a new Date object formats
	 * this object to the dateFormat
	 * 
	 * @return returns strDateTime as a String
	 */
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		dteDateTime = new Date();
		strDateTime = dateFormat.format(dteDateTime);
		return strDateTime;
	}

	/**
	 * Overridden toString() method
	 * 
	 * @return returns all the information about the Film
	 */
	@Override
	public String toString() {
		return "Showing ID: " + getIntShowingID() + "\n" + "Film ID: "
				+ intFilmID + "\n" + "Date & Time: " + getDateTime() + "\n"
				+ "Screen: " + strScreenNum + "\n" + "Price: " + dblPrice;
	}
}
