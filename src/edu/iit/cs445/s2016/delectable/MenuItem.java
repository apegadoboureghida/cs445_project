package edu.iit.cs445.s2016.delectable;

import java.util.List;

public class MenuItem {
	
    private int ID;
    private String name;
    private float pricePerPerson;
    private int minimumOrder;
    private List<String> categories;
   
    public MenuItem() {
        this.ID = UniqueIdGenerator.getUniqueID();
    }

    public String name() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    
    public float pricePerPerson(){
    	return  this.pricePerPerson;
    }
    
    public void setPricePerPerson(float newPrice){
    	this.pricePerPerson = newPrice;
    }
    
    public int minimumOrder(){
    	return this.minimumOrder;
    }
    
    public void minimumOrder(int newMinimum){
    	this.minimumOrder = newMinimum;
    }

    public List<String> categories(){
    	return this.categories;
    }
    
    public void addCategorie(String categorie){
    	if(!this.categories.contains(categorie))
    	{
    		this.categories.add(categorie);
    	}
    }
    
    public void clearCategories(){
    	this.categories.clear();
    }
    
    public boolean matchesId(int mid) {
        return(mid == this.ID);
    }

    public boolean isNil() {
        return false;
    }

    public int getID() {
        return this.ID;
    }
}
