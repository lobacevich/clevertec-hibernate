package ru.clevertec.house.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.house.dao.HouseDao;
import ru.clevertec.house.dao.PersonDao;
import ru.clevertec.house.dto.request.RequestPersonDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.entity.Person;
import ru.clevertec.house.exception.EntityNotFoundException;
import ru.clevertec.house.mapper.HouseMapper;
import ru.clevertec.house.mapper.PersonMapper;
import ru.clevertec.house.service.PersonService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final HouseDao houseDao;
    private final PersonMapper personMapper;
    private final HouseMapper houseMapper;

    @Override
    public ResponsePersonDto findByUuid(UUID uuid) {
        return personMapper.personToDto(findPersonByUuid(uuid));
    }

    @Override
    public List<ResponsePersonDto> findAll(int pageSize, int pageNumber) {
        return personDao.findAll().stream()
                .map(personMapper::personToDto)
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public ResponsePersonDto save(RequestPersonDto dto) {
        Person person = personMapper.dtoToPerson(dto);
        person.setHouse(findHouseByUuid(dto.getHouseResidenceUuid()));
        return personMapper.personToDto(personDao.save(person));
    }

    @Override
    @Transactional
    public ResponsePersonDto update(RequestPersonDto dto) {
        Person oldPerson = findPersonByUuid(dto.getUuid());
        Person personToUpdate = personMapper.dtoToPerson(dto);
        personToUpdate.setId(oldPerson.getId());
        if (dto.getHouseResidenceUuid() == null ||
                dto.getHouseResidenceUuid().equals(oldPerson.getHouse().getUuid())) {
            fillPersonToUpdate(oldPerson, personToUpdate);
            if (oldPerson.equals(personToUpdate)) {
                return personMapper.personToDto(oldPerson);
            } else {
                personToUpdate.setHouse(oldPerson.getHouse());
                return personMapper.personToDto(personDao.update(personToUpdate));
            }
        } else {
            personToUpdate.setHouse(findHouseByUuid(dto.getHouseResidenceUuid()));
            fillPersonToUpdate(oldPerson, personToUpdate);
            return personMapper.personToDto(personDao.update(personToUpdate));
        }
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        personDao.delete(findPersonByUuid(uuid));
    }

    @Override
    @Transactional
    public List<ResponseHouseDto> getOwnedHouses(UUID personUuid, int pageSize, int pageNumber) {
        Person person = findPersonByUuid(personUuid);
        return person.getOwnedHouses().stream()
                .map(houseMapper::houseToDto)
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    private Person findPersonByUuid(UUID uuid) {
        return personDao.findByUuid(uuid).orElseThrow(
                () -> new EntityNotFoundException(uuid + " not found"));
    }

    private House findHouseByUuid(UUID uuid) {
        return houseDao.findByUuid(uuid).orElseThrow(
                () -> new EntityNotFoundException(uuid + " not found"));
    }

    private void fillPersonToUpdate(Person oldPerson, Person personToUpdate) {
        personToUpdate.setId(oldPerson.getId());
        personToUpdate.setCreateDate(oldPerson.getCreateDate());
        personToUpdate.setUpdateDate(oldPerson.getUpdateDate());
    }
}
