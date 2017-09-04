package edu.ap.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ProductApplication extends Application{
	@Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/producten", ProductenResource.class);
		router.attach("/product/{product_naam}", ProductResource.class);

        return router;
    }

}
