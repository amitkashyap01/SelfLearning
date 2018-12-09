package com.jaxb.utils;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.jaxb.model.Address;
import com.jaxb.model.Customer;
import com.jaxb.model.Item;
import com.jaxb.model.Loyalty;
import com.jaxb.model.PurchaseOrder;

public class MyMarshaller {
	
	public static void main(String[] args) throws JAXBException {
		
		PurchaseOrder populatedPurchaseOrder = createPurchaseOrder();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		QName name = new QName(null, "purchaseOrder");
		
		JAXBElement<PurchaseOrder> element = new JAXBElement<PurchaseOrder>(name, PurchaseOrder.class, populatedPurchaseOrder);
		
		marshaller.marshal(element, System.out);
	
	}
	
    private static PurchaseOrder createPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        Item item1 = new Item();
        item1.setProductName("Ballpoint Pen");
        item1.setQuantity(20);
        item1.setPrice(new BigDecimal("8.95"));
        item1.setComment("Blue ink");

        Item item2 = new Item();
        item2.setProductName("Pencil");
        item2.setQuantity(10);
        item2.setPrice(new BigDecimal("2.95"));

        purchaseOrder.setItems(Arrays.asList(item1, item2));

        Customer customer = new Customer();
        customer.setName("John Doe");

        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("Exampleville");
        address.setPostalCode("12345");
        address.setCountry("USA");

        customer.setShippingAddress(address);
        customer.setBillingAddress(address);
        customer.setLoyalty(Loyalty.SILVER);

        purchaseOrder.setCustomer(customer);

        return purchaseOrder;
    }
}
