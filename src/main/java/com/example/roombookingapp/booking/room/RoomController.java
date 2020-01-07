package com.example.roombookingapp.booking.room;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("room")
public class RoomController {

    private final RoomApi roomApi;

    public RoomController(RoomApi roomApi) {
        this.roomApi = roomApi;
    }

    @GetMapping("/getAll")
    public List<RoomDto> getAll() {
        log.info("attempting do get all rooms()!");
        return roomApi.getAll().stream()
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/get")
    public RoomDto get(Long id) {
        log.info("attempting do get room with Id:[{}]!", id);
        return RoomDto.from(roomApi.get(id));
    }

    @GetMapping("/getByNumber")
    public List<RoomDto> getAllByNumber(Integer number) {
        log.info("attempting do get room with number:[{}]!", number);
        return roomApi.getByNumber(number).stream()
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto create(@RequestBody RoomDto roomDto) {
        log.info("attempting do create room with RoomDTO:[{}]!", roomDto);
        return RoomDto.from(roomApi.create(roomDto));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        log.info("attempting do delete room with Id:[{}]!", id);
        roomApi.delete(id);
    }


}
