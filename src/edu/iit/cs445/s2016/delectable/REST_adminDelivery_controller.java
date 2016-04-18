package edu.iit.cs445.s2016.delectable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.order.Order;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/admin/delivery")
public class REST_adminDelivery_controller extends REST_AbstractController {

    @Path("{oid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificMenuItem(@Context UriInfo uriInfo,@PathParam("oid") int oid,String json) {
        Gson gson =  new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        Order il = gson.fromJson(json, Order.class);
        if(il == null){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(super.boi.getOrderDetail(oid).isNil()){
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        super.boi.setDeliverd(oid);
        
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

