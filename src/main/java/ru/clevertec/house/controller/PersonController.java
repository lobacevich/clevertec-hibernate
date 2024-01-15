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
import ru.clevertec.house.dto.request.RequestPersonDto;
import ru.clevertec.house.dto.response.ResponseHouseDto;
import ru.clevertec.house.dto.response.ResponsePersonDto;
import ru.clevertec.house.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponsePersonDto> findHouse(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(personService.findByUuid(UUID.fromString(uuid)));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePersonDto>> findAll(@RequestParam(value = "page_size",
            defaultValue = "15", required = false) int pageSize,
                                                           @RequestParam(value = "page_number",
                                                                   defaultValue = "1", required = false) int pageNumber) {
        return new ResponseEntity<>(personService.findAll(pageSize, pageNumber), HttpStatus.OK);
    }

    @GetMapping("/ownership/{uuid}")
    public ResponseEntity<List<ResponseHouseDto>> getResidents(@PathVariable("uuid") UUID uuid,
                                                               @RequestParam(value = "page_size",
                                                                       defaultValue = "15", required = false) int pageSize,
                                                               @RequestParam(value = "page_number",
                                                                       defaultValue = "1", required = false) int pageNumber) {
        return new ResponseEntity<>(personService.getOwnedHouses(uuid, pageSize, pageNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsePersonDto> saveHouse(@RequestBody RequestPersonDto requestPersonDto) {
        ResponsePersonDto responsePersonDto = personService.save(requestPersonDto);
        return new ResponseEntity<>(responsePersonDto, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponsePersonDto> updateHouse(@PathVariable("uuid") String uuid,
                                                        @RequestBody RequestPersonDto requestPersonDto) {
        requestPersonDto.setUuid(UUID.fromString(uuid));
        ResponsePersonDto responsePersonDto = personService.update(requestPersonDto);
        return new ResponseEntity<>(responsePersonDto, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteHouse(@PathVariable("uuid") String uuid) {
        personService.delete(UUID.fromString(uuid));
        return new ResponseEntity<>("Person with uuid " + uuid + " has been deleted", HttpStatus.OK);
    }
}
