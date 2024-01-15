package ru.clevertec.house.entity.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import ru.clevertec.house.entity.Person;

import java.time.LocalDateTime;
import java.util.UUID;

public class PersonListener {

    @PrePersist
    public void prePersist(Person person) {
        person.setUuid(UUID.randomUUID());
        person.setCreateDate(LocalDateTime.now());
        person.setUpdateDate(person.getCreateDate());
    }

    @PreUpdate
    public void preUpdate(Person person) {
        person.setUpdateDate(LocalDateTime.now());
    }
}
