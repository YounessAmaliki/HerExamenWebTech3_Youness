package edu.ap.rest;

import org.json.JSONObject;
import org.restlet.resource.ClientResource;

public class ProductClient {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ClientResource resource = new ClientResource("http://localhost:8181/warenhuis/producten");
			JSONObject product1 = new JSONObject();
			product1.put("Naam", "PS4");
			product1.put("Producent", "Sony");
			product1.put("Prijs", "50");
			resource.post(product1.toString());
			System.out.println(resource.getResponseEntity().getText());
			
			JSONObject product2 = new JSONObject();
			product2.put("Naam", "Xbox");
			product2.put("Producent", "Microsoft");
			product2.put("Prijs", "5");
			resource.post(product2.toString());
			System.out.println(resource.getResponseEntity().getText());
			
			ClientResource resource2 = new ClientResource("http://localhost:8181/warenhuis/product/PS4");
			System.out.println(resource2.get());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR: " + e.getMessage());
		}
		

	}

}
