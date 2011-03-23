/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main_package;

/**
 *
 * @author James
 */
public class Staff extends Person{
      //Initialise variables
      private int intStaffID;
      private String strRole;
      private String strUsername;
      private String strPassword;
      private String strFirstName;
      private String strLastName;
      private int intAge;
      private String strTelephone;

      public Staff (String strTheFirstname, String strTheLastname, int intTheAge, String strTheTelephone, int intTheStaffID, String strTheRole,
              String strTheUsername, String strThePassword){

          super(strTheFirstname, strTheLastname, intTheAge, strTheTelephone);

          intStaffID = intTheStaffID;
          strRole = strTheRole;
          strUsername = strTheUsername;
          strPassword = strThePassword;

          strFirstName = strTheFirstname;
          strLastName = strTheLastname;
          intAge = intTheAge;
          strTelephone = strTheTelephone;

     }
     //toString overide
public String toString()  {
        String s = "Staff first name: " + strFirstName + " Staff last name: " +strLastName + " Staff age: " + intAge + " "
              + " Staff Telephone: " + strTelephone + " Staff ID: " + intStaffID + " Staff Role: " + strRole + " Staff Username: " + strUsername
              + " Staff Password: " + strPassword;
             
        return s;
    }

}
