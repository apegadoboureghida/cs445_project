package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.GsonStrategies.ListReportStrategy;
import edu.iit.cs445.s2016.delectable.report.ReportType;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/report")
public class REST_report_controller extends REST_AbstractController{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReports() {
    	ExclusionStrategy strategy = new ListReportStrategy();
    	
        Gson gson = new GsonBuilder()
         	     .setExclusionStrategies(strategy)
          	     .create();
        String s = gson.toJson(super.bri.getAllRerports());
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("{rid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("rid") int rid) {    	
        Gson gson = new GsonBuilder()
          	     .create();
        
        ReportType report = super.bri.getRerport(rid);
        
        if(report == null){
        	Response.status(Response.Status.NOT_FOUND).build();
        }
        String s = gson.toJson(super.bri.getRerport(rid));
        
        
        return Response.status(Response.Status.OK).entity(s).build();
    }

    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}

