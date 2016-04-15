package edu.iit.cs445.s2016.delectable.order;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.UniqueIdGenerator;
import edu.iit.cs445.s2016.delectable.customer.GenericCustomer;

public class Order {
	@SerializedName("id") 
    private int id;
	@SerializedName("amount") 
    private double amount;
	@SerializedName("status") 
    private OrderStatus status;
	@SerializedName("delivery_date") 
    private Date deliveryDate;
	@SerializedName("order_date") 
	private Date orderDate;
	@SerializedName("personal_info")
	private GenericCustomer customer;
	@SerializedName("note")
	private String note;
	@SerializedName("order_detail")
	private List<OrderItem> orderDetail;
	@SerializedName("cancel_url")
	private String cancelURL;
	
	
    public Order() {
        this.id = UniqueIdGenerator.getUniqueID();
        this.orderDate = new Date();
        status = OrderStatus.OPEN;
        amount = 0;
        cancelURL = "/order/cancel/"+this.id;
    }
      
    public GenericCustomer customer(){
    	return this.customer;
    }
    
    public List<OrderItem> orderDetail(){
    	return this.orderDetail;
    }

    public void setAmount(double amount){
    	this.amount = amount;
    }
    
    public void setStatus(OrderStatus status){
    	this.status = status;
    }
    
    public void setCustomer(GenericCustomer customer){
    	this.customer = customer;
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
