/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;
import java.util.*;
/**
 *
 * @author James
 */
public class Booking {

      //Create array lists for customer and staff
      private ArrayList <Customer> theCustomers = new ArrayList <Customer>();
      private ArrayList <Staff> theStaff = new ArrayList <Staff>();

      //Add Customer to array list
public boolean addCustomer(Customer objTheCustomer){

    theCustomers.add(objTheCustomer);

    return true;


}
    //Add Staff to array list
public boolean addStaff(Staff objStaff){

    theStaff.add(objStaff);

    return true;
}
    //Display Customer details
public void displayCustomerDetails(){

     for (int i = 0; i<theCustomers.size(); i++){
         System.out.println(theCustomers.get(i).toString());
     }

  }
  //Display Staff details
public void displayStaffDetails(){

    for (int i = 0; i<theStaff.size(); i++){
        System.out.println(theStaff.get(i).toString());
    }
}



}
