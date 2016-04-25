package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.GsonStrategies.CreateStrategy;
import edu.iit.cs445.s2016.delectable.menu.MenuItem;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/admin/menu")
public class REST_adminMenu_controller extends REST_AbstractController{

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMenuItem(@Context UriInfo uriInfo, String json) {
        int id;
        ExclusionStrategy strategy = new CreateStrategy();
        
        Gson gson = new Gson();
        // calls the "Create Lamp" use case
        MenuItem il = gson.fromJson(json, MenuItem.class);
        if(il == null){
        	return Response.status(Response.Status.BAD_REQUEST).build();
        }
        MenuItem l = super.bi.createMenuItem(il);

        id = l.getID();
        
        gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
          	     .create();
        
        String s = gson.toJson(l);
        // Build the URI for the "Location:" header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(id));

        // The response includes header and body data
        return Response.created(builder.build()).entity(s).build();
    }
    
    @Path("{mid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificItem(@PathParam("mid") int lid, String json) {
        // update existing MenuItem
        Gson gson = new Gson();
        MenuItem il = gson.fromJson(json, MenuItem.class);
        super.bi.updateMenuItemDetail(il);

        return Response.ok().build();
    }
}

