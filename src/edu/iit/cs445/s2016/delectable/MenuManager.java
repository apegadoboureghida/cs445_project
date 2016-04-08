package edu.iit.cs445.s2016.delectable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuManager implements BoundaryMenuInterface {

	 private static List<MenuItem> Menu = new ArrayList<MenuItem>();
	 
	@Override
	public List<MenuItem> getAllMenu() {
		return Menu;
	}

	@Override
	public MenuItem createMenuItem(String name, float pricePerPerson,int minimumOrder, List<String> categories) {
		MenuItem item = new MenuItem();
		
		item.setName(name);
		item.setPricePerPerson(pricePerPerson);
		item.setMinimumOrder(minimumOrder);
		
		for(String category : categories){
			item.addCategorie(category);
		}
		
		
		return item;
	}

	@Override
	public MenuItem getMenuItemDetail(int mid) {
		return findById(mid);
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
