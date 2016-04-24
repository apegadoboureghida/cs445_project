package edu.iit.cs445.s2016.delectable.order;

import java.util.Collection;
import java.util.Date;

public interface BoundaryOrderInterface {
	
	Order createOrder(Order entity);
    Collection<Order> getAllOrders();
    Order getOrderDetail(int oid);
    boolean CancellOrder(int oid);
    void setDeliverd(int oid);
	Collection<Order> getAllOrdersByDate(Date date);
}
