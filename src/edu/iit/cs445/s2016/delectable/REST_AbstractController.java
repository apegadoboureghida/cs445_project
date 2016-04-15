package edu.iit.cs445.s2016.delectable;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

import edu.iit.cs445.s2016.delectable.customer.BoundaryCustomerInterface;
import edu.iit.cs445.s2016.delectable.customer.CustomerManager;
import edu.iit.cs445.s2016.delectable.menu.BoundaryMenuInterface;
import edu.iit.cs445.s2016.delectable.menu.MenuManager;
import edu.iit.cs445.s2016.delectable.order.BoundaryOrderInterface;
import edu.iit.cs445.s2016.delectable.order.OrderManager;

@Path("/")
public class REST_AbstractController {
	
    protected BoundaryMenuInterface bi = new MenuManager();
    protected BoundaryOrderInterface boi = new OrderManager();
    protected BoundaryCustomerInterface bci = new CustomerManager();
	
    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}