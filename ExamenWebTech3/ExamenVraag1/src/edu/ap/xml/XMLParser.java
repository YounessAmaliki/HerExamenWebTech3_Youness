package edu.ap.xml;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {

	private String INPUTFILE = "producten.xml";

	
	/**
	 * Get all products from the xml file and return them in html format
	 */
	public String getProducten() {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>Producten</h2>";

			NodeList producten = doc.getElementsByTagName("product");

			for (int i = 0; i < producten.getLength(); i++) {
				Node nNode = producten.item(i);
				Element eElement = (Element) nNode;

				result += "<br/><b>Naam klant: </b>" + eElement.getAttribute("naamKlant");
				result += "<br/><b>Datum bestelling : </b>" + eElement.getAttribute("datumBestelling");
				result += "<br/><b>Naam product : </b>" + eElement.getAttribute("naamProduct");
				result += "<br/><b>Hoeveelheid : </b>" + eElement.getAttribute("Hoeveelheid");
				result += "<br/><b>Opmerking : </b>" + eElement.getElementsByTagName("opmerking").item(0).getTextContent();
				result += "<br/>";
			}
			
		 

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	/**
	 * Add a product
	 */
	public String addProduct(String xml) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// set validating false to enable copying
		// node from one document to another
		dbFactory.setValidating(false);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
			Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
			Element element = (Element) doc2.getDocumentElement();
			// imports a node from doc2 document to doc1, without altering
			// or removing the source node from the original document
			Node copiedNode = doc1.importNode(element, true);
			// adds the node to the end of the list of children of this node
			doc1.getDocumentElement().appendChild(copiedNode);

			/*
			 * FileWriter fw = new FileWriter(INPUTFILE);
			 * fw.write(doc1.toString()); fw.close();
			 */
			// write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);

			return this.getProducten();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
