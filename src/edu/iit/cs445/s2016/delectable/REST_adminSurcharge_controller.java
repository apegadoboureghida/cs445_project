package edu.iit.cs445.s2016.delectable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.surcharge.Surcharge;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/admin/surcharge")
public class REST_adminSurcharge_controller extends REST_AbstractController{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {    	
        Gson gson = new GsonBuilder()
          	     .create();
        String s = gson.toJson(super.bsi.getSurcharge());
        
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(String json) {
        Gson gson =  new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        Surcharge il = gson.fromJson(json, Surcharge.class);
        if(il == null){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        super.bsi.setSurcharge(il.surcharge());
        
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}

