package edu.iit.cs445.s2016.delectable.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MenuManager implements BoundaryMenuInterface {

	 private static List<MenuItem> Menu = new ArrayList<MenuItem>();
	 
	@Override
	public List<MenuItem> getAllMenu() {
		return Menu;
	}

	@Override
	public MenuItem createMenuItem(MenuItem entity) {
		Menu.add(entity);
		
		return entity;
	}

	@Override
	public MenuItem getMenuItemDetail(int mid) {
		return findById(mid);
	}
	
	@Override
	public void updateMenuItemDetail(MenuItem entity) {
        ListIterator<MenuItem> mi = Menu.listIterator();
        while(mi.hasNext()) {
        	MenuItem l = mi.next();
            if(l.matchesId(entity.getID())) {
            	l.setPricePerPerson(entity.pricePerPerson());
            };
        }
    }

    private MenuItem findById(int mid) {
        Iterator<MenuItem> mi = Menu.listIterator();
        while(mi.hasNext()) {
        	MenuItem l = mi.next();
            if(l.matchesId(mid)) return(l);
        }
        return(new NullMenuItem());
    }

    
}
