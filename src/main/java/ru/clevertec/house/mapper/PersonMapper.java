package ru.clevertec.house.mapper;

import org.mapstruct.Mapper;
import ru.clevertec.house.dto.request.RequestPersonDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.entity.Person;

@Mapper
public interface PersonMapper {

    ResponsePersonDto personToDto(Person person);

    Person dtoToPerson(RequestPersonDto requestPersonDto);
}
