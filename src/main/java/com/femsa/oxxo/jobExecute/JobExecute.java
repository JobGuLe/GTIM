package com.femsa.oxxo.jobExecute;


import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.femsa.oxxo.configProperties.PropertiesQuery;


@Component
public class JobExecute implements Job{

	@Autowired
	private PropertiesQuery prop;
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            // Consulta a la base de datos
            List<Map<String, Object>> tickets = jdbcTemplate.queryForList(prop.getTdgTicketsSelect());

            if(tickets.isEmpty()) {
            	System.out.println("No se encontraron datos en la tabla tdg_tickets");
            	return;
            }
            // Conversión a JSON
            String ticketsJson = objectMapper.writeValueAsString(tickets);

            // Simulación de preparación para envío
            System.out.println("Datos obtenidos de la tabla tpeuser.tdg_tickets:");
            System.out.println(ticketsJson);

        } catch (JsonProcessingException e) {
            System.err.println("Error al convertir los datos a JSON: " + e.getMessage());
            throw new JobExecutionException("Error al procesar los datos", e);
        } catch (Exception e) {
            System.err.println("Error ejecutando el cron job: " + e.getMessage());
            throw new JobExecutionException("Error al ejecutar el cron job", e);
        }
    }

}
