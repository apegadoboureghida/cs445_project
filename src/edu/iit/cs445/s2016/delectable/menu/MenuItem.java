package edu.iit.cs445.s2016.delectable.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.UniqueIdGenerator;

public class MenuItem {
	
	@SerializedName("id") 
    private int id;
    private String name;
    @SerializedName("price_per_person") 
    private double pricePerPerson;
    @SerializedName("minimum_order") 
    private int minimumOrder;
    private List<Category> categories;
    @SerializedName("create_date") 
    private Date createDate;
    @SerializedName("last_modified_date") 
    private Date lastModifiedDate;
    
    public MenuItem() {
        this.id = UniqueIdGenerator.getUniqueID();
        this.categories = new ArrayList<Category>();  
        this.createDate = new Date();
        this.lastModifiedDate = new Date();
    }
   
    public String name() {
        return name;
    }
    
    public Double pricePerPerson(){
    	return  this.pricePerPerson;
    }
    
    public void setPricePerPerson(Double newPrice){
    	this.pricePerPerson = newPrice;
    }

    public int minimumOrder(){
    	return this.minimumOrder;
    }
    
    public Date createDate(){
    	return this.createDate;
    }
    
    public Date lastModifiedDate(){
    	return this.lastModifiedDate;
    }
    
    public List<Category> categories(){
    	return this.categories;
    }
    
    public boolean matchesId(int mid) {
        return(mid == this.id);
    }

    public boolean isNil() {
        return false;
    }

    public int getID() {
        return this.id;
    }
}
