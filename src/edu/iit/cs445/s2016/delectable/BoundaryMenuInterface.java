package edu.iit.cs445.s2016.delectable;

import java.util.List;


public interface BoundaryMenuInterface {
    List<MenuItem> getAllMenu();
    MenuItem createMenuItem(MenuItem entity);
    MenuItem getMenuItemDetail(int mid);	
    void updateMenuItemDetail(MenuItem entity);	
}
