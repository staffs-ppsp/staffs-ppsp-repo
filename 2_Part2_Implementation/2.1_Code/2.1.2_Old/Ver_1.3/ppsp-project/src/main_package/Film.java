package main_package;

/**
 *
 * @author James
 */

public class Film extends FilmShowing{

      
private int intFilmID;
private String strFilmName;
private int intRating;

public Film (int _intTheFilmID, String _strTheFilmName, int _intRating){

	this.intFilmID = _intTheFilmID;
	this.strFilmName = _strTheFilmName;
	this.intRating = _intRating;

   }

public String toString() {
	return ("Film ID: " + intFilmID + " Film Name: " + strFilmName + " Film Rating " + intRating);
	}

}