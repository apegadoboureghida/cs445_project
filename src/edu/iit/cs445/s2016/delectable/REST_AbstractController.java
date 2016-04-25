package edu.iit.cs445.s2016.delectable;

import javax.ws.rs.*;

import edu.iit.cs445.s2016.delectable.customer.BoundaryCustomerInterface;
import edu.iit.cs445.s2016.delectable.customer.CustomerManager;
import edu.iit.cs445.s2016.delectable.menu.BoundaryMenuInterface;
import edu.iit.cs445.s2016.delectable.menu.MenuManager;
import edu.iit.cs445.s2016.delectable.order.BoundaryOrderInterface;
import edu.iit.cs445.s2016.delectable.order.OrderManager;
import edu.iit.cs445.s2016.delectable.report.BoundaryReportInterface;
import edu.iit.cs445.s2016.delectable.report.ReportManager;
import edu.iit.cs445.s2016.delectable.surcharge.BoundarySurchargeInterface;
import edu.iit.cs445.s2016.delectable.surcharge.SurchargeManager;

@Path("/")
public class REST_AbstractController {
	
    protected BoundaryMenuInterface bi = new MenuManager();
    protected BoundaryOrderInterface boi = new OrderManager();
    protected BoundaryCustomerInterface bci = new CustomerManager();
	protected BoundaryReportInterface bri = new ReportManager();
	protected BoundarySurchargeInterface bsi = new SurchargeManager();
   
}