package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaffTest {

	Staff staff = new Staff("Staff");
	Staff testStaff;
	Staff stf1 = new Staff("Amanda", "Patterson", 21, "01010 929292",
			"Head Honcho", "ap1", "ap1");

	@Test
	public final void testGetStrFirstName() {
		assertNotNull(stf1.getStrFirstName());
	}

	@Test
	public final void testSetStrFirstName() {
		stf1.setStrFirstName("Manda");
		assertNotNull(stf1.getStrFirstName());
	}

	@Test
	public final void testGetStrLastName() {
		assertNotNull(stf1.getStrLastName());
	}

	@Test
	public final void testSetStrLastName() {
		stf1.setStrLastName("patterson");
		assertNotNull(stf1.getStrLastName());
	}

	@Test
	public final void testGetIntAge() {
		assertNotNull(stf1.getIntAge());
	}

	@Test
	public final void testSetIntAge() {
		stf1.setIntAge(22);
		assertNotNull(stf1.getIntAge());
	}

	@Test
	public final void testGetStrTelephone() {
		assertNotNull(stf1.getStrTelephone());
	}

	@Test
	public final void testSetStrTelephone() {
		stf1.setStrTelephone("01010 124123");
		assertNotNull(stf1.getStrUsername());
	}

	@Test
	public final void testStaff() {
		testStaff = new Staff();
		assertNotNull(testStaff);
	}

	@Test
	public final void testStaffString() {
		testStaff = new Staff("Staff");
		assertNotNull(testStaff);
	}

	@Test
	public final void testStaffStringStringIntStringIntStringStringString() {
		testStaff = new Staff("Scott", "Dennison", 20, "01010 231231", "Crew Member", "sd1", "sd1");
	}

	@Test
	public final void testAddStaff() {
		staff.addStaff(stf1);
	}

	@Test
	public final void testViewStaff() {
		staff.viewStaff();
	}

	@Test
	public final void testGetStaffID() {
		assertNotNull(stf1.getStaffID());
	}

	@Test
	public final void testGenerateStaffID() {
		assertNotNull(stf1.generateStaffID());
	}

	@Test
	public final void testGetStrRole() {
		assertNotNull(stf1.getStrRole());
	}

	@Test
	public final void testSetStrRole() {
		stf1.setStrRole("THE BOSS");
		assertNotNull(stf1.getStrRole());
		System.out.println(stf1.getStrRole());
	}

	@Test
	public final void testGetStrUsername() {
		assertNotNull(stf1.getStrUsername());
	}

	@Test
	public final void testSetStrUsername() {
		stf1.setStrUsername("ap_m1");
		assertNotNull(stf1.getStrUsername());
		System.out.println(stf1.getStrUsername());
	}

	@Test
	public final void testGetStrPassword() {
		assertNotNull(stf1.getStrPassword());
	}

	@Test
	public final void testSetStrPassword() {
		stf1.setStrPassword("password");
		assertNotNull(stf1.getStrPassword());
		System.out.println(stf1.getStrPassword());
	}

	@Test
	public final void testToString() {
		System.out.println(stf1);
	}

}
