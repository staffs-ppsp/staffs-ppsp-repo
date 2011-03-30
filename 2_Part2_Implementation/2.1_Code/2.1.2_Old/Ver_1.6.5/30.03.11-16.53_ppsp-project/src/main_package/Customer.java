package main_package;

import java.util.ArrayList;

/**
 * @author James Nightingale
 * @version 1.7
 */
public class Customer extends Person {
	// Initialise variables
	private int intCustomerID;
	private String strFirstName;
	private String strLastName;
	private int intAge;
	private String strTelephone;
	private ArrayList<Customer> customers;
	private static int psintCustomerID;

	public Customer() {

	}

	public Customer(String strTheFirstname, String strTheLastname,
			int intTheAge, String strTheTelephone) {
		super(strTheFirstname, strTheLastname, intTheAge, strTheTelephone);
		this.intCustomerID = generateCustomerID();
		this.strFirstName = strTheFirstname;
		this.strLastName = strTheLastname;
		this.intAge = intTheAge;
		this.strTelephone = strTheTelephone;

	}

	public Customer(String _strCustomers) {
		customers = new ArrayList<Customer>();
	}

	public int getCustomerID() {
		return intCustomerID;
	}

	public void addCustomer(Customer _objCustomer) {
		customers.add(_objCustomer);
	}

	public int generateCustomerID() {
		psintCustomerID++;
		intCustomerID = psintCustomerID;
		return intCustomerID;
	}

	// toString override
	@Override
	public String toString() {
		return "Customer ID: " + intCustomerID + "\nFirst Name: "
				+ strFirstName + "\nLast Name: " + strLastName + "\nAge: "
				+ intAge + "\nCustomer Telephone: " + strTelephone;
	}
}
