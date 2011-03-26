import java.util.*;
/**
 *
 * @author James
 */

public class Film extends FilmShowing{

      
private int intFilmID;
private string strFilmName;
private int intRating;

public Customer (int _intTheFilmID, string _strTheFilmName, int _intRating){

	this.intFilmID = _intTheFilmID;
	this.strFilmName = _strTheFilmName;
	this.intRating = _intTheRating;

   }

public String toString() {
	return ("Film ID: " + intFilmID + " Film Name: " + strFilmName + " Film Rating " + intRating);
	}

}