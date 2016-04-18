package edu.iit.cs445.s2016.delectable.menu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MenuManager implements BoundaryMenuInterface {

	 private static Map<Integer,MenuItem> menu = new HashMap<Integer,MenuItem>();
	 
	@Override
	public Collection<MenuItem> getAllMenu() {
		return menu.values();
	}

	@Override
	public MenuItem createMenuItem(MenuItem entity) {
		menu.put(entity.getID(),entity);
		
		return entity;
	}

	@Override
	public MenuItem getMenuItemDetail(int mid) {
		if(menu.containsKey(mid)){
			return menu.get(mid);
		}
		return new NullMenuItem();
	}
	
	@Override
	public void updateMenuItemDetail(MenuItem entity) {
		if(menu.containsKey(entity.getID())){
			menu.get(entity.getID()).setPricePerPerson(entity.pricePerPerson());
		}
    }


    
}
