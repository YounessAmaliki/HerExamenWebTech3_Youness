package edu.ap.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFactory {
	private static final String FILENAME = "C:/Users/kiosk/Desktop/producten.json";
	
	public static String getProduct(String naamproduct) {
		String gevondenProduct = "";
		try {
			FileReader reader = new FileReader(FILENAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject)parser.parse(reader);
			Iterator<?> keys = jsonObject.keys();
			while(keys.hasNext()){
			
			String naam = (String) jsonObject.get("Naam");
			String producent = (String) jsonObject.get("Producent");
			String prijs = (String) jsonObject.get("Prijs");
			
			
			if (naam.equals(naamproduct)) {
				gevondenProduct+= "Product gevonden: " + naamproduct + "\n";
				gevondenProduct += naam  + "\nProducent: "+producent + "\nPrijs: " + prijs;
			}
			else{
				gevondenProduct += "Niets gevonden met naam" + naamproduct;
			}
			keys.next();
			}
			

	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:" + e.getMessage());
		}
		
		return gevondenProduct;
		
	}
	
	public static String allProducten(){
		String producten = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(FILENAME));
			while((line=br.readLine())!=null){
				producten+=line + "\n";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR: " + e.getMessage());
		}
		
		return producten;

	}
}
