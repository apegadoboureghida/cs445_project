package edu.iit.cs445.s2016.delectable.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerManagerTest {

	CustomerManager manager;
	
	@Before
	public void setUp() throws Exception {
		manager = new CustomerManager();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		
		customer.setName("test1");
		customer.setEmail("email1");
		customer.setPhone("phone1");
		
		Customer customer4 = new Customer();
		
		customer.setName("test2");
		customer.setEmail("email2");
		customer.setPhone("phone2");
		
		
		Customer customer2 = manager.createCustomer(customer);
		
		assertTrue(customer2.matchesCustomer(customer));
		
		Customer customer3 = manager.createCustomer(customer);
		
		assertTrue(customer3.matchesCustomer(customer));
		
		Customer customer5 = manager.createCustomer(customer4);
		
		assertTrue(customer5.matchesCustomer(customer4));


	}

	@Test
	public void testGetAllCustomers() {
		Customer customer = new Customer();
		
		customer.setName("test1");
		customer.setEmail("email1");
		customer.setPhone("phone1");
		
		manager.createCustomer(customer);

		assertTrue(manager.getAllCustomers().size() >0);
	}

	@Test
	public void testGetAllCustomersByKey() {
		GenericCustomer customer = new GenericCustomer();
		
		customer.setName("alfonso");
		customer.setEmail("email1");
		customer.setPhone("phone1");
		
		Customer result = manager.createCustomer(customer);
		
		assertTrue(manager.getAllCustomersByKey("alfonso").get(0).matchesCustomer(result));
	}

	@Test
	public void testGetCustomerDetail() {
		GenericCustomer customer = new GenericCustomer();
		
		customer.setName("alvaro");
		customer.setEmail("email1");
		customer.setPhone("phone1");
		
		Customer result = manager.createCustomer(customer);
		
		assertTrue(manager.getCustomerDetail(result.id).matchesCustomer(customer));
	}
}
