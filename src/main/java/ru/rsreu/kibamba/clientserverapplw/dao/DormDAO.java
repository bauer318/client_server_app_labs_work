package ru.rsreu.kibamba.clientserverapplw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rsreu.kibamba.clientserverapplw.mappers.DormMapper;
import ru.rsreu.kibamba.clientserverapplw.models.Dorm;

import java.util.List;

@Component
public class DormDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DormDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Dorm> index(){
        return jdbcTemplate.query("SELECT * FROM dorm",new DormMapper());
    }
}
