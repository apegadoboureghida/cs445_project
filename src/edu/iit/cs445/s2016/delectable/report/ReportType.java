package edu.iit.cs445.s2016.delectable.report;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import edu.iit.cs445.s2016.delectable.order.Order;

public class ReportType {
	
	@SerializedName("id") 
    private int id;
	@SerializedName("name") 
    private String name;
	@SerializedName("orders")
	private List<Order> orders;
	@SerializedName("start_date")
	private Date startDate;
	@SerializedName("end_date")
	private Date endDate;
	@SerializedName("orders_placed")
	private int ordersPlaced;
	@SerializedName("orders_cancelled")
	private int ordersCancelled;
	@SerializedName("orders_open")
	private int ordersOpen;
	@SerializedName("food_revenue")
	private double foodRevenue;
	@SerializedName("surcharge_revenue")
	private double surchargeRevenue;
	
	public ReportType(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public void setStartDate(Date date){
		this.startDate = date;
	}
	
	public void setEndDate(Date date){
		this.endDate = date;
	}
	
	public void setOrdersPlaced(int ordersPlaced){
		this.ordersPlaced = ordersPlaced;
	}
	
	public void setOrdersCancelled(int ordersCancelled){
		this.ordersCancelled = ordersCancelled;
	}
	
	public void setOrdersOpen(int ordersOpen){
		this.ordersOpen = ordersOpen;
	}
	
	public void setFoodRevenuen(double foodRevenue){
		this.foodRevenue = foodRevenue;
	}
	
	public void setSurchargeRevenue(double surchargeRevenue){
		this.surchargeRevenue = surchargeRevenue;
	}
	
	public void setOrders(List<Order> orders){
		this.orders = orders;
	}
}
