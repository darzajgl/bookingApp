package com.example.roombookingapp.booking.guest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

//klasa transportowa - transfer danych bez ich modyfikacji
@Slf4j
@RestController
@RequestMapping("guest")
public class GuestController {

    private final GuestApi guestApi;

    public GuestController(GuestApi guestApi) {
        this.guestApi = guestApi;
    }

    @RequestMapping("/")
    public String indexGet(){return "index";}

    @RequestMapping(value = "/guestform", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("guest", new Guest());
        return "guest/guestform";
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
        //              :: można przypisać metodę do zmiennej bez jej wywoływania
        return guestApi.getByEmail(email).stream()
                .map(GuestDto::from)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView add(@ModelAttribute(value = "guest") Guest guestDto) {
        log.info("attempting do create guest with guestDto:[{}]!", guestDto);
        guestApi.add(guestDto);

        return new ModelAndView("redirect:/guest/getAll");
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        log.info("attempting do delete guest with Id:[{}]!", id);
        guestApi.delete(id);
    }

}
