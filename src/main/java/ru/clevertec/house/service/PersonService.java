package ru.clevertec.house.service;

import ru.clevertec.house.dto.request.RequestPersonDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    ResponsePersonDto findByUuid(UUID uuid);

    List<ResponsePersonDto> findAll(int pageSize, int pageNumber);

    ResponsePersonDto save(RequestPersonDto dto);

    ResponsePersonDto update(RequestPersonDto dto);

    void delete(UUID uuid);

    List<ResponseHouseDto> getOwnedHouses(UUID personUuid, int pageSize, int pageNumber);
}
