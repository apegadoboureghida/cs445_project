package edu.iit.cs445.s2016.delectable.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenericCustomerTest {
	
	GenericCustomer customer;

	@Before
	public void setUp() throws Exception {
		customer = new GenericCustomer();
	}

	@Test
	public void testName() {
		customer.setName("name");
		
		assertTrue(customer.name() == "name");
	}

	@Test
	public void testEmail() {
		customer.setEmail("email");
		
		assertTrue(customer.email() == "email");	
	}

	@Test
	public void testPhone() {
		customer.setPhone("phone");
		
		assertTrue(customer.phone() == "phone");	
	}

	@Test
	public void testIsNil() {
		assertFalse(customer.isNil());
	}

	@Test
	public void testMatchesCustomer() {
		customer.setName("name");
		customer.setEmail("email");
		customer.setPhone("phone");
		assertTrue(customer.matchesCustomer(customer));
		
		assertFalse(customer.matchesCustomer(new GenericCustomer()));
	}
}
