package main_package;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	
	Customer customers = new Customer("Customers");
	Customer testArray;
	Person testCust;
	Customer cust1 = new Customer("Dave", "Russell", 21, "01232 123123");
	Customer cust2 = new Customer();

	@Test
	public final void testCustomer() {
		assertNotNull(testCust = new Customer());
	}

	@Test
	public final void testCustomerStringStringIntString() {
		assertNotNull(testCust = new Customer("James", "Nightingale", 20, "01232 123123"));
	}

	@Test
	public final void testCustomerString() {
		assertNotNull(testArray = new Customer("Customers"));
	}

	@Test
	public final void testGetCustomerID() {
		assertNotNull(cust1.getCustomerID());
	}

	@Test
	public final void testAddCustomer() {
		customers.addCustomer(cust1);
	}

	@Test
	public final void testGenerateCustomerID() {
		assertNotNull(cust2.generateCustomerID());
	}

	@Test
	public final void testToString() {
		System.out.println(cust1);
	}

}
