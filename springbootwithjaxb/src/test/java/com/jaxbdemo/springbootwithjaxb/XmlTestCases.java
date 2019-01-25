package com.jaxbdemo.springbootwithjaxb;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.jaxbdemo.springbootwithjaxb.handler.MyValidationErrorHandler;
import com.jaxbdemo.springbootwithjaxb.model.Customer;
import com.jaxbdemo.springbootwithjaxb.model.Customers;
import com.jaxbdemo.springbootwithjaxb.util.DataProvider;

public class XmlTestCases {
	
	private Customer customer;

	@Before
	public void cusomterSetup() {
		customer = new Customer();

		customer.setAbout("I am customer");
		customer.setActive(true);
		customer.setAge(12);
		customer.setBalance(BigDecimal.valueOf(12.32));
		customer.setId(122);
		customer.setJoined(new Date());
		customer.setName("Amit");
		customer.setPhone("1232212323");
		System.out.println(customer);
	}
	
	@Test
	public void myFirstMarshallingToStdOut() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Customer.class);		
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(customer, System.out);
	}
	
	@Test
	public void marshallingToAFile() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Customers.class);
		
		List<Customer> listOfCusts = DataProvider.getData("");
		
		Customers customers = new Customers();
		customers.setCustomers(listOfCusts);
		
		Marshaller marshaller = context.createMarshaller();
		
		//For formatting the output
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Path path = Paths.get("data/mycustomers.xml");
		marshaller.marshal(customers, path.toFile());
	}
	
	
	@Test
	public void unmarshallingFromAXmlFile() {
		try {
			JAXBContext context = JAXBContext.newInstance(Customers.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("data/mycustomers.xml");
			Customers customers = (Customers) unmarshaller.unmarshal(file);
			List<Customer> listOfCustmors = customers.getCustomers();
			listOfCustmors.forEach(cust -> System.out.println(cust));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Test
	public void validatingXSDBeforeUnmarshalling() throws SAXException, JAXBException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new File("data/customers.xsd"));
		
		JAXBContext context = JAXBContext.newInstance(Customers.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(new MyValidationErrorHandler());
		
		File file = new File("data/mycustomers.xml");
		Customers customers = (Customers) unmarshaller.unmarshal(file);
		List<Customer> listOfCustmors = customers.getCustomers();
		listOfCustmors.forEach(cust -> System.out.println(cust));
	}
}
