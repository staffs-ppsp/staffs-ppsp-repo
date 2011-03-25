/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;

import java.util.ArrayList;

/**
 * 
 * @author James
 */
public class Customer extends Person {
	// Initialise variables
	private int intCustomerID;
	private String strFirstName;
	private String strLastName;
	private int intAge;
	private String strTelephone;
	private ArrayList<Customer> customers;
	private String strCustomers;
	
	public Customer() {
		
	}

	public Customer(String strTheFirstname, String strTheLastname,
			int intTheAge, String strTheTelephone, int intTheCustomerID) {

		super(strTheFirstname, strTheLastname, intTheAge, strTheTelephone);
		this.intCustomerID = intTheCustomerID;
		this.strFirstName = strTheFirstname;
		this.strLastName = strTheLastname;
		this.intAge = intTheAge;
		this.strTelephone = strTheTelephone;

	}

	public Customer(String _strCustomers) {
		this.strCustomers = _strCustomers;
		customers = new ArrayList<Customer>();
	}

	public int getCustomerID() {
		return intCustomerID;
	}
	
	public void addCustomer(Customer _objCustomer) {
		customers.add(_objCustomer);
	}

	// toString override
	@Override
	public String toString() {
		return "Customer first name: " + strFirstName + " Customer last name: "
				+ strLastName + " Customer age: " + intAge + " "
				+ " Customer Telephone: " + strTelephone + " Customer ID: "
				+ intCustomerID;

	}

}
