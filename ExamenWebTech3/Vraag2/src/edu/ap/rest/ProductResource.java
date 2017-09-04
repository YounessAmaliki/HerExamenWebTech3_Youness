package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.json.JSONFactory;

public class ProductResource extends ServerResource {
	@Get("txt")
	public String getProduct(){
		return JSONFactory.getProduct(getAttribute("product_naam"));
	}

}
