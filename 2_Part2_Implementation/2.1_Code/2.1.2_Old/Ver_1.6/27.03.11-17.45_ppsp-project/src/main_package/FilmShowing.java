package main_package;

/**
 * @author 	Dave Rusell
 * @version 	1.6
 * @since 	1.6
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FilmShowing extends Film {

	// FilmShowing Variable Declarations
	private static int psintFilmShowingID = 1;

	private int intShowingID; // ID of showing
	private String strDateTime; // Date and time in String format
	private Date dteDateTime; // Date and time in Date format
	private String strScreenNum; // Number of the screen
	private double dblPrice; // Price of the showing
	private ArrayList<FilmShowing> arrFSArray; // Container for film showings

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
	public FilmShowing(Film _objFilmID, String _strDate, Seats _objSeats,
			double _dblPrice) {
		super(_objFilmID.getStrFilmName(), _objFilmID.getIntRating());
		intShowingID = generateFSID();
		strDateTime = _strDate;
		strScreenNum = _objSeats.getStrScreen();
		dblPrice = _dblPrice;
	}

	public int getIntShowingID() {
		return intShowingID;
	}

	public void setIntShowingID(int _intShowingID) {
		this.intShowingID = _intShowingID;
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

	public int getByID(int _intID) {
		for (FilmShowing fs : arrFSArray) {
			if (fs.getIntShowingID() == _intID) {
				return fs.getIntShowingID();
			}
		}
		return 0;
	}

	public int getByRating(int _intID) {
		for (FilmShowing fs : arrFSArray) {
			if (fs.getIntShowingID() == _intID) {
				return fs.getIntRating();
			}
		}
		return 0;
	}

	public double getByPrice(int _intID) {
		for (FilmShowing fs : arrFSArray) {
			if (fs.getIntShowingID() == _intID) {
				return fs.getDblPrice();
			}
		}
		return 0;
	}

	public int generateFSID() {
		psintFilmShowingID++;
		intShowingID = psintFilmShowingID;
		return intShowingID;
	}

	/**
	 * Declares a new DateFormat object - dateFormat and assigns it a new
	 * SimpleDateFormat assigns variable dteDateTime a new Date object formats
	 * this object to the dateFormat
	 * 
	 * @return returns strDateTime as a String
	 */
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
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
				+ getIntFilmID() + "\n" + "Rating: " + getIntRating() + "\n"
				+ "Date & Time: " + getDateTime() + "\n" + "Screen: "
				+ getStrScreenNum() + "\n" + "Price: " + getDblPrice() + "\n";
	}
}
