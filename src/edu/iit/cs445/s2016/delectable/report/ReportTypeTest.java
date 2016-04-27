package edu.iit.cs445.s2016.delectable.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.iit.cs445.s2016.delectable.order.Order;

public class ReportTypeTest {
	ReportType report;

    @Before
    public void setUp() throws Exception {
        report = new ReportType(0, "report");
    }
    
	@Test
	public void testID() {

        assertTrue(report.id()==0);
	}
	
	@Test
	public void testName() {
        assertTrue(report.name().equals("report"));
	}

	@Test
	public void testStartDate() {
		Date date = new Date();
		report.setStartDate(date);
		
        assertTrue(report.startDate().equals(date));
	}
	
	@Test
	public void testEndDate() {
		Date date = new Date();
		report.setEndDate(date);
		
        assertTrue(report.endDate().equals(date));
	}
	
	@Test
	public void orderPlaced() {
		
		assertTrue(report.ordersPlaced() == 0);
		report.setOrdersPlaced(10);
		
		assertTrue(report.ordersPlaced() == 10);
	}
	
	@Test
	public void ordersCancelled() {
		
		assertTrue(report.ordersCancelled() == 0);
		report.setOrdersCancelled(10);;
		
		assertTrue(report.ordersCancelled() == 10);
	}
	
	@Test
	public void ordersOpen() {
		
		assertTrue(report.ordersOpen() == 0);
		report.setOrdersOpen(10);;
		
		assertTrue(report.ordersOpen() == 10);
	}
	
	@Test
	public void food_revenue() {
		
		assertTrue(report.foodRevenue() == 0);
		report.setFoodRevenuen(10);;
		
		assertTrue(report.foodRevenue() == 10);
	}
	
	@Test
	public void orders() {
		Order order = new Order();
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		assertTrue(report.orders().isEmpty());
		report.setOrders(orders);
		
		assertTrue(report.orders().size() == 1);
	}
}
