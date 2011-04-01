package main_package;

import java.util.ArrayList;

/**
 * 
 * @author James
 */

public class Film {

	private static int psintFilmID;

	private int intFilmID;
	private String strFilmName;
	private int intRating;
	private ArrayList<Film> films = new ArrayList<Film>();

	public Film(String _StrFilms) {
		films = new ArrayList<Film>();
	}

	public Film() {
	}

	public Film(String _strTheFilmName, int _intRating) {

		this.intFilmID = generateFilmID();
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
		return "Film ID: " + intFilmID + "\nFilm Name: " + strFilmName
				+ "\nFilm Rating " + intRating;
	}

	public void setIntFilmID(int _intFilmID) {
		this.intFilmID = _intFilmID;
	}

	public int generateFilmID() {
		psintFilmID++;
		return psintFilmID;
	}

}