package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.GsonStrategies.CreateStrategy;
import edu.iit.cs445.s2016.delectable.GsonStrategies.ListStrategy;
import edu.iit.cs445.s2016.delectable.menu.MenuItem;
import edu.iit.cs445.s2016.delectable.order.Order;
import edu.iit.cs445.s2016.delectable.order.OrderItem;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/order")
public class REST_order_controller extends REST_AbstractController{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@QueryParam("date") String date) {
        // calls the "Get All Lamps" use case
    	ExclusionStrategy strategy = new ListStrategy();
    	
        Gson gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
         	    .setDateFormat("yyyyMMdd")
          	     .create();
        String s;
        if(date == null){
        s = gson.toJson(super.boi.getAllOrders());
        }else{
        	s = gson.toJson(super.boi.getAllOrdersByDate(Common.StringToData(date)));
        }
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeOrder(@Context UriInfo uriInfo, String json) {
        int id;
        ExclusionStrategy strategy = new CreateStrategy();
        
        Gson gson =  new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        // calls the "Create Lamp" use case
        Order il = gson.fromJson(json, Order.class);
        if(il == null){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }

        
        double amount = 0;
        if(il.deliveryDate() == null || il.deliveryAddress() == null || il.customer()== null || il.orderDetail() == null || il.orderDetail().isEmpty())
        {
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        for(OrderItem item:il.orderDetail()){
        	MenuItem temp = super.bi.getMenuItemDetail(item.getID());
        	if(temp.isNil() || temp.minimumOrder()> item.count()){
        		return Response.status(Response.Status.BAD_REQUEST).build();
        	}
        	item.setName(temp.name());
        	amount += temp.pricePerPerson() * item.count();
        }
        il.setAmount(amount);
        il.setsurcharge(super.bsi.getSurcharge(il.deliveryDate()).surcharge());
        
        Order l = super.boi.createOrder(il);
        
        super.bci.createCustomer(il.customer());
        super.bri.addOrder(l);
        
        id = l.getID();
        
        gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
         	    .setDateFormat("yyyyMMdd")
          	     .create();
        
        String s = gson.toJson(l);
        // Build the URI for the "Location:" header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(id));

        // The response includes header and body data
        return Response.created(builder.build()).entity(s).build();
    }
    
    @Path("{oid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("oid") int oid) {
        // calls the "Get All Lamps" use case
    	ExclusionStrategy strategy = new ListStrategy();
    	
        Gson gson = new GsonBuilder()
        		.setDateFormat("yyyyMMdd")
         	     .setExclusionStrategies(strategy)
          	     .create();
        String s = gson.toJson(super.boi.getOrderDetail(oid));
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("cancel/{oid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancelSpecificOrder(@Context UriInfo uriInfo,@PathParam("oid") int oid,String json) {
        Gson gson =  new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        Order il = gson.fromJson(json, Order.class);
        if(il == null){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(super.boi.getOrderDetail(oid).isNil()){
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
        if(Common.isSameDay(new Date(), super.boi.getOrderDetail(oid).deliveryDate())){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        super.boi.CancellOrder(oid);
        
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(oid));
        
        return Response.created(builder.build()).status(Response.Status.NO_CONTENT).build();
    }

    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}

