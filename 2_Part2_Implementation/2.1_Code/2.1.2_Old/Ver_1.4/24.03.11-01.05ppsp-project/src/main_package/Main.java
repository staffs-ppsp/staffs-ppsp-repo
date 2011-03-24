package main_package;

import java.util.Scanner;

public class Main {

	static int intChoice;

	static String strInputUserName;
	static String strInputPassword;

	static final String strAdminUsername = "admin";
	static final String strAdminPassword = "admin";
	static final String strUsername = "user";
	static final String strPassword = "user";

	static Scanner kybd = new Scanner(System.in);

	Seats screen1 = new Seats("Screen 1");
	FilmShowing showings = new FilmShowing("Showings");
	Booking bookings = new Booking("Bookings");

	FilmShowing flm1 = new FilmShowing(123, 123, "01/02/2010", 1, 4.99);
	FilmShowing flm2 = new FilmShowing(12, 25, "12/12/2011", 1, 6.80);
	Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113", 123);
	Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823", 456,
			"Manager", "jn1", "lalalala");

	Booking booking1 = new Booking(1, cst1.getCustomerID(), stf1.getStaffID(),
			flm1.getIntFilmID(), flm1.getDblPrice(), flm1.getDateTime());

	public static void main(String[] args) {

		// bookings.addBooking(booking1);
		// bookings.showBookings();

		login();
		intChoice = kybd.nextInt();
		switch (intChoice) {
		case 1:
			System.out.println("Password:");
			strInputPassword = kybd.next();
			if (strInputPassword.equalsIgnoreCase(strAdminPassword)) {
				System.out.println("Success");
				while (true) {
					adminMenu();
					intChoice = kybd.nextInt();
					switch (intChoice) {
					case 1:
						kybd.reset();
						// DO ADD FILM
						break;
					case 2:
						kybd.reset();
						// DO ADD STAFF
						break;
					default:
						System.out
								.println("Unrecognised Command: " + intChoice);
						kybd.reset();
					}
				}
			}
			break;
		case 2:
			System.out.println("User Name:");
			strInputUserName = kybd.next();
			kybd.reset();
			System.out.println("Password:");
			strInputPassword = kybd.next();
			if (strInputUserName.equalsIgnoreCase(strUsername)
					&& strInputPassword.equalsIgnoreCase(strPassword)) {
				System.out.println("Success");
				kybd.reset();
				while (true) {
					userMenu();
					intChoice = kybd.nextInt();
					switch (intChoice) {
					case 1:
						bookingMenu();
						kybd.reset();
						intChoice = kybd.nextInt();
						switch (intChoice) {
						case 1:
							kybd.reset();
							// DO MAKE ADVANCED BOOKING
							break;
						case 2:
							kybd.reset();
							// DO MAKE BOOKING
							break;
						default:
							System.out.println("Unrecognised Command: "
									+ intChoice);
							kybd.reset();
						}
						break;
					case 2:
						displayShowings();
						kybd.reset();
						intChoice = kybd.nextInt();
						switch (intChoice) {
						case 1:
							kybd.reset();
							// DO DISPLAY UPCOMING FILMS
						}
						break;
					default:
						System.out
								.println("Unrecognised Command: " + intChoice);
						kybd.reset();
					}
				}
			}
		}
	}

	public static void login() {
		System.out.println("***	Cinema Login System Ver. 1.0	***	\n");
		System.out.println("1:	Admin");
		System.out.println("2:	User");
	}

	public static void userMenu() {
		System.out.println("***	Cinema System Ver. 1.0	***	\n");
		System.out.println("1:	Make Booking");
		System.out.println("2:	Display Showings");
		System.out.println("_");
	}

	public static void adminMenu() {
		System.out.println("***	Admin Menu	***	\n");
		System.out.println("1:	Add Film");
		System.out.println("2:	Add Staff");
		System.out.println("_");
	}

	public static void bookingMenu() {
		System.out.println("***	Booking Menu	***	\n");
		System.out.println("1:	Advanced Booking");
		System.out.println("2:	Booking");
		System.out.println("_");
	}

	public static void displayShowings() {
		System.out.println("***	Showing Menu	***	\n");
		System.out.println("1:	Display Upcoming Films");
		System.out.println("_");
	}
}
