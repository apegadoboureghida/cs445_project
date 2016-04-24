package edu.iit.cs445.s2016.delectable.GsonStrategies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreateStrategyTest {
	
	CreateStrategy strategy;

	@Before
	public void setUp() throws Exception {
		strategy = new CreateStrategy();
	}

	@Test
	public void testShouldSkipClass() {
		assertFalse(strategy.shouldSkipClass(null));
	}

}
