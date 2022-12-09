package ru.rsreu.kibamba.clientserverapplw.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.rsreu.kibamba.clientserverapplw.models.Dorm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DormMapper implements RowMapper<Dorm> {

    @Override
    public Dorm mapRow(ResultSet rs, int i)  throws SQLException {
        Dorm dorm = new Dorm();
        dorm.setId(rs.getInt("dorm_number"));
        dorm.setAddress(rs.getString("dorm_adress"));
        dorm.setNumberLivingRooms(rs.getInt("number_living_rooms"));
        return dorm;
    }
}
