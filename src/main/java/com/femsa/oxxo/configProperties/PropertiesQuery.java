package com.femsa.oxxo.configProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@PropertySource("classpath:application-query.properties")
@ConfigurationProperties(prefix = "query")
@NoArgsConstructor
@AllArgsConstructor

@Data
public class PropertiesQuery {
	private String tdgTicketsSelect;
}
