package main_package;
//import org.junit.Test;



public class FilmShowingJUnitTest {

    /*@Test*/ public static void main(String[] args) {

	FilmShowing container = new FilmShowing("Showings");
	FilmShowing fs = new FilmShowing(12, 25, "12/12/2011", 1, 6.80);
	FilmShowing empty = new FilmShowing();

	container.add(fs);
	
	System.out.println("Testing Constructor\n" + fs + "\n");

	empty.setIntShowingID(1);
	empty.setIntFilmID(25);
	empty.setIntScreenNum(1);
	empty.setIntPrice(5.60);
	
	System.out.println("Testing Setters\n" + empty + "\n");
	
	container.add(empty);
	
	System.out.println("Testing Getters");
	System.out.println(fs.getIntShowingID());
	System.out.println(fs.getIntFilmID());
	System.out.println(fs.getDateTime());
	System.out.println(fs.getIntScreenNum());
	System.out.println(fs.getDblPrice());
	
	System.out.println("\nTesting getDateTime method");
	System.out.println(fs.getDateTime());
	
	System.out.println("\nTesting toString method");
	System.out.println(fs.toString()+"\n");
	System.out.println(empty.toString());


    }
}
