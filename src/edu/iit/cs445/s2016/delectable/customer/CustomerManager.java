package edu.iit.cs445.s2016.delectable.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements BoundaryCustomerInterface {

	 private static List<Customer> customers = new ArrayList<Customer>();

	
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public List<Customer> getAllCustomersByKey(String queryString) {
		List<Customer> tempCustomer = new ArrayList<Customer>();
		
		for(Customer temp:customers){
			if(temp.name().contains(queryString) || temp.email().contains(queryString) || temp.phone().contains(queryString)){
				tempCustomer.add(temp);
			}
		}
		return tempCustomer;
	}

	@Override
	public Customer getMenuItemDetail(int cid) {
		for(Customer temp : customers){
			if(temp.id() == cid){
				return temp;
			}
		}
		return new NullCustomer();
	}

	@Override
	public void updateCustomerOrders() {
		// TODO Auto-generated method stub
		
	}

}
