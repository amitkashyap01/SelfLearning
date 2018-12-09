package com.jaxb.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.jaxb.model.PurchaseOrder;

public class MyUnmarshaller {
	
	public static void main(String[] args) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(PurchaseOrder.class);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		JAXBElement<PurchaseOrder> jaxbElement = unmarshaller
				.unmarshal(new StreamSource(new File("src/com/jaxb/utils/purchaseOrder.xml")),
						PurchaseOrder.class);
	
		PurchaseOrder purchaseOrder = jaxbElement.getValue();
		
		System.out.println("Purchase order for: "+ purchaseOrder.getCustomer().getName());
	}
}
