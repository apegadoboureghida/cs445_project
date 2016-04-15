package edu.iit.cs445.s2016.delectable.menu;

import java.util.Collection;

public interface BoundaryMenuInterface {
	Collection<MenuItem> getAllMenu();
    MenuItem createMenuItem(MenuItem entity);
    MenuItem getMenuItemDetail(int mid);	
    void updateMenuItemDetail(MenuItem entity);	
}
