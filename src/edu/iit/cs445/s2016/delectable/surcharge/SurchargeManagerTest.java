package edu.iit.cs445.s2016.delectable.surcharge;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class SurchargeManagerTest {
	SurchargeManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new SurchargeManager();
	}

	@Test
	public void testGetSurcharge() {
		assertTrue(manager.getSurcharge().surcharge() == 0);
	}
	
	@Test
	public void testSetSurcharge() {
		manager.setSurcharge(20.5);
		System.out.print(manager.getSurcharge().surcharge());

		assertTrue(manager.getSurcharge().surcharge() == 20.5);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void testGetSurchargeDate() {
		manager.setSurcharge(20.5);
		Date date = new Date();
		
		date.setDate(25);
		date.setMonth(4);
		date.setYear(2016);
		System.out.print(manager.getSurcharge().surcharge());
		assertTrue(manager.getSurcharge().surcharge() == 20.5);
	}
}
