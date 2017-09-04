package edu.ap.rest;

import org.restlet.*;
import org.restlet.data.Protocol;

public class Main {
	
	public static void main(String[] args) throws Exception {  
	    // Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8081);  

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/product",  new BolApplication());  
	    

	    // Start the component.  
	    component.start();  
	}

}
