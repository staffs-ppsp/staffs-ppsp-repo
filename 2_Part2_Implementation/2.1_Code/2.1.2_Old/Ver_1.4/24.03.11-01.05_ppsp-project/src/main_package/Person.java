/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;

/**
 * 
 * @author James
 */
public abstract class Person {

	// Initialise variables
	private String strFirstName;
	private String strLastName;
	private int intAge;
	private String strTelephone;
	
	public Person() {
		
	}

	public Person(String strTheFirstName, String strTheLastName, int intTheAge,
			String strTheTelephone) {
		strFirstName = strTheFirstName;
		strLastName = strTheLastName;
		intAge = intTheAge;
		strTelephone = strTheTelephone;

	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public int getIntAge() {
		return intAge;
	}

	public void setIntAge(int intAge) {
		this.intAge = intAge;
	}

	public String getStrTelephone() {
		return strTelephone;
	}

	public void setStrTelephone(String strTelephone) {
		this.strTelephone = strTelephone;
	}
}
