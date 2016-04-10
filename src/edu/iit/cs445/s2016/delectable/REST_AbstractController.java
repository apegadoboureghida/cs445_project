package edu.iit.cs445.s2016.delectable;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

@Path("/")
public class REST_AbstractController {
    protected BoundaryMenuInterface bi = new MenuManager();
	
    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}