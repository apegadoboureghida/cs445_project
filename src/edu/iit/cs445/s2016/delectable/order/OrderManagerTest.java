package edu.iit.cs445.s2016.delectable.order;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class OrderManagerTest {

	OrderManager manager;
	
	@Before
	public void setUp() throws Exception {
		manager = new OrderManager();
	}

	@Test
	public void testCreateOrder() {	
		
		Order order = new Order();
		order.setDeliveryDate(new Date());
		
		Order res =  manager.createOrder(order);
		
		assertTrue(order.equals(res));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllOrdersByDate() {
		
		manager = new OrderManager();
		
		Date date = new Date();
		date.setDate(date.getDate()+1);
		
		Order order = new Order();
		order.setDeliveryDate(new Date());
		
		Order order2 = new Order();
		order2.setDeliveryDate(date);
		
		manager.createOrder(order);
		manager.createOrder(order2);

		assertTrue(manager.getAllOrdersByDate(date).size() == 1);
	}

	@Test
	public void testGetOrderDetail() {

		Order order = new Order();
		order.setDeliveryDate(new Date());
		
		Order result = manager.createOrder(order);
		assertTrue(manager.getOrderDetail(result.getID()).equals(order));
	}


	@Test
	public void testCancellOrder() {
		Order order = new Order();
		order.setDeliveryDate(new Date());
		
		Order result = manager.createOrder(order);
		
		assertTrue(manager.getOrderDetail(result.getID()).status() != OrderStatus.CANCELLED);
		
		manager.CancellOrder(result.getID());
		
		assertTrue(manager.getOrderDetail(result.getID()).status() != OrderStatus.CANCELLED);
		
		Order order2 = new Order();
		Date date = new Date();
		date.setDate(date.getDate()+7);
		
		order2.setDeliveryDate(date);
		result = manager.createOrder(order2);

		
		manager.CancellOrder(order2.getID());
		
		assertTrue(manager.getOrderDetail(result.getID()).status() == OrderStatus.CANCELLED);


	}

	@Test
	public void testSetDeliverd() {
		Order order = new Order();
		order.setDeliveryDate(new Date());
		
		Order result = manager.createOrder(order);
		
		assertTrue(manager.getOrderDetail(result.getID()).status() != OrderStatus.DELIVERD);
		
		manager.setDeliverd(result.getID());
		
		assertTrue(manager.getOrderDetail(result.getID()).status() == OrderStatus.DELIVERD);
	}

}
