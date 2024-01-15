package ru.clevertec.house.dto.request;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.house.entity.enums.PersonSex;

import java.util.UUID;

@Data
@Builder
public class RequestPersonDto {

    private UUID uuid;
    private String passportSeries;
    private String passportNumber;
    private PersonSex sex;
    private UUID houseResidenceUuid;
}
