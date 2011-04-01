package main_package;

//import org.junit.Test;

public class SeatsJUnitTest {

	/* @Test */public static void main(String[] args) throws Exception {
		Seats screen1 = new Seats("Screen 1");
		
		Seats booking = new Seats(1, 1, 1, 1, 1, "12/12/12", 2, Row.A, Column.J);

		System.out.println("Testing method addSeat");
		screen1.addSeat(booking);
//		screen1.addSeat(Row.A, Column.J, 1, 1);
//		screen1.addSeat(Row.D, Column.O, 2, 2);
//		screen1.addSeat(Row.G, Column.N, 3, 3);
//		screen1.addSeat(Row.I, Column.L, 4, 1);
//		screen1.addSeat(Row.C, Column.K, 5, 2);
//		screen1.addSeat(Row.E, Column.Q, 6, 1);
//		screen1.addSeat(Row.F, Column.J, 7, 1);
//		screen1.addSeat(Row.A, Column.K, 8, 4);
//		screen1.addSeat(Row.I, Column.M, 9, 3);
//		screen1.addSeat(Row.H, Column.P, 10, 1);
//		screen1.addSeat(Row.H, Column.Q, 10, 4);
		System.out.println("Testing method toString()\n" + screen1);

		System.out.println("Testing method listByBooking()");
		screen1.listByBooking();

		System.out.println("Testing getters");
		System.out.println(screen1.getIntBookingID());
		System.out.println(screen1.getIntShowingID());
		System.out.println(screen1.getStrScreen());

	}

}
