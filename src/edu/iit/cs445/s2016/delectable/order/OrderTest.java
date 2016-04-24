package edu.iit.cs445.s2016.delectable.order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.iit.cs445.s2016.delectable.customer.Customer;

public class OrderTest {
	
	Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order();
	}

	@Test
	public void testCustomer() {
		Customer customer = new Customer();
		customer.setName("test1");
		customer.setEmail("email");
		customer.setPhone("123456");
		
		order.setCustomer(customer);
		
		assertTrue(order.customer().equals(customer));
	}

	@Test
	public void testOrderDetail() {
		assertTrue(order.orderDetail() == null);
		
		OrderItem item = new OrderItem();
		item.setName("item1");
		item.setCount(10);
		
		List<OrderItem> orderDetail = new ArrayList<OrderItem>();
		orderDetail.add(item);
		
		order.setOrderDetail(orderDetail);
		
		assertTrue(order.orderDetail().size() == 1);
		
	}

	@Test
	public void testAmount() {
		assertTrue(order.amount() == 0);
		
		order.setAmount(15.5);
		
		assertTrue(order.amount()== 15.5);
	}

	@Test
	public void testSurcharge() {
		assertTrue(order.surcharge() == 0);
		
		order.setsurcharge(12.5);
		
		assertTrue(order.surcharge()==12.5);
	}

	@Test
	public void testStatus() {
		assertTrue(order.status() == OrderStatus.OPEN);
		
		order.setStatus(OrderStatus.CANCELLED);
		
		assertTrue(order.status() == OrderStatus.CANCELLED);
	}

	@Test
	public void testMatchesId() {
		assertTrue(order.matchesId(order.getID()));
		
		assertFalse(order.matchesId(order.getID()+1));
	}

	@Test
	public void testIsNil() {
		assertFalse(order.isNil());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDeliveryDate() {
		Date date = new Date();
		
		order.setDeliveryDate(date);

		assertTrue(order.deliveryDate() == date);
		
		assertTrue(order.deliveryMach(order.deliveryDate()));
		
		date.setYear(2015);
		
		assertTrue(order.deliveryMach(date));
	}

	@Test
	public void testDeliveryAddress() {
		order.setDeliveryAddress("newAddress");
		
		assertTrue(order.deliveryAddress() == "newAddress");
	}

}
