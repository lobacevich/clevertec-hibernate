package ru.clevertec.house.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.clevertec.house.entity.Person;
import ru.clevertec.house.entity.enums.PersonSex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Person.builder()
                .uuid((UUID) rs.getObject("uuid"))
                .passportSeries(rs.getString("passport_series"))
                .passportNumber(rs.getString("passport_number"))
                .sex(PersonSex.valueOf(rs.getString("sex")))
                .createDate(rs.getTimestamp("create_date").toLocalDateTime())
                .updateDate(rs.getTimestamp("update_date").toLocalDateTime())
                .build();
    }
}
