package ru.clevertec.house.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.resolver.MockParameterResolver;
import ru.clevertec.house.dao.HouseDao;
import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.mapper.HouseMapper;
import ru.clevertec.house.mapper.PersonMapper;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockParameterResolver.class)
class HouseServiceImplTest {

    private final RequestHouseDto requestHouseDto = HouseServiceTestData.getRequestDto();
    private final House house = HouseServiceTestData.getHouse();
    private final ResponseHouseDto responseHouseDto = HouseServiceTestData.getResponceDto();
    private final UUID uuid = HouseServiceTestData.getUuid();

    @Mock
    private HouseDao houseDao;

    @Mock
    private HouseMapper houseMapper;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private HouseServiceImpl houseService;

//    @Test
//    void findByUuid() {
//        when(houseDao.findByUuid(uuid)).thenReturn(Optional.of(house));
//        when(houseMapper.houseToDto(house)).thenReturn(responseHouseDto);
//        ResponseHouseDto expected = responseHouseDto;
//
//        ResponseHouseDto actual = houseService.findByUuid(uuid);
//
//        assertEquals(expected, actual);
//    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getResidents() {
    }
}