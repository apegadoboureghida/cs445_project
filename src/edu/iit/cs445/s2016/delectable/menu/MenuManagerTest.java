package edu.iit.cs445.s2016.delectable.menu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MenuManagerTest {

	MenuManager manager;

	@Test
	public void testGetAllMenu() {
		manager = new MenuManager();
	
		int size = manager.getAllMenu().size();
		
		
		MenuItem item = new MenuItem();
		
		manager.createMenuItem(item);
		
		assertTrue(manager.getAllMenu().size() == size+1);
	}

	@Test
	public void testGetMenuItemDetail() {
		
		manager = new MenuManager();
		

		MenuItem item = new MenuItem();
		
		MenuItem res = manager.createMenuItem(item);

		assertTrue(manager.getMenuItemDetail(res.getID()).equals(res));
	}

	@Test
	public void testUpdateMenuItemDetail() {
		manager = new MenuManager();
		

		MenuItem item = new MenuItem();
		
		MenuItem res = manager.createMenuItem(item);
		
		item.setPricePerPerson(15.5);
		manager.updateMenuItemDetail(item);
		
		assertTrue(manager.getMenuItemDetail(res.getID()).equals(item));

	}

}
