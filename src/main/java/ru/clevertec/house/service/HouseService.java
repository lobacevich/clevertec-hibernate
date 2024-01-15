package ru.clevertec.house.service;

import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;

import java.util.List;
import java.util.UUID;

public interface HouseService {

    ResponseHouseDto findByUuid(UUID uuid);

    List<ResponseHouseDto> findAll(int pageSize, int pageNumber);

    ResponseHouseDto save(RequestHouseDto dto);

    ResponseHouseDto update(RequestHouseDto dto);

    void delete(UUID uuid);

    List<ResponsePersonDto> getResidents(UUID houseUuid, int pageSize, int pageNumber);
}
