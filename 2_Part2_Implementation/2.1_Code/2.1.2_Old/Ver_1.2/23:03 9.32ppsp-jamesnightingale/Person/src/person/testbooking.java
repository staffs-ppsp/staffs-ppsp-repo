/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

/**
 *
 * @author James
 */
public class testbooking {

    public static void main(String[] args){
        //Create new booking
        Booking objB1 = new Booking();

        //Create new customer
        Customer objC1 = new Customer("Michael", "Wright", 21, "07213827635", 1234);

        //Create new staff
        Staff objS1 = new Staff("Rob", "Simpson", 19, "07826362517", 244, "Cashier", "rs003349", "rsCASH");

        //Add customer to array
        objB1.addCustomer(objC1);

        //Add staff to array
        objB1.addStaff(objS1);

        //Display Customer details
        objB1.displayCustomerDetails();

       //Display Customer details
        objB1.displayStaffDetails();

}
}
