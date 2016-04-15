package edu.iit.cs445.s2016.delectable.customer;

import java.util.Collection;


public interface BoundaryCustomerInterface {
    
	Customer createCustomer(GenericCustomer customerInterface);
	Collection<Customer> getAllCustomers();
	Collection<Customer> getAllCustomersByKey(String queryString);
    Customer getCustomerDetail(int cid);
    void updateCustomerOrders();
}