package edu.iit.cs445.s2016.delectable.report;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.iit.cs445.s2016.delectable.order.Order;

public class ReportManagerTest {

	ReportManager manager;
	
    @Before
    public void setUp() throws Exception {
		manager = new ReportManager();
    }
	
	@Test
	public void testGetAllRerports() {
		 assertTrue(manager.getAllReports().size() == 4);	
	 }

	@Test
	public void testAddOrder() {
		Order order = new Order();
		order.setDeliveryDate(new Date());
		manager.addOrder(order);
		
		assertTrue(manager.getRerport(801).orders().size() == 1);
	}
	
	@Test
	public void testGetRerport() {
		assertTrue(manager.getRerport(801).id() == 801);
		assertTrue(manager.getRerport(802).id() == 802);
		assertTrue(manager.getRerport(803).id() == 803);
		assertTrue(manager.getRerport(804).id() == 804);

	}



}
