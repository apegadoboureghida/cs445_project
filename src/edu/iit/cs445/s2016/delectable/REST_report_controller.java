package edu.iit.cs445.s2016.delectable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.iit.cs445.s2016.delectable.GsonStrategies.ListReportStrategy;
import edu.iit.cs445.s2016.delectable.GsonStrategies.OrderDeliverReportStrategy;
import edu.iit.cs445.s2016.delectable.report.ReportType;

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
        String s = gson.toJson(super.bri.getAllReports());
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("{rid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("rid") int rid
    		,@QueryParam("start_date") String startDate
    		,@QueryParam("end_date") String endDate) {    
        Gson gson = new GsonBuilder().create();

        if((startDate == null && endDate != null) || (startDate != null && endDate == null)){
        	Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        ReportType report = null;
        
        switch (rid) {
			case 801:
		        if((startDate != null && endDate != null)){
		        	Response.status(Response.Status.BAD_REQUEST).build();
		        }
				gson=new GsonBuilder()
					.setExclusionStrategies(new OrderDeliverReportStrategy())
					.create();
				report = super.bri.getReportToday();
				break;
			case 802:
		        if((startDate != null && endDate != null)){
		        	Response.status(Response.Status.BAD_REQUEST).build();
		        }
				report = super.bri.getReport802();
				gson=new GsonBuilder()
						.setExclusionStrategies(new OrderDeliverReportStrategy())
						.create();
				break;
			case 803:
		        if((startDate != null && endDate != null)){
					report = super.bri.getReport803(Common.StringToData(startDate),Common.StringToData(endDate));
		        }else{
				report = super.bri.getReport803();
		        }
				break;
			case 804:
		        if((startDate != null && endDate != null)){
					report = super.bri.getReport804(Common.StringToData(startDate),Common.StringToData(endDate));
		        }else{
				report = super.bri.getReport804();
		        }
				break;
			default:
				break;
		}

        
        if(report == null){
        	Response.status(Response.Status.NOT_FOUND).build();
        }
        String s = gson.toJson(report);
        
        
        return Response.status(Response.Status.OK).entity(s).build();
    }
}

