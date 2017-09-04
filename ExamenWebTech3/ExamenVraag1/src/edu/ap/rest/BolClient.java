package edu.ap.rest;

import org.restlet.resource.ClientResource;

public class BolClient {

	public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8081/warenhuis/producten");
       	// Post a new product
       	String product1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	product1 += "<product id=\"3\" naamKlant=\"Jones\" datumBestelling=\"19/04/2017\" naamProduct=\"Router\" hoeveelheid=\"2\">";
       	product1 += "<opmerking>Snel</opmerking>";
       	product1 += "</product>";
   		resource.post(product1);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       	String product2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	product2 += "<product id=\"4\" naamKlant=\"Bart\" datumBestelling=\"19/06/2017\" naamProduct=\"PS4\" hoeveelheid=\"15\">";
       	product2 += "<opmerking>op gemak</opmerking>";
       	product2 += "</product>";
   		resource.post(product2);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }

	}

}


