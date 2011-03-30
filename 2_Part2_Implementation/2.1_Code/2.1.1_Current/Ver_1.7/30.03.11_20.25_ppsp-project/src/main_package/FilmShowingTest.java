package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilmShowingTest {

	Seats screen1 = new Seats("Screen 1");
	FilmShowing showings = new FilmShowing("Showings");
	Film flm1 = new Film("Paul", 15);
	FilmShowing testFS;
	FilmShowing fs1 = new FilmShowing(flm1, "27/03/2011", screen1, 6.99);

	@Test
	public final void testToString() {
		showings.addFilmShowing(fs1);
		System.out.println(fs1);
	}

	@Test
	public final void testFilmShowing() {
		assertNotNull(testFS = new FilmShowing(flm1));
	}

	@Test
	public final void testFilmShowingString() {
		assertNotNull(testFS = new FilmShowing("Showings"));
	}

	@Test
	public final void testFilmShowingFilmStringSeatsDouble() {
		assertNotNull(testFS = new FilmShowing(flm1, "21/03/2009", screen1,
				4.99));
	}

	@Test
	public final void testFilmShowingFilm() {
		showings.addFilmShowing(fs1);
		showings.showShowings();
	}

	@Test
	public final void testGetIntShowingID() {
		assertNotNull(fs1.getIntShowingID());
	}

	@Test
	public final void testSetStrDate() {
		fs1.setStrDate("21/03/2009");
	}

	@Test
	public final void testGetStrDate() {
		assertNotNull(fs1.getStrDate());
	}

	@Test
	public final void testGetStrScreen() {
		assertNotNull(fs1.getStrScreen());
	}

	@Test
	public final void testSetStrScreen() {
		fs1.setStrScreen("Screen 2");
		System.out.println(fs1.toString());
		assertNotNull(fs1.getStrScreen());
	}

	@Test
	public final void testGetDblPrice() {
		assertNotNull(fs1.getDblPrice());
	}

	@Test
	public final void testSetIntPrice() {
		fs1.setIntPrice(7.99);
		System.out.println(fs1);
	}

	@Test
	public final void testAddFilmShowing() {
		showings.addFilmShowing(fs1);
	}

	@Test
	public final void testShowShowings() {
		showings.showShowings();
	}

	@Test
	public final void testGetByID() {
		showings.addFilmShowing(fs1);
		assertNotNull(showings.getByID(2));
		System.out.println(showings.getByID(2));
	}

	@Test
	public final void testGetByRating() {
		showings.addFilmShowing(fs1);
		assertNotNull(showings.getByRating(2));
		System.out.println(showings.getByRating(2));
	}

	@Test
	public final void testGetByPrice() {
		showings.addFilmShowing(fs1);
		assertNotNull(showings.getByPrice(2));
		System.out.println(showings.getByPrice(2));
	}

	@Test
	public final void testGenerateFSID() {
		testFS = new FilmShowing();
		assertNotNull(testFS.generateFSID());
	}

	@Test
	public final void testGetDateTime() {
		assertNotNull(fs1.getDateTime());
	}
}
