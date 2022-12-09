package ru.rsreu.kibamba.clientserverapplw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import ru.rsreu.kibamba.clientserverapplw.repository.DormRepository;
import ru.rsreu.kibamba.clientserverapplw.mappers.DormMapper;
import ru.rsreu.kibamba.clientserverapplw.models.Dorm;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class DormServiceImpl implements DormRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DormServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private SimpleJdbcCall createDormProc;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.createDormProc = new SimpleJdbcCall(dataSource).withProcedureName("insert_dorm");
    }

    @Override
    public List<Dorm> getAllDorm() {
        return jdbcTemplate.query("SELECT * FROM dorm", new DormMapper());
    }

    @Override
    public Dorm getDormById(int dormId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM dorm WHERE dorm_number=?", new DormMapper(), dormId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateDorm(int dormId, Dorm dorm) {
        jdbcTemplate.update("UPDATE dorm SET dorm_adress = ?, number_living_rooms=? WHERE dorm_number =?", dorm.getAddress(),
                dorm.getNumberLivingRooms(), dormId);
    }

    @Override
    public void createDorm(Dorm dorm) {
        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("dormNumber", dorm.getId())
                .addValue("dormAdress", dorm.getAddress())
                .addValue("numberLivingRooms", dorm.getNumberLivingRooms());
        createDormProc.execute(inParams);
    }

    @Override
    public void deleteDormById(int dormId) {
        jdbcTemplate.update("DELETE FROM dorm WHERE dorm_number=?",dormId);
    }
}
