package ru.clevertec.house.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequestHouseDto {

    private UUID uuid;
    private String area;
    private String country;
    private String city;
    private String street;
    private Integer number;
}
