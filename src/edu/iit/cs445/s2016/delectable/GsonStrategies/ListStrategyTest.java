package edu.iit.cs445.s2016.delectable.GsonStrategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListStrategyTest {
	
	ListStrategy strategy;

	@Before
	public void setUp() throws Exception {
		strategy = new ListStrategy();
	}

	@Test
	public void testShouldSkipClass() {
		assertFalse(strategy.shouldSkipClass(null));
	}

}
