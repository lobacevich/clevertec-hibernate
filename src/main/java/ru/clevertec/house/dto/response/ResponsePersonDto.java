package ru.clevertec.house.dto.response;

import lombok.Builder;
import lombok.Data;
import ru.clevertec.house.entity.enums.PersonSex;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponsePersonDto {

    private UUID uuid;
    private String passportSeries;
    private String passportNumber;
    private PersonSex sex;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
