package edu.iit.cs445.s2016.delectable.menu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.iit.cs445.s2016.delectable.Common;

public class MenuItemTest {

	MenuItem item;
	
	@Before
	public void setUp() throws Exception {
		item = new MenuItem();
	}

	@Test
	public void testName() {
		item.setName("new");
		assertTrue(item.name() == "new");
	}

	@Test
	public void testPricePerPerson() {
		item.setPricePerPerson(15.5);
		assertTrue(item.pricePerPerson() == 15.5);
	}

	@Test
	public void testMinimumOrder() {
		assertTrue(item.minimumOrder() == 0);

		item.setMinimumOrder(10);
		assertTrue(item.minimumOrder() == 10);
	}

	@Test
	public void testCreateDate() {
		assertTrue(Common.isSameDay(item.createDate(),new Date()));
	}

	@Test
	public void testLastModifiedDate() {
		assertTrue(Common.isSameDay(item.lastModifiedDate(),new Date()));
	}

	@Test
	public void testCategories() {
		assertTrue(item.categories().size() == 0);
		
		Category category = new Category();
		
		category.setName("NewCategory");
		
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		
		item.setCategories(categories);
		
		assertTrue(item.categories().size() == 1);
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
}
