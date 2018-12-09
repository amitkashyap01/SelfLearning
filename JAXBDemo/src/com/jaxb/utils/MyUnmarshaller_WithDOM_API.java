package com.jaxb.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.jaxb.model.PurchaseOrder;

public class MyUnmarshaller_WithDOM_API {
	
	public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(PurchaseOrder.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		//Read XML using the DOM API
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(new File("src/com/jaxb/utils/purchaseOrder.xml"));
		
		JAXBElement<PurchaseOrder> jaxbElement = unmarshaller.unmarshal(document.getDocumentElement(),
						PurchaseOrder.class);
	
		PurchaseOrder purchaseOrder = jaxbElement.getValue();
		
		System.out.println("Purchase order for: "+ purchaseOrder.getCustomer().getName());
	}
}
