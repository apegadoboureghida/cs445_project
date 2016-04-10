package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/menu")
public class REST_menu_controller extends REST_AbstractController {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMenuItems() {
        // calls the "Get All Lamps" use case
    	ExclusionStrategy strategy = new ListStrategy();
    	
        Gson gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
          	     .create();
        String s = gson.toJson(super.bi.getAllMenu());
        return Response.status(Response.Status.OK).entity(s).build();
    }

    @Path("{mid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificMenuItem(@PathParam("mid") int mid) {
        // calls the "Get All Lamps" use case
        MenuItem l = bi.getMenuItemDetail(mid);
        if (l.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
            String s = gson.toJson(l);
            return Response.ok(s).build();
        }
    }
}

