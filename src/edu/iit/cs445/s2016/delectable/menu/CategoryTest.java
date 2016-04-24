package edu.iit.cs445.s2016.delectable.menu;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTest {
	
	Category category;

	@Test
	public void testName() {
		category = new Category();
		
		category.setName("test");
		
		assertTrue(category.name() == "test");
	}
}
