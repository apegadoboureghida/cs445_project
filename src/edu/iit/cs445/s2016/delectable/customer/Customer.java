package edu.iit.cs445.s2016.delectable.customer;

import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.UniqueIdGenerator;

public class Customer {
	
	@SerializedName("id") 
    private int id;
    private String name;
    private String email;
    private String phone;
    
    public Customer() {
        this.id = UniqueIdGenerator.getUniqueID();
    }
   
    public int id(){
    	return id;
    }
    
    public String name() {
        return name;
    }
    
    public String email(){
    	return email;
    }
    
    public String phone(){
    	return phone;
    }
    
    public boolean isNil() {
        return false;
    }
}
