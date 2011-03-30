package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilmTest {
	
	Film films = new Film("Films");
	Film testFilm;
	Film newFilm2 = new Film("Harry Potter and the Mysterious Case of Missing Work", 15);

	@Test
	public final void testFilmString() {
		assertNotNull(testFilm = new Film("Films"));
	}

	@Test
	public final void testFilm() {
		assertNotNull(testFilm = new Film());
	}

	@Test
	public final void testFilmStringInt() {
		assertNotNull(testFilm = new Film("The Exorcist", 18));
	}

	@Test
	public final void testAddFilm() {
		films.addFilm(newFilm2);
		assertNotNull(films);
	}

	@Test
	public final void testGetIntFilmID() {
		assertNotNull(newFilm2.getIntFilmID());
	}

	@Test
	public final void testSetStrFilmName() {
		newFilm2.setStrFilmName("The Exorcist 2");
		assertNotNull(newFilm2.getStrFilmName());
		System.out.println(newFilm2.getStrFilmName());
	}

	@Test
	public final void testGetStrFilmName() {
		assertNotNull(newFilm2.getStrFilmName());
	}

	@Test
	public final void testSetIntRating() {
		newFilm2.setIntRating(15);
		assertNotNull(newFilm2.getIntRating());
		System.out.println(newFilm2.getIntRating());
	}

	@Test
	public final void testGetIntRating() {
		assertNotNull(newFilm2.getIntRating());
	}

	@Test
	public final void testToString() {
		System.out.println(newFilm2);
	}

	@Test
	public final void testGenerateFilmID() {
		assertNotNull(newFilm2.generateFilmID());
	}

}
