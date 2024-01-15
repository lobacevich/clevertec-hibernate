package ru.clevertec.house.entity.enums;

import jakarta.persistence.Table;

@Table(name = "person_sex")
public enum PersonSex {
    MALE,
    FEMALE
}
