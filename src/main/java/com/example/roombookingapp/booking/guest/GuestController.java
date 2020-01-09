package com.example.roombookingapp.booking.guest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("guest")
public class GuestController {

    private final GuestApi guestApi;

    public GuestController(GuestApi guestApi) {
        this.guestApi = guestApi;
    }

    @GetMapping("/getAll")
    public List<GuestDto> getAll() {
        log.info("attempting do get all guests()!");
        return guestApi.getAll().stream()
                .map(GuestDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/get")
    public GuestDto get(Long id) {
        log.info("attempting do get guest with Id:[{}]!", id);
        return GuestDto.from(guestApi.get(id));
    }

    @GetMapping("/getByEmail")
    public List<GuestDto> getByEmail(String email) {
        log.info("attempting do get guest with email:[{}]!", email);
        return guestApi.getByEmail(email).stream()
                .map(GuestDto::from)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDto create(@RequestBody GuestDto guestDto) {
        log.info("attempting do create guest with guestDto:[{}]!", guestDto);
        return GuestDto.from(guestApi.create(guestDto));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        log.info("attempting do delete guest with Id:[{}]!", id);
        guestApi.delete(id);
    }

}
