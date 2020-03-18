package com.example.roombookingapp.booking.room;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

//klasa transportowa - transfer danych bez ich modyfikacji
@Slf4j
@Controller
@RequestMapping("room")
public class RoomController {

    private final RoomApi roomApi;

    public RoomController(RoomApi roomApi) {
        this.roomApi = roomApi;
    }

        @GetMapping("getAll")
    public List<RoomDto> getAll() {
        log.info("attempting do get all rooms()!");
        return roomApi.getAll().stream()
//              :: można przyisać metodę do zmiennej bez jej wywoływania
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }
//    @RequestMapping("/viewemroom")
//    public ModelAndView viewroom(Model model) {
//        List<Room> list = roomApi.getRoom();
//        return new ModelAndView("room/getAll", "list", list);
//    }


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

    @RequestMapping(value = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView add(@ModelAttribute(value = "room") Room roomDto) {
        log.info("attempting do create room [{}]!", roomDto);
        roomApi.add(roomDto);
        return new ModelAndView("redirect:/room/getAll");
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        log.info("attempting do delete room with Id:[{}]!", id);
        roomApi.delete(id);
    }

}
