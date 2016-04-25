package edu.iit.cs445.s2016.delectable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class REST_AbstractControllerTest {

	REST_AbstractController controller;
	@Before
	public void setUp() throws Exception {
		controller = new REST_AbstractController();
	}

	@Test
	public void test() {
		assertTrue(controller.bci != null);
	}

}
