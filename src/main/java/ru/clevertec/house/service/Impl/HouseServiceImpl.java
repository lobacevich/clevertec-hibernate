package ru.clevertec.house.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.house.dao.HouseDao;
import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.exception.EntityNotFoundException;
import ru.clevertec.house.mapper.HouseMapper;
import ru.clevertec.house.mapper.PersonMapper;
import ru.clevertec.house.service.HouseService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public ResponseHouseDto findByUuid(UUID uuid) {
        return houseMapper.houseToDto(findHouseByUuid(uuid));
    }

    @Override
    public List<ResponseHouseDto> findAll(int pageSize, int pageNumber) {
        return houseDao.findAll().stream()
                .map(houseMapper::houseToDto)
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseHouseDto save(RequestHouseDto dto) {
        return houseMapper.houseToDto(houseDao.save(houseMapper.dtoToHouse(dto)));
    }

    @Override
    @Transactional
    public ResponseHouseDto update(RequestHouseDto dto) {
        House oldHouse = findHouseByUuid(dto.getUuid());
        House houseToUpdate = houseMapper.dtoToHouse(dto);
        houseToUpdate.setId(oldHouse.getId());
        houseToUpdate.setCreateDate(oldHouse.getCreateDate());
        return houseMapper.houseToDto(houseDao.update(houseToUpdate));
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        houseDao.delete(findHouseByUuid(uuid));
    }

    @Override
    public List<ResponsePersonDto> getResidents(UUID houseUuid, int pageSize, int pageNumber) {
        Long id = findHouseByUuid(houseUuid).getId();
        return houseDao.getResidents(id).stream()
                .map(personMapper::personToDto)
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    private House findHouseByUuid(UUID uuid) {
        return houseDao.findByUuid(uuid).orElseThrow(
                () -> new EntityNotFoundException(uuid + " not found"));
    }
}
