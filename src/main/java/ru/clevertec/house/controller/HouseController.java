package ru.clevertec.house.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.house.dto.request.RequestHouseDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.service.HouseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseHouseDto> findHouse(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(houseService.findByUuid(UUID.fromString(uuid)));
    }

    @GetMapping
    public ResponseEntity<List<ResponseHouseDto>> findAll(@RequestParam(value = "page_size",
            defaultValue = "15", required = false) int pageSize,
                                                          @RequestParam(value = "page_number",
                                                                  defaultValue = "1", required = false) int pageNumber) {
        return new ResponseEntity<>(houseService.findAll(pageSize, pageNumber), HttpStatus.OK);
    }

    @GetMapping("/residents/{uuid}")
    public ResponseEntity<List<ResponsePersonDto>> getResidents(@PathVariable("uuid") UUID uuid,
                                                                @RequestParam(value = "page_size",
                                                                        defaultValue = "15", required = false) int pageSize,
                                                                @RequestParam(value = "page_number",
                                                                        defaultValue = "1", required = false) int pageNumber) {
        return new ResponseEntity<>(houseService.getResidents(uuid, pageSize, pageNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseHouseDto> saveHouse(@RequestBody RequestHouseDto requestHouseDto) {
        ResponseHouseDto responseHouseDto = houseService.save(requestHouseDto);
        return new ResponseEntity<>(responseHouseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseHouseDto> updateHouse(@PathVariable("uuid") String uuid,
                                                        @RequestBody RequestHouseDto requestHouseDto) {
        requestHouseDto.setUuid(UUID.fromString(uuid));
        ResponseHouseDto responseHouseDto = houseService.update(requestHouseDto);
        return new ResponseEntity<>(responseHouseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteHouse(@PathVariable("uuid") String uuid) {
        houseService.delete(UUID.fromString(uuid));
        return new ResponseEntity<>("House with uuid " + uuid + " has been deleted", HttpStatus.OK);
    }
}
