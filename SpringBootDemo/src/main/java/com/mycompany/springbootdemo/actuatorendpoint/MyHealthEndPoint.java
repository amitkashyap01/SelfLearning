package com.mycompany.springbootdemo.actuatorendpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthEndPoint implements HealthIndicator{

	@Override
	public Health health() {
		return Health.up().withDetail("reason", "MyApplication is up and running").build();
	}

}
