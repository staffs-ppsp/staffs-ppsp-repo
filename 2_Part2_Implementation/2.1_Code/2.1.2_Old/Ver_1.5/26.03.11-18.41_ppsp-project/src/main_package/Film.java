package main_package;

import java.util.ArrayList;

/**
 * 
 * @author James
 */

public class Film {

	private String strFilms;
	private int intFilmID;
	private String strFilmName;
	private int intRating;
	private ArrayList<Film> films = new ArrayList<Film>();

	public Film(String _StrFilms) {
		this.strFilms = _StrFilms;
		films = new ArrayList<Film>();
	}

	public Film() {
	}

	public Film(int _intTheFilmID, String _strTheFilmName, int _intRating) {

		this.intFilmID = _intTheFilmID;
		this.strFilmName = _strTheFilmName;
		this.intRating = _intRating;

	}

	public void addFilm(Film objFilm) {
		films.add(objFilm);
	}

	public int getIntFilmID() {
		return intFilmID;
	}

	public void setStrFilmName(String _strFilmName) {
		this.strFilmName = _strFilmName;
	}

	public String getStrFilmName() {
		return strFilmName;
	}

	public void setIntRating(int intRating) {
		this.intRating = intRating;
	}

	public int getIntRating() {
		return intRating;
	}

	public String toString() {
		return "Film ID: " + intFilmID + " Film Name: " + strFilmName
				+ " Film Rating " + intRating;
	}

	public void setIntFilmID(int _intFilmID) {
		this.intFilmID = _intFilmID;
	}

}