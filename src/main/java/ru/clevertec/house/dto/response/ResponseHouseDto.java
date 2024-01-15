package ru.clevertec.house.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseHouseDto {

    private UUID uuid;
    private String area;
    private String country;
    private String city;
    private String street;
    private Integer number;
    private LocalDateTime createDate;
}
