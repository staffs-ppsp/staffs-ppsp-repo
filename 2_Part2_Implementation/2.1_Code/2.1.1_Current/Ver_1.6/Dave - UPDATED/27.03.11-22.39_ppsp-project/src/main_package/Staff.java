/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author James
 */
public class Staff extends Person {
	// Initialise variables
	private int intStaffID;
	private String strRole;
	private String strUsername;
	private String strPassword;
	private String strFirstName;
	private String strLastName;
	private int intAge;
	private String strTelephone;
	private ArrayList<Staff> staff;
	private Random random;

	public Staff() {

	}

	public Staff(String _strStaff) {
		staff = new ArrayList<Staff>();
	}

	public Staff(String strTheFirstname, String strTheLastname, int intTheAge,
			String strTheTelephone, int intTheStaffID, String strTheRole,
			String strTheUsername, String strThePassword) {
		strFirstName = strTheFirstname;
		strLastName = strTheLastname;
		intAge = intTheAge;
		strTelephone = strTheTelephone;
		intStaffID = intTheStaffID;
		strRole = strTheRole;
		strUsername = strTheUsername;
		strPassword = strThePassword;

	}

	public void addStaff(Staff _objStaffMember) {
		staff.add(_objStaffMember);
	}

	public void viewStaff() {
		for (Staff s : staff) {
			System.out.println(s);
		}
	}

	public int getStaffID() {
		return intStaffID;
	}

	public void generateStaffID() {
		random = new Random();
		this.intStaffID = random.nextInt(1000);
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	public String getStrUsername() {
		return strUsername;
	}

	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public int getIntAge() {
		return intAge;
	}

	public void setIntAge(int intAge) {
		this.intAge = intAge;
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

	public String getStrTelephone() {
		return strTelephone;
	}

	public void setStrTelephone(String strTelephone) {
		this.strTelephone = strTelephone;
	}

	// toString override
	@Override
	public String toString() {
		return "\nStaff ID: " + intStaffID + "\nFirst Name: " + strFirstName
				+ "\nLast Name: " + strLastName + "\nAge: " + intAge + " "
				+ "\nTelephone: " + strTelephone + "\nStaff Role: " + strRole
				+ "\nStaff Username: " + strUsername + "\nStaff Password: "
				+ strPassword;
	}

}
