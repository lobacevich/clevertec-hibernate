package ru.clevertec.house.dao.impl;

import org.springframework.stereotype.Repository;
import ru.clevertec.house.dao.PersonDao;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.entity.Person;

import java.util.List;

@Repository
public class PersonDaoImpl extends AbstractDao<Person> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }
}
