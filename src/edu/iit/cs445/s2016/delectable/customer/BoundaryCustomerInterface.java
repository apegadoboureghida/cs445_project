package edu.iit.cs445.s2016.delectable.customer;

import java.util.List;

public interface BoundaryCustomerInterface {
    List<Customer> getAllCustomers();
    List<Customer> getAllCustomersByKey(String queryString);
    Customer getMenuItemDetail(int mid);
    void updateCustomerOrders();
}