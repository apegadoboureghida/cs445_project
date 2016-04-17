package edu.iit.cs445.s2016.delectable.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerManager implements BoundaryCustomerInterface {

	 private static Map<Integer,Customer> customers = new HashMap<Integer,Customer>();

	@Override
	public Customer createCustomer(GenericCustomer entity) {
		
		for(Customer temp : customers.values()){
			if(temp.matchesCustomer(entity)){
				entity = temp;
				return temp;
			}
		}
		Customer newCustomer = new Customer();
		newCustomer.setEmail(entity.email());
		newCustomer.setName(entity.name());
		newCustomer.setPhone(entity.phone());
		
		//entity.createID();
		customers.put(newCustomer.id, newCustomer);

		return newCustomer;
	}
	
	@Override
	public Collection<Customer> getAllCustomers() {
		return customers.values();
	}

	@Override
	public List<Customer> getAllCustomersByKey(String queryString) {
		List<Customer> tempCustomer = new ArrayList<Customer>();
		queryString = queryString.toLowerCase();
		for(Customer temp: customers.values()){
			if(temp.name().toLowerCase().contains(queryString) 
					|| temp.email().toLowerCase().contains(queryString) 
					|| temp.phone().toLowerCase().contains(queryString))
			{
				tempCustomer.add(temp);
			}
		}
		return tempCustomer;
	}

	@Override
	public Customer getCustomerDetail(int cid) {

		if(customers.containsKey(cid)){
			return customers.get(cid);
		}
		return new NullCustomer();
	}

	@Override
	public void updateCustomerOrders() {
		// TODO Auto-generated method stub
		
	}
}
