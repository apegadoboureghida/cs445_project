package edu.iit.cs445.s2016.delectable.customer;

import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.UniqueIdGenerator;

public class Customer extends GenericCustomer {
	    
	@SerializedName("id") 
    protected int id;
	
    public Customer() {
    	this.id = UniqueIdGenerator.getUniqueID();
    }
}
