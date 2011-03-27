package main_package;

/**
 * @author David Russell, James Nightingale
 * @version 1.6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static final double dblVer = 1.6;

	static int intChoice;

	static String strInputUserName;
	static String strInputPassword;

	static final String strAdminUsername = "admin";
	static final String strAdminPassword = "admin";
	static final String strUsername = "user";
	static final String strPassword = "user";

	static final int intAttempts = 3;
	static int intAttemptCtr = 0;

	static boolean boolControl = true;
	static int escape = 1;

	static Scanner kybd = new Scanner(System.in);
	static InputStreamReader in = new InputStreamReader(System.in);
	static BufferedReader lineReader = new BufferedReader(in);

	static Seats screen1 = new Seats("Screen 1");
	static FilmShowing showings = new FilmShowing("Showings");
	static Staff staff = new Staff("Staff");
	static Film films = new Film("Films");
	static Customer customers = new Customer("Customers");
	static Booking bookings = new Booking("Bookings");

	static Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823",
			456, "Manager", "jn1", "lalalala");

	public static void main(String[] args) {

		staff.addStaff(stf1);

		Film flm1 = new Film(1, "Paul", 15);
		Film flm2 = new Film(2, "The Exorcist", 18);
		Film flm3 = new Film(3, "Spiderman", 12);

		films.addFilm(flm1);
		films.addFilm(flm2);
		films.addFilm(flm3);

		FilmShowing fs1 = new FilmShowing(flm1, "12/12/2011",
				screen1.getStrScreen(), 4.99);
		FilmShowing fs2 = new FilmShowing(flm2, "12/12/2011",
				screen1.getStrScreen(), 6.80);
		FilmShowing fs3 = new FilmShowing(flm3, "12/12/2011",
				screen1.getStrScreen(), 4.99);

		showings.addFilmShowing(fs1);
		showings.addFilmShowing(fs2);
		showings.addFilmShowing(fs3);

		Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113", 123);

		Booking booking = new Booking(cst1, stf1, fs1);

		// CHANGE
		Seats seats = new Seats(booking, 2, Row.A, Column.N);
		try {
			screen1.addSeat(seats);
		} catch (Exception e1) {
			// CHANGE
			System.out.println("Error");
		}

		System.out.println(screen1);

		while (escape == 1) {

			login();
			try {
				intChoice = kybd.nextInt();
				switch (intChoice) {
				case 1:
					if (loginAdminFunction() == 1) {
						while (intChoice != 0) {
							try {
								adminMenu();
								intChoice = kybd.nextInt();
								switch (intChoice) {
								case 1:
									kybd.reset();
									addFilmFunction();
									break;
								case 2:
									staff.viewStaff();
									break;
								case 0:
									break;
								default:
									System.out.println("Unrecognised Command: "
											+ intChoice);
									kybd.nextLine();
									break;
								}
							}// end switch
							catch (Exception e) {
								System.out.println("Invalid Entry");
								kybd.nextLine();
							}
						}// end while
					} // end if
					break; // end case 1
				case 2:
					if (loginUserFunction() == true) {
						kybd.reset();
						while (intChoice != 0) {
							userMenu();
							try {
								intChoice = kybd.nextInt();
								switch (intChoice) {
								case 1:
									while (intChoice != 3) {
										bookingMenu();
										kybd.reset();
										intChoice = kybd.nextInt();
										switch (intChoice) {
										case 1:
											kybd.reset();
											// CHANGE
											advancedBooking();
											break;
										case 2:
											kybd.reset();
											break;
										case 3:
											break;
										default:
											System.out
													.println("Unrecognised Command: "
															+ intChoice + "\n");
											kybd.reset();
										}
									}
									break;
								case 2:
									displayShowings();
									kybd.reset();
									intChoice = kybd.nextInt();
									switch (intChoice) {
									case 1:
										kybd.reset();
										showings.showShowings();
									}// end switch
									break;
								case 3:
									break;
								case 0:
									break;
								default:
									System.out.println("Unrecognised Command: "
											+ intChoice + "\n");
									kybd.reset();
								}// end switch
							} catch (Exception e) {
								System.out.println("Invalid Entry");
								kybd.nextLine();
							}// end catch
						}// end while
					}// end if
				default:
					System.out.println("Unrecognised Command: " + intChoice
							+ "\n");
					break;
				}

			}// end switch
			catch (Exception e) {
				System.out.println("Invalid Entry");
				kybd.nextLine();
			}// end catch
		}// end while
	}// end main

	public static int loginAdminFunction() {

		System.out.println("Password:");
		strInputPassword = kybd.next();
		if (strInputPassword.equalsIgnoreCase(strAdminPassword)) {
			System.out.println("Success");
			intAttemptCtr = 0; // Reset the attempt counter
			return 1;
		} else {
			intAttemptCtr++;
			System.out.println("\nUnsuccessful Attempt #" + intAttemptCtr);
			if (intAttemptCtr == 3) {
				System.out.println("3 Consecutive Unsuccessful Attempts.. Exiting Program");
				return escape = 2;
			}
		}
		return 3;
	}

	public static boolean loginUserFunction() {
		System.out.println("User Name:");
		strInputUserName = kybd.next();
		kybd.reset();
		System.out.println("Password:");
		strInputPassword = kybd.next();
		if (strInputUserName.equalsIgnoreCase(strUsername)
				&& strInputPassword.equalsIgnoreCase(strPassword)) {
			System.out.println("Success");
			return true;
		} else {
			System.out.println("Invalid Details");
			return false;
		}
	}

	public static boolean addFilmFunction() {
		Film newFilm = new Film();
		System.out.println("Film ID:");
		newFilm.setIntFilmID(kybd.nextInt());
		System.out.println("Film Title:");
		try {
			newFilm.setStrFilmName(lineReader.readLine());
		} catch (IOException e) {
			System.out.println("Invalid Entry");
		}
		System.out.println("Film Rating:");
		newFilm.setIntRating(kybd.nextInt());
		films.addFilm(newFilm);
		return true;
	}

	public static boolean advancedBooking() throws Exception {
		System.out.println("Enter Customer Details");
		Customer customer = new Customer();
		System.out.println("Customer First Name");
		customer.setStrFirstName(lineReader.readLine());
		System.out.println("Customer Last Name");
		customer.setStrLastName(lineReader.readLine());
		System.out.println("Customer Age");
		customer.setIntAge(kybd.nextInt());
		System.out.println("Customer Phone Number");
		customer.setStrTelephone(lineReader.readLine());
		customers.addCustomer(customer);
		Booking newBooking = new Booking(customer, stf1);
		System.out.println("Available Showings");
		showings.showShowings();
		System.out.println("ID Of Showing");
		newBooking.setFilmShowing(showings.get(kybd.nextInt()));
		if (customer.getIntAge() > newBooking.getFilmShowing().getIntRating()) {
			System.out.println("Customer Under Age");
			return false;
		} else {
			bookings.addBooking(newBooking);
			Seats seatBooking = new Seats(newBooking);
			System.out.println("Number of Seats: ");
			if (seatBooking.setIntNumSeats(kybd.nextInt()) > 10) {
				System.out
						.println("Exceeds maximum number of seats per booking");
			}
			try {
				System.out.println("Row: (0 - 8)");
				if (seatBooking.setObjRow(kybd.nextInt()) > 8) {
					throw new Exception();
				}
				System.out.println("Column: (0 - 15)");
				if (seatBooking.setObjColumn(kybd.nextInt()) > 15) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Not A Valid Seat");
			}
			return true;
		}
	}

	public static boolean makeBooking() {
		Booking newBooking = new Booking(stf1);
		System.out.println("ID Of Showing:");
		newBooking.setFilmShowing(showings.get(kybd.nextInt()));
		bookings.addBooking(newBooking);
		// SEATS UNABLE TO ADD DUE TO ENUMERATED TYPE. WILL BE ABLE TO IMLPEMENT
		// WITH WEB INTERFACE
		return true;
	}

	public static void login() {
		System.out
				.println("***	Cinema Login System Ver. " + dblVer + "	***	\n");
		System.out.println("1:	Admin");
		System.out.println("2:	User");
	}

	public static void adminMenu() {
		System.out.println("***	Admin Menu	***	\n");
		System.out.println("1:	Add Film");
		System.out.println("2:	View Staff Records");
		System.out.println("0:	Logoff");
		System.out.println("_");
	}

	public static void userMenu() {
		System.out.println("***	Cinema System Ver. " + dblVer + "	***	\n");
		System.out.println("1:	Make Booking");
		System.out.println("2:	Display Showings");
		System.out.println("0:	Logoff");
		System.out.println("_");
	}

	public static void bookingMenu() {
		System.out.println("***	Booking Menu	***	\n");
		System.out.println("1:	Advanced Booking");
		System.out.println("2:	Booking");
		System.out.println("3:	Return");
		System.out.println("_");
	}

	public static void displayShowings() {
		System.out.println("***	Showing Menu	***	\n");
		System.out.println("1:	Display Upcoming Films");
		System.out.println("2:	Return");
		System.out.println("_");
	}
}// end class
