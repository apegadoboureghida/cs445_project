package edu.iit.cs445.s2016.delectable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/order")
public class REST_order_controller {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        // calls the "Get All Lamps" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson("Test");
        return Response.status(Response.Status.OK).entity(s).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeOrder(@Context UriInfo uriInfo) {
        Gson gson = new Gson();
        String s = gson.toJson("test");
        // Build the URI for the "Location:" header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(1));

        // The response includes header and body data
        return Response.created(builder.build()).entity(s).build();
    }
    
    @Path("{oid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("oid") int lid) {
        // calls the "Get All Lamps" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson("TestMID");
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("cancel/{oid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancelSpecificOrder(@PathParam("oid") int lid,String json) {
        // calls the "Get All Lamps" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson("TestMID");
        return Response.status(Response.Status.OK).entity(s).build();
    }

    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}

