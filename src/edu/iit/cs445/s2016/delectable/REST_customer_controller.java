package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.GsonStrategies.ListStrategy;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/customer")
public class REST_customer_controller extends REST_AbstractController{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@QueryParam("key") String keyString) {
        // calls the "Get All Lamps" use case
    	ExclusionStrategy strategy = new ListStrategy();
    	
        Gson gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
          	     .create();
        String s;
        if(keyString == null){
        	s= gson.toJson(super.bci.getAllCustomers());
        }else{
        	s= gson.toJson(super.bci.getAllCustomersByKey(keyString));
        }
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("cid") int lid) {
        // calls the "Get All Lamps" use case
    	ExclusionStrategy strategy = new ListStrategy();
    	
        Gson gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
          	     .create();
        if(super.bci.getCustomerDetail(lid).isNil())
        {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
        String s= gson.toJson(super.bci.getCustomerDetail(lid));

        return Response.status(Response.Status.OK).entity(s).build();
    }

}

