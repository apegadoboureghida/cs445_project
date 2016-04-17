package edu.iit.cs445.s2016.delectable.report;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.order.Order;

public class ReportType {
	
	@SerializedName("id") 
    private int id;
	@SerializedName("id") 
    private String name;
	@SerializedName("orders")
	private List<Order> orders;
	
	public ReportType(int id,String name){
		
	}
	
	public void setOrders(List<Order> orders){
		this.orders = orders;
	}
}
