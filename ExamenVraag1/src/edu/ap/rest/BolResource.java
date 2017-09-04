package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class BolResource extends ServerResource {

	
	@Get("html")
	public String getProducten() {
		XMLParser parser = new XMLParser();
		return parser.getProducten();
	}
	
	@Post("txt")
	public String addProduct(String xml) {
		XMLParser parser = new XMLParser();
		return parser.addProduct(xml);
	}
	

}


