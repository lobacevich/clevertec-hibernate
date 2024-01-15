package ru.clevertec.house.service.Impl;

import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.entity.House;

import java.time.LocalDateTime;
import java.util.UUID;

public class HouseServiceTestData {

    public static ResponseHouseDto getResponceDto() {
        return ResponseHouseDto.builder()
                .uuid(UUID.fromString("bfaccee5-2b5c-4a27-944a-0a53a699e3b6"))
                .area("Area")
                .country("Country")
                .city("City")
                .street("Street")
                .number(20)
                .createDate(LocalDateTime.parse("2018-08-29T06:12:15.156"))
                .build();
    }

    public static House getHouse() {
        House house = new House();
        house.setId(1L);
        house.setUuid(UUID.fromString("bfaccee5-2b5c-4a27-944a-0a53a699e3b6"));
        house.setArea("Area");
        house.setCountry("Country");
        house.setCity("City");
        house.setStreet("Street");
        house.setNumber(20);
        house.setCreateDate(LocalDateTime.parse("2018-08-29T06:12:15.156"));
        return house;
    }

    public static RequestHouseDto getRequestDto() {
        return RequestHouseDto.builder()
                .uuid(UUID.fromString("bfaccee5-2b5c-4a27-944a-0a53a699e3b6"))
                .area("Area")
                .country("Country")
                .city("City")
                .street("Street")
                .number(20)
                .build();
    }

    public static UUID getUuid() {
        return UUID.fromString("bfaccee5-2b5c-4a27-944a-0a53a699e3b6");
    }
}
