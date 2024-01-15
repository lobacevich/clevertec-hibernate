package ru.clevertec.house.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.clevertec.house.dao.HouseDao;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.entity.Person;
import ru.clevertec.house.mapper.PersonRowMapper;

import java.util.List;

@Repository
public class HouseDaoImpl extends AbstractDao<House> implements HouseDao {

    public static final String GET_RESIDENTS = "SELECT * FROM persons WHERE house_id = ?";

    @Autowired
    private PersonRowMapper personDtoRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HouseDaoImpl() {
        super(House.class);
    }

    @Override
    public List<Person> getResidents(Long houseId) {
        Object[] args = {houseId};
        return jdbcTemplate.query(GET_RESIDENTS, personDtoRowMapper, args );
    }
}
