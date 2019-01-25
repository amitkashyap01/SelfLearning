package com.jaxbdemo.springbootwithjaxb;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.jaxbdemo.payment.model.Document;
import com.jaxbdemo.payment.model.FIToFICustomerCreditTransferV07;
import com.jaxbdemo.payment.model.GroupHeader70;
import com.jaxbdemo.springbootwithjaxb.handler.MyValidationErrorHandler;

public class PaymentXSDTestCase {
	
	@Test
	public void startingWithDocumentClass() throws JAXBException {
		Document document = new Document();
		FIToFICustomerCreditTransferV07 customerCreditTransferV07 = new FIToFICustomerCreditTransferV07();
		
		GroupHeader70 groupHeader70 = new GroupHeader70();
		groupHeader70.setMsgId("1234ABCD");
		customerCreditTransferV07.setGrpHdr(groupHeader70);
		
		document.setFIToFICstmrCdtTrf(customerCreditTransferV07);
		
		
		JAXBContext context = JAXBContext.newInstance(FIToFICustomerCreditTransferV07.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(document, new File("data/myPayment.xml"));
	}
	
	@Test
	public void validateXSDBeforeUnmarshalling() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(Document.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new File("xsd/pacs.008.001.07.xsd"));
		
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(new MyValidationErrorHandler());
		
		Document document = (Document)unmarshaller.unmarshal(new File("data/myPayment.xml"));
		System.out.println(document.toString());
	}
	
	
	
}
