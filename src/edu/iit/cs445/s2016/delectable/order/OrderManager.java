package edu.iit.cs445.s2016.delectable.order;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderManager implements BoundaryOrderInterface{

	private static Map<Integer,Order> orders = new HashMap<Integer,Order>();
	
	@Override
	public Order createOrder(Order entity) {		
		orders.put(entity.getID(),entity);
		
		return entity;
	}
	
	@Override
	public Collection<Order> getAllOrders() {
		return orders.values();
	}
	
	@Override
	public Collection<Order> getAllOrdersByDate(Date date) {
		
		Map<Integer,Order> result = new HashMap<Integer,Order>();
		
		for(Order tmp : orders.values()){
			if(tmp.deliveryMach(date)){
				result.put(tmp.getID(), tmp);
			}
		}
		
		return result.values();
	}

	@Override
	public Order getOrderDetail(int oid) {
		
		if(orders.containsKey(oid)){
			return orders.get(oid);
		}
		return new NullOrder();
	}

	@Override
	public void updateOrders() {
	
	}

	@Override
	public void CancellOrder(int oid) {
		if(orders.containsKey(oid))
			orders.get(oid).setStatus(OrderStatus.CANCELLED);
	}

	@Override
	public void setDeliverd(int oid) {
		if(orders.containsKey(oid))
			orders.get(oid).setStatus(OrderStatus.DELIVERD);		
	}
}
