package ru.clevertec.house.dao;

import ru.clevertec.house.entity.House;
import ru.clevertec.house.entity.Person;

import java.util.List;

public interface HouseDao extends GenericDao<House> {

    List<Person> getResidents(Long houseId);
}
