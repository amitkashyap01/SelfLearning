package com.mycompany.springbootdemo.actuatorendpoint;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Endpoint(id = "mycustom-endpoint")
public class MyCustomEndPoint {

	@ReadOperation
	public SystemDetails getSystemDetails() {
		SystemDetails details = new SystemDetails();
		details.systemTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		System.out.println("DateTime: "+details.systemTime);
		return details;
	}
	
	
	@Data
	public class SystemDetails{
		private String systemTime;
	}
}
