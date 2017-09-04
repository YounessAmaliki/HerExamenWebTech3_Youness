package edu.ap.rest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.json.JSONFactory;

public class ProductenResource extends ServerResource {
	private static final String FILENAME = "C:/Users/kiosk/Desktop/producten.json";
	
	@Get("txt")
	public String getProducten() {
		return JSONFactory.allProducten();
	}
	
	@Post("txt")
	public void addProduct(String json) throws JSONException {
		JSONObject product = new JSONObject(json);
		product.getString("Naam");
		product.getString("Producent");
		product.getString("Prijs");
		
				
		try {
			File file=new File(FILENAME);
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bf=new BufferedWriter(fw);
			PrintWriter pr=new PrintWriter(bf);
			pr.print(product.toString());
			pr.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		
	
		
	}
}
