package com.jaxbdemo.springbootwithjaxb.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaxbdemo.springbootwithjaxb.model.Customer;

public class DataProvider {
	
	public static List<Customer> getData(String size) throws IOException{
		StopWatchUtil stopWatch = new StopWatchUtil().start("Getting Data From File");
		
		String fileName = "data/customers";
		
		if(size.equalsIgnoreCase("Large"))
			fileName = fileName+"Large.json";
		else
			fileName = fileName+".json";
		
		Path path = Paths.get(fileName);
		byte[] allDataInBytes = Files.readAllBytes(path);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(allDataInBytes);
		
		JsonNode resultNode = rootNode.path("result");
		
		Iterator<JsonNode> resultChildElements = resultNode.elements();
		
		Customer cust = null;
		List<Customer> listOfCusts = new ArrayList<>();
		
		while(resultChildElements.hasNext()) {
			JsonNode element = resultChildElements.next();
			cust = mapper.readValue(element.toString(), Customer.class);
			listOfCusts.add(cust);
		}
		
		System.out.println("Returning "+listOfCusts.size()+" number of elements");
		
		stopWatch.stop();
		return listOfCusts;
	}
}
