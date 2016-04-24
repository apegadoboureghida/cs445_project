package edu.iit.cs445.s2016.delectable.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderItemTest {
	
	OrderItem item ;

	@Before
	public void setUp() throws Exception {
		item = new OrderItem();
	}

	@Test
	public void testSetName() {
		item.setName("newName");
		assertTrue(item.name()=="newName");
	}

	@Test
	public void testCount() {
		assertTrue(item.count() == 0);
		item.setCount(10);
		assertTrue(item.count() == 10);
	}

	@Test
	public void testMatchesId() {
		assertTrue(item.matchesId(item.getID()));
		assertFalse(item.matchesId(item.getID()+1));
	}

	@Test
	public void testIsNil() {
		assertFalse(item.isNil());
	}

	@Test
	public void testGetID() {
		assertTrue(item.getID() == 0);
	}

}
