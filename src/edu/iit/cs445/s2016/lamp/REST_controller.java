package edu.iit.cs445.s2016.lamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/lamps")
public class REST_controller {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLamps() {
        // calls the "Get All Lamps" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson("Test");
        return Response.status(Response.Status.OK).entity(s).build();
    }


    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}

