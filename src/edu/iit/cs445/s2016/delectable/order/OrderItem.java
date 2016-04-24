package edu.iit.cs445.s2016.delectable.order;

import com.google.gson.annotations.SerializedName;


public class OrderItem {

	@SerializedName("id") 
    private int id;
    private String name;
    @SerializedName("count") 
    private int count;

    public OrderItem() {
    }
   
    public String name() {
        return name;
    }

    public void setName(String name){
    	this.name = name;
    }
    
    public void setCount(int count){
    	this.count = count;
    }
    public int count(){
    	return this.count;
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
