package ru.clevertec.house.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericDao<T> {

    Optional<T> findByUuid(UUID uuid);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);
}
