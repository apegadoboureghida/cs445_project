package edu.iit.cs445.s2016.delectable.order;

import java.util.Collection;

public interface BoundaryOrderInterface {
	
	Order createOrder(Order entity);
    Collection<Order> getAllOrders();
    Order getOrderDetail(int oid);
    void updateOrders();
    void CancellOrder(int oid);
}
