/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;

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

	public Customer(String strTheFirstname, String strTheLastname,
			int intTheAge, String strTheTelephone, int intTheCustomerID) {

		super(strTheFirstname, strTheLastname, intTheAge, strTheTelephone);
		this.intCustomerID = intTheCustomerID;
		this.strFirstName = strTheFirstname;
		this.strLastName = strTheLastname;
		this.intAge = intTheAge;
		this.strTelephone = strTheTelephone;

	}

	public int getCustomerID() {
		return intCustomerID;
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
