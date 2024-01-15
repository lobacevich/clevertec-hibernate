package ru.clevertec.house.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.entity.House;

@Mapper
public interface HouseMapper {

    ResponseHouseDto houseToDto(House house);

    House dtoToHouse(RequestHouseDto requestHouseDto);
}
