package edu.iit.cs445.s2016.delectable.customer;

import com.google.gson.annotations.SerializedName;

public class GenericCustomer {
	

	@SerializedName("name")
    private String name;
	@SerializedName("email")
    private String email;
	@SerializedName("phone")
    private String phone;
    
    public GenericCustomer() {
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
       
    public boolean matchesCustomer(GenericCustomer customer) {
        return(customer.email().equals(this.email) && customer.name().equals(this.name) && (customer.phone().equals(this.phone)));
    }

	public void setName(String name) {
		this.name = name;		
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
