package edu.iit.cs445.s2016.delectable;

import java.util.List;


public interface BoundaryMenuInterface {
    List<MenuItem> getAllMenu();
    MenuItem createMenuItem(String name, float pricePerPerson,int minimumOrder, List<String> categories);
    MenuItem getMenuItemDetail(int mid);	
}
