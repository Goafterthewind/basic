package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class BasicApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return args -> {
		};
	}
	
	@Bean
	public ApplicationRunner appRunner() {
		return args -> {
		};
	}
	@Autowired
	private CounterService counterService;
	
	@Bean
	public ApplicationListener<ApplicationEvent> xyzListener() {
		final String HELLO_URL = "/xyz";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					counterService.increment("xyz.hits");
			}
		};
	}
	@Bean
	public HealthIndicator myHealth() {
		return () -> {
			RestTemplate restTemplate = new RestTemplate();
			try {
				String string = restTemplate.getForObject("https://www.taobao.com", String.class);
				return Health.up().build();
			} catch (Exception e) {
				return Health.down().withDetail("Error Code", 404).build();
			}
		};
	}
}
