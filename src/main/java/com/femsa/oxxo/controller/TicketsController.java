package com.femsa.oxxo.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketsController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/tickets")
	public List<Map<String, Object>> testDatabaseConnection(){
		String sql = "SELECT * FROM tpeuser.tdg_tickets";
		return jdbcTemplate.queryForList(sql);
		
	}
}