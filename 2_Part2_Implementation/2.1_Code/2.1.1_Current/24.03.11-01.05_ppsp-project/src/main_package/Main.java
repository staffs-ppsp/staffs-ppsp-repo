package main_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static final double dblVer = 1.1;

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

	static Scanner kybd = new Scanner(System.in);
	static InputStreamReader in = new InputStreamReader(System.in);
	static BufferedReader lineReader = new BufferedReader(in);

	static Seats screen1 = new Seats("Screen 1");
	static FilmShowing showings = new FilmShowing("Showings");
	static Booking bookings = new Booking("Bookings");
	static Staff staff = new Staff("Staff");
	static Film films = new Film("Films");

	public static void main(String[] args) {
		
		Staff stf1 = new Staff("James", "Nightingale", 20, "07123283823", 456,
				"Manager", "jn1", "lalalala");
		
		staff.addStaff(stf1);
		
		Film flm1 = new Film(1, "Paul", 15);
		Film flm2 = new Film(2, "The Exorcist", 18);
		Film flm3 = new Film(3, "Spiderman", 12);
		
		films.addFilm(flm1);
		films.addFilm(flm2);
		films.addFilm(flm3);
	
		FilmShowing fs1 = new FilmShowing(123, flm1.getIntFilmID(), "01/02/2010",
				screen1.getStrScreen(), 4.99);
		FilmShowing fs2 = new FilmShowing(12, flm2.getIntFilmID(), "12/12/2011",
				screen1.getStrScreen(), 6.80);
		FilmShowing fs3 = new FilmShowing(123, flm3.getIntFilmID(), "12/12/2011",
				screen1.getStrScreen(), 4.99);
		
		showings.addFilmShowing(fs1);
		showings.addFilmShowing(fs2);
		showings.addFilmShowing(fs3);

		Customer cst1 = new Customer("Dave", "Russell", 21, "07533475113", 123);

		Booking booking1 = new Booking(1, cst1.getCustomerID(), stf1.getStaffID(),
				flm1.getIntFilmID(), fs1.getDblPrice(), fs1.getDateTime());
		
		bookings.addBooking(booking1);

		// bookings.addBooking(booking1);
		// bookings.showBookings();

		while (boolControl == true) {

			login();
			try {
				intChoice = kybd.nextInt();
				switch (intChoice) {
				case 1:
					System.out.println("Password:");
					strInputPassword = kybd.next();
					if (strInputPassword.equalsIgnoreCase(strAdminPassword)) {
						System.out.println("Success");
						intAttemptCtr = 0; // Reset the attempt counter
						while (intChoice != 0) {
							try {
								adminMenu();
								intChoice = kybd.nextInt();
								switch (intChoice) {
								case 1:
									kybd.reset();
									Film newFilm = new Film();
									System.out.println("Film ID:");
									newFilm.setIntFilmID(kybd.nextInt());
									System.out.println("Film Title:");
									try {
										newFilm.setStrFilmName(lineReader
												.readLine());
									} catch (IOException e) {
										System.out.println("Invalid Entry");
									}
									System.out.println("Film Rating:");
									newFilm.setIntRating(kybd.nextInt());
									films.addFilm(newFilm);
									break;
								case 2:
									kybd.reset();
									Staff newStaff = new Staff();
									newStaff.generateStaffID();
									System.out.println("Role: ");
									newStaff.setStrRole(lineReader.readLine());
									System.out.println("First Name: ");
									newStaff.setStrFirstName(lineReader
											.readLine());
									System.out.println("Last Name: ");
									newStaff.setStrLastName(lineReader
											.readLine());
									System.out.println("Telephone Number: ");
									newStaff.setStrTelephone(lineReader
											.readLine());
									System.out.println("Age: ");
									newStaff.setIntAge(kybd.nextInt());
									System.out.println("Set Username: ");
									newStaff.setStrUsername(lineReader
											.readLine());
									System.out.println("Set Password: ");
									newStaff.setStrPassword(lineReader
											.readLine());
									staff.addStaff(newStaff);
									break;
								case 3:
									staff.viewStaff();
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
					else {
						intAttemptCtr++;
						System.out.println("\nUnsuccessful Attempt #"
								+ intAttemptCtr);
						if (intAttemptCtr == 3) {
							System.out
									.println("3 Consecutive Unsuccessful Attempts.. Exiting Program");
							boolControl = false;
						}
					}
					break; // end case 1
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
											// DO MAKE ADVANCED BOOKING
											break;
										case 2:
											kybd.reset();
											// DO MAKE BOOKING
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
				}
			}// end switch
			catch (Exception e) {
				System.out.println("Invalid Entry");
				kybd.nextLine();
			}// end catch
		}// end while
	}// end main

	public static void login() {
		System.out
				.println("***	Cinema Login System Ver. " + dblVer + "	***	\n");
		System.out.println("1:	Admin");
		System.out.println("2:	User");
	}

	public static void adminMenu() {
		System.out.println("***	Admin Menu	***	\n");
		System.out.println("1:	Add Film");
		System.out.println("2:	Add Staff");
		System.out.println("3:	View Staff Records");
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
