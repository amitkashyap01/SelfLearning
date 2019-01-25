package com.jaxbdemo.springbootwithjaxb;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jaxbdemo.springbootwithjaxb.model.Customer;
import com.jaxbdemo.springbootwithjaxb.util.DataProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTests {

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
	public void contextLoads() throws JsonParseException, IOException {
		Path path = Paths.get("data/customers.json");
		byte[] filedata = Files.readAllBytes(path);

		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jsonParser = jsonFactory.createParser(filedata);


		try{
			String str;
			while((str = jsonParser.nextToken().asString())!=null) {
				System.out.println(str);
				jsonParser.nextToken();
			}

		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}


	@Test
	public void simpleWriteOpration() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			mapper.writeValue(new File("data/MySampleJson.json"), customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void simpleReadOpration() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode jsonNode = mapper.readTree(new File("data/customers.json"));
			JsonNode resultNode = jsonNode.findValue("result");
			Iterator<JsonNode> resultNodeIterator=resultNode.elements();

			while(resultNodeIterator.hasNext()) {
				JsonNode value = resultNodeIterator.next();
				System.out.println(value.asText());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Test
	public void writeAJsonUsingSteamingApi() throws IOException {
		/*
		 {  
			   "name":"Tom",
			   "age":25,
			   "address":[  
			      "Poland",
			      "5th avenue"
			   ]
			}
		 */
		
		//Let's say we need to write above json to output steam.
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		JsonFactory factory = new JsonFactory();
		JsonGenerator generator = factory.createGenerator(stream, JsonEncoding.UTF8);
		
		generator.writeStartObject();
		generator.writeStringField("name", "Tom");
		generator.writeNumberField("age", 25);
		generator.writeFieldName("Address");
		generator.writeStartArray();
		generator.writeString("Poland");
		generator.writeString("5th avenue");
		generator.writeEndArray();
		generator.writeEndObject();
		generator.close();
		
		String json = new String(stream.toByteArray(), "UTF-8");
		System.out.println(json);
	}
	
	@Test
	public void readJsonUsingStreamingApi() throws JsonParseException, IOException {
		String json
		  = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
		
		JsonFactory factory = new JsonFactory();
		JsonParser jsonParser = factory.createParser(json);
		
		while(jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = jsonParser.getCurrentName();
			
			System.out.println(fieldName);
			
			
			System.out.println(jsonParser.getText());
		}
	}
	
	@Test
	public void readingJsonFileIntoAMapUsingJackson() throws IOException {
		Path myPath = Paths.get("data/customers.json");
		byte[] myData = Files.readAllBytes(myPath);
		
		Map<String, String> myMap = new HashMap<>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		myMap = objectMapper.readValue(myData, HashMap.class);
		
		System.out.println(myMap.size());
		
	}
	
	@Test
	public void readingJsonFileInTreeUsingJackson() throws IOException {
		byte [] mydata = Files.readAllBytes(Paths.get("data/customers.json"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode rootNode = mapper.readTree(mydata);
		
		JsonNode resultNode = rootNode.path("result");
		
		Iterator<JsonNode> resultChild = resultNode.elements();
		
		Customer cust = null;
		List<Customer> listOfCusts = new ArrayList<>();
		while(resultChild.hasNext()) {
			cust = mapper.readValue(resultChild.next().toString(), Customer.class);
			listOfCusts.add(cust);
		}
		
		System.out.println(listOfCusts.size());
		
	}
	
	@Test
	public void readingJsonFileUsingCustomDataProvider() throws IOException {
		
		List<Customer> listOfCust = DataProvider.getData("Large");
		
		listOfCust.forEach(cust -> System.out.println(cust));

	}
}

