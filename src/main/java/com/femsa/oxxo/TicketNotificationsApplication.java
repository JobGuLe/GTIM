package com.femsa.oxxo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.femsa.oxxo")
public class TicketNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketNotificationsApplication.class, args);
	}

}
