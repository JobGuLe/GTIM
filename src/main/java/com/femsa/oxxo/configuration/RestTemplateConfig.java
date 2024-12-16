package com.femsa.oxxo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
	 * Configuracion de RestTemplate 
	 */
	@Configuration
	public class RestTemplateConfig {
		private static final Logger log = LoggerFactory.getLogger(RestTemplateConfig.class);


	    @Bean
	    RestTemplate restTemplate() {
			return new RestTemplate();
		}	
	
	}
	

