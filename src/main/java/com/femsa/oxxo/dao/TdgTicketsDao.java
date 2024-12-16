package com.femsa.oxxo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.femsa.oxxo.configProperties.PropertiesQuery;
import com.femsa.oxxo.entity.TdgTickets;

@Component
public class TdgTicketsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PropertiesQuery prop;

    public List<TdgTickets> tdgTickets() {
        return jdbcTemplate.query(prop.getTdgTicketsSelect(), new RowMapper<TdgTickets>() {
            @Override
            public TdgTickets mapRow(ResultSet rs, int rowNum) throws SQLException {
                
                return null;
            }
        });
    }
}
