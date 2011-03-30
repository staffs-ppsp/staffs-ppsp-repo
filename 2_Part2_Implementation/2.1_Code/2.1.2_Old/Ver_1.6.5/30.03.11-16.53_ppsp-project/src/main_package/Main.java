package main_package;

/**
 * @author David Russell, James Nightingale
 * @version 1.7
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	// double for displaying the version of the software in the menu
	static final double dblVer = 1.7;

	// integer used for input and controlling menu drivers
	static int intChoice;

	// two values used for case statements in the menu driver
	static String strCase;
	static int intCase;
	static double dblCase;

	// Strings to assign the value of input user name and password
	static String strInputUserName;
	static String strInputPassword;

	// Strings identifying the admin and user usernames and passwords
	static final String strAdminUsername = "admin";
	static final String strAdminPassword = "admin";
	static final String strUsername = "user";
	static final String strPassword = "user";

	// Double to use to set the percentage different for premium seats
	static double dblPremium = 1.5;

	// static number of attempts for logins and the counter for this value
	static final int intAttempts = 3;
	static int intAttemptCtr = 0;

	// a boolean control value and an escape value
	static boolean boolControl = true;
	static int ageControl = 1;
	static int escape = 1;

	// declaring new scanner, inputstreamreader and buffered reader objects for
	// input
	static Scanner kybd = new Scanner(System.in);
	static InputStreamReader in = new InputStreamReader(System.in);
	static BufferedReader lineReader = new BufferedReader(in);

	// declaring new cinema objects
	static Seats screen1 = new Seats("Screen 1");
	static Seats screen2 = new Seats("Screen 2");
	static Seats screen3 = new Seats("Screen 3");
	static FilmShowing showings = new FilmShowing("Showings");
	static Staff staff = new Staff("Staff");
	static Film films = new Film("Films");
	static Customer customers = new Customer("Customers");
	static Booking bookings = new Booking("Bookings");

	// constructing a new staff object
	static Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823",
			"Manager", "jn1", "lalalala");

	// begin main class
	public static void main(String[] args) {

		// add a staff member to the list of staff
		staff.addStaff(stf1);

		// constructing new film objects
		Film flm1 = new Film("Paul", 15);
		Film flm2 = new Film("The Exorcist", 18);
		Film flm3 = new Film("Spiderman", 12);

		// adding the films to the films collection
		films.addFilm(flm1);
		films.addFilm(flm2);
		films.addFilm(flm3);

		// constructing new instances of FilmShowing
		FilmShowing fs1 = new FilmShowing(flm1, "27/03/2011", screen1, 6.99);
		FilmShowing fs2 = new FilmShowing(flm2, "27/03/2011", screen2, 7.99);
		FilmShowing fs3 = new FilmShowing(flm3, "27/03/2011", screen3, 5.99);
		FilmShowing fs4 = new FilmShowing(flm1);
		fs4.setIntPrice(1.55);
		fs4.setStrScreen("Screen 2");

		// adding the showings to the showings collection
		showings.addFilmShowing(fs1);
		showings.addFilmShowing(fs2);
		showings.addFilmShowing(fs3);
		showings.addFilmShowing(fs4);

		// constructing a new customer
		Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113");

		// begin infinite loop while escape character is 1
		while (escape == 1) {
			// displays the login menu
			login();
			try {
				// enters a try/catch block for inputting which login to use
				intChoice = kybd.nextInt();
				switch (intChoice) {
				// first case, login admin
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
								case 3:
									dblPremium = premiumSeatPrice();
									System.out.println(dblPremium);
									break;
								case 0:
									break;
								default:
									// default message to display if the user
									// inputs an unrecognised character
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
					}
					// end if
					break; // end case 1
				// second case, login users
				case 2:
					if (loginUserFunction() == 1) {
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
											kybd.reset(); // CHANGE
											advancedBooking();
											break;
										case 2:
											kybd.reset();
											makeBooking(); // CHANGE
											break;
										case 3:
											System.out.println(screen1);
											System.out.println(screen2);
											System.out.println(screen3);
											break;
										default:
											System.out
													.println("Unrecognised Command: "
															+ intChoice + "\n");
											kybd.nextLine();
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
									bookings.showBookings();
									break;
								case 4:
									break;
								default:
									System.out.println("Unrecognised Command: "
											+ intChoice + "\n");
									kybd.nextLine();
								}// end switch
							} catch (Exception e) {
								System.out.println("Invalid Entry");
								kybd.nextLine();
							}// end catch
						}// end while
					}// end if
					break;
				default:
					System.out.println("Unrecognised Command: " + intChoice
							+ "\n");
					kybd.nextLine();
					break;
				}

			}// end switch
			catch (Exception e) {
				System.out.println("Invalid Entry");
				kybd.nextLine();
			}// end catch
		}
		// end while
	}

	// end main

	/**
	 * function to login admin
	 * 
	 * @return if the user attempts to login as an admin 3 times unsuccessfully
	 *         escape is returned which exits the program otherwise 1 is
	 *         returned which indicates a success, or 3 which indicates an
	 *         unsuccessful attempt
	 */
	public static int loginAdminFunction() {
		System.out.println("User Name:");
		strInputUserName = kybd.next();
		kybd.reset();
		System.out.println("Password:");
		strInputPassword = kybd.next();
		if (strInputUserName.equalsIgnoreCase(strAdminUsername)
				&& strInputPassword.equalsIgnoreCase(strAdminPassword)) {
			System.out.println("Success");
			intAttemptCtr = 0; // Reset the attempt counter
			return 1;
		} else {
			intAttemptCtr++;
			System.out.println("\nUnsuccessful Attempt #" + intAttemptCtr);
			if (intAttemptCtr == 3) {
				System.out
						.println("3 Consecutive Unsuccessful Attempts.. Exiting Program");
				return escape = 2;
			}
		}
		return 3;
	}

	/**
	 * function to allow the admin to adjust the price of the cost percentage of
	 * premium seats
	 * 
	 * @return returns the new percentage
	 */
	public static double premiumSeatPrice() {
		System.out.println("Current Premium Percentage: " + dblPremium);
		System.out.println("Set New Premium? (y/n)");
		try {
			strCase = lineReader.readLine();
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}
		switch (strCase.toLowerCase().charAt(0)) {
		case 'y':
			try {
				System.out.println("Enter New Percentage:");
				dblCase = kybd.nextDouble();
				return dblCase;
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
			break;
		case 'n':
			break;
		default:
			break;
		}
		return dblPremium;
	}

	/**
	 * function to login user
	 * 
	 * @return if the user attempts to login as an admin 3 times unsuccessfully
	 *         escape is returned which exits the program otherwise 1 is
	 *         returned which indicates a success, or 3 which indicates an
	 *         unsuccessful attempt
	 */
	public static int loginUserFunction() {
		System.out.println("User Name:");
		strInputUserName = kybd.next();
		kybd.reset();
		System.out.println("Password:");
		strInputPassword = kybd.next();
		if (strInputUserName.equalsIgnoreCase(strUsername)
				&& strInputPassword.equalsIgnoreCase(strPassword)) {
			System.out.println("Success");
			intAttemptCtr = 0; // Reset the attempt counter
			return 1;
		} else {
			intAttemptCtr++;
			System.out.println("\nUnsuccessful Attempt #" + intAttemptCtr);
			if (intAttemptCtr == 3) {
				System.out
						.println("3 Consecutive Unsuccessful Attempts.. Exiting Program");
				return escape = 2;
			}
			return 3;
		}
	}

	/**
	 * function to add a film
	 * 
	 * @return returns true if the film was added successfully
	 */
	public static boolean addFilmFunction() {
		Film newFilm = new Film();
		System.out.println("Film Title:");
		try {
			newFilm.setStrFilmName(lineReader.readLine());
		} catch (IOException e) {
			System.out.println("Invalid Entry");
		}
		System.out.println("Film Rating:");
		newFilm.setIntRating(kybd.nextInt());
		films.addFilm(newFilm);
		FilmShowing showing = new FilmShowing();
		showing.addFilm(newFilm);
		return true;
	}

	/**
	 * 
	 * @return returns false if the customer is under-age, the number of seats
	 *         requested exceeds the maximum number of allowed seats or if the
	 *         entered number of seats is 0 or if the entered showing ID is not
	 *         found
	 * @throws Exception
	 *             is thrown because the BufferedReader object requires to be
	 *             surrounded by a try/catch block and having the method throw
	 *             it reduced complexity
	 */
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
		kybd.reset();
		intCase = kybd.nextInt();
		if (showings.getByID(intCase) == 0) {
			System.out.println("Showing not found");
			return false;
		} else {
			newBooking.setIntShowingID(showings.getByID(intCase));
			newBooking.setIntFilmRating(showings.getByRating(intCase));
			newBooking.setDblTotalPrice(showings.getByPrice(intCase));
		}
		if (customer.getIntAge() < newBooking.getIntFilmRating()) {
			System.out.println("Customer Under Age");
			return false;
		} else {
			Seats seatBooking = new Seats(newBooking);
			System.out.println("Number of Seats: ");
			intCase = kybd.nextInt();
			newBooking
					.setDblTotalPrice(newBooking.getDblTotalPrice() * intCase);
			if (intCase > 10 || intCase <= 0) {
				System.out
						.println("Exceeds maximum number of seats per booking");
				return false;
			}
			if (intCase <= 0) {
				System.out.println("Number of seats must be greater than 0");
				return false;
			}
			seatBooking.setIntNumSeats(intCase);
			System.out.println("Row: (A - I)");
			strCase = lineReader.readLine();
			switch (strCase.toUpperCase().charAt(0)) {
			case 'A':
				seatBooking.setObjRow(Row.A);
				break;
			case 'B':
				seatBooking.setObjRow(Row.B);
				break;
			case 'C':
				seatBooking.setObjRow(Row.C);
				break;
			case 'D':
				seatBooking.setObjRow(Row.D);
				break;
			case 'E':
				seatBooking.setObjRow(Row.E);
				break;
			case 'F':
				seatBooking.setObjRow(Row.F);
				break;
			case 'G':
				seatBooking.setObjRow(Row.G);
				break;
			case 'H':
				// automatically adjusts the price of premium rows H and I by
				// 1.5
				seatBooking.setObjRow(Row.H);
				newBooking
						.setDblTotalPrice(newBooking.getDblTotalPrice() * 1.5);
				break;
			case 'I':
				seatBooking.setObjRow(Row.I);
				newBooking
						.setDblTotalPrice(newBooking.getDblTotalPrice() * 1.5);
				break;
			default:
				System.out.println("Invalid Seat");
				return false;
			}
			System.out.println("Column: (0 - 15)");
			intCase = kybd.nextInt();
			switch (intCase) {
			case 0:
				seatBooking.setObjColumn(Column.J);
				break;
			case 1:
				seatBooking.setObjColumn(Column.K);
				break;
			case 2:
				seatBooking.setObjColumn(Column.L);
				break;
			case 3:
				seatBooking.setObjColumn(Column.M);
				break;
			case 4:
				seatBooking.setObjColumn(Column.N);
				break;
			case 5:
				seatBooking.setObjColumn(Column.O);
				break;
			case 6:
				seatBooking.setObjColumn(Column.P);
				break;
			case 7:
				seatBooking.setObjColumn(Column.Q);
				break;
			case 8:
				seatBooking.setObjColumn(Column.R);
				break;
			case 9:
				seatBooking.setObjColumn(Column.S);
				break;
			case 10:
				seatBooking.setObjColumn(Column.T);
				break;
			case 11:
				seatBooking.setObjColumn(Column.U);
				break;
			case 12:
				seatBooking.setObjColumn(Column.V);
				break;
			case 13:
				seatBooking.setObjColumn(Column.Q);
				break;
			case 14:
				seatBooking.setObjColumn(Column.X);
				break;
			case 15:
				seatBooking.setObjColumn(Column.Y);
				break;
			default:
				System.out.println("Invalid Seat");
				return false;
			}
			bookings.addBooking(newBooking);
			screen1.addSeat(seatBooking);
			System.out.println(newBooking);
			System.out.println(screen1);
			return true;
		}
	}

	/**
	 * Exactly the same function as advanced booking, except the details of the
	 * customer are not collected
	 * 
	 * @return returns false if the customer is under-age, the number of seats
	 *         requested exceeds the maximum number of allowed seats or if the
	 *         entered number of seats is 0 or if the entered showing ID is not
	 *         found
	 * @throws Exception
	 *             is thrown because the BufferedReader object requires to be
	 *             surrounded by a try/catch block and having the method throw
	 *             it reduced complexity
	 */
	public static boolean makeBooking() throws Exception {
		Booking newBooking = new Booking(stf1);
		System.out.println("ID Of Showing");
		kybd.reset();
		showings.showShowings();
		System.out.println("ID Of Showing:");
		intCase = kybd.nextInt();
		if (showings.getByID(intCase) == 0) {
			System.out.println("Showing not found");
			return false;
		} else {
			newBooking.setIntShowingID(showings.getByID(intCase));
			newBooking.setIntFilmRating(showings.getByRating(intCase));
			dblCase = kybd.nextDouble();
			newBooking.setDblTotalPrice(showings.getByPrice(intCase));
		}
		Seats seatBooking = new Seats(newBooking);
		System.out.println("Number of Seats: ");
		intCase = kybd.nextInt();
		if (intCase > 10) {
			System.out.println("Exceeds maximum number of seats per booking");
			return false;
		}
		if (intCase <= 0) {
			System.out.println("Number of seats must be greater than 0");
			return false;
		}
		seatBooking.setIntNumSeats(intCase);
		System.out.println("Row: (A - I)");
		strCase = lineReader.readLine();
		switch (strCase.toUpperCase().charAt(0)) {
		case 'A':
			seatBooking.setObjRow(Row.A);
			break;
		case 'B':
			seatBooking.setObjRow(Row.B);
			break;
		case 'C':
			seatBooking.setObjRow(Row.C);
			break;
		case 'D':
			seatBooking.setObjRow(Row.D);
			break;
		case 'E':
			seatBooking.setObjRow(Row.E);
			break;
		case 'F':
			seatBooking.setObjRow(Row.F);
			break;
		case 'G':
			seatBooking.setObjRow(Row.G);
			break;
		case 'H':
			seatBooking.setObjRow(Row.H);
			newBooking.setDblTotalPrice(newBooking.getDblTotalPrice() * 1.5);
			break;
		case 'I':
			seatBooking.setObjRow(Row.I);
			newBooking.setDblTotalPrice(newBooking.getDblTotalPrice() * 1.5);
			break;
		default:
			System.out.println("Invalid Seat");
			return false;
		}
		System.out.println("Column: (0 - 15)");
		intCase = kybd.nextInt();
		switch (intCase) {
		case 0:
			seatBooking.setObjColumn(Column.J);
			break;
		case 1:
			seatBooking.setObjColumn(Column.K);
			break;
		case 2:
			seatBooking.setObjColumn(Column.L);
			break;
		case 3:
			seatBooking.setObjColumn(Column.M);
			break;
		case 4:
			seatBooking.setObjColumn(Column.N);
			break;
		case 5:
			seatBooking.setObjColumn(Column.O);
			break;
		case 6:
			seatBooking.setObjColumn(Column.P);
			break;
		case 7:
			seatBooking.setObjColumn(Column.Q);
			break;
		case 8:
			seatBooking.setObjColumn(Column.R);
			break;
		case 9:
			seatBooking.setObjColumn(Column.S);
			break;
		case 10:
			seatBooking.setObjColumn(Column.T);
			break;
		case 11:
			seatBooking.setObjColumn(Column.U);
			break;
		case 12:
			seatBooking.setObjColumn(Column.V);
			break;
		case 13:
			seatBooking.setObjColumn(Column.Q);
			break;
		case 14:
			seatBooking.setObjColumn(Column.X);
			break;
		case 15:
			seatBooking.setObjColumn(Column.Y);
			break;
		default:
			System.out.println("Invalid Seat");
			return false;
		}
		bookings.addBooking(newBooking);
		screen1.addSeat(seatBooking);
		System.out.println(newBooking);
		System.out.println(screen1);
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
		System.out.println("3:	Adjust Percentage for Premium Seats");
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
		System.out.println("3:	Show Bookings");
		System.out.println("4:	Return");
		System.out.println("_");
	}

	public static void displayShowings() {
		System.out.println("***	Showing Menu	***	\n");
		System.out.println("1:	Display Upcoming Films");
		System.out.println("2:	Return");
		System.out.println("_");
	}
}// end class

