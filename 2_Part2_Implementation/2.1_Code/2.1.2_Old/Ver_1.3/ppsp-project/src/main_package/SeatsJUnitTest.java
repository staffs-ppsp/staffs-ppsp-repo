package main_package;

//import org.junit.Test;


public class SeatsJUnitTest {
    
    /*@Test*/ public static void main (String [] args) throws Exception {
	Seats screen1 = new Seats("Screen 1");
	
	System.out.println("Testing method addSeat");
	screen1.addSeat(Row.A, Column.J, 1);
	screen1.addSeat(Row.D, Column.O, 2);
	screen1.addSeat(Row.G, Column.N, 3);
	screen1.addSeat(Row.I, Column.L, 4);
	screen1.addSeat(Row.C, Column.K, 5);
	screen1.addSeat(Row.E, Column.Q, 6);
	screen1.addSeat(Row.F, Column.J, 7);
	screen1.addSeat(Row.A, Column.K, 8);
	screen1.addSeat(Row.I, Column.M, 9);
	screen1.addSeat(Row.H, Column.P, 10);
	screen1.addSeat(Row.H, Column.Q, 10);
	System.out.println("Testing method toString()\n" + screen1);
	
	System.out.println("Testing method listByBooking()");
	screen1.listByBooking();
	
	System.out.println("Testing getters");
	System.out.println(screen1.getIntBookingID());
	System.out.println(screen1.getIntShowingID());
	System.out.println(screen1.getStrScreen());

    }

}
