package edu.iit.cs445.s2016.delectable.surcharge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SurchargeTest {

	Surcharge surcharge;
	
    @Before
    public void setUp() throws Exception {
    	surcharge = new Surcharge();
    }
    
	@Test
	public void testSurcharge() {
		assertTrue(surcharge.surcharge() == 0);
	}

	@Test
	public void testSetSurcharge() {
		surcharge.setSurcharge(10.5);
		assertTrue(surcharge.surcharge() == 10.5);
	}

}
