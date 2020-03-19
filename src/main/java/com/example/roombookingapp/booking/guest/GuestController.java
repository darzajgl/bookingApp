package com.example.roombookingapp.booking.guest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//klasa transportowa - transfer danych bez ich modyfikacji
//@Slf4j
//@RestController
//@RequestMapping("guest")
@Controller
public class GuestController {

    @Autowired
    private GuestDao guestDao;

    private List<Guest> list = new ArrayList<>();

    public GuestController() {
    }

//    private final GuestApi guestApi;
//    public GuestController(GuestApi guestApi) {
//        this.guestApi = guestApi;
//    }

    @RequestMapping("/")
    public String indexGet(){return "index";}

    @RequestMapping(value = "/guestform", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("guest", new Guest());
        return "guestform";
    }

    @GetMapping("/getAll")
//    public List<GuestDto> getAll()
    public ModelAndView viewguests(Model model){
        list = guestDao.getGuests();

        return new ModelAndView("viewguest", "list", list);

//        log.info("attempting do get all guests()!");
//        return guestApi.getAll().stream()
//                .map(GuestDto::from)
//                .collect(Collectors.toList());
    }

    //    @GetMapping("/get")
//    public GuestDto get(Long id) {
//        log.info("attempting do get guest with Id:[{}]!", id);
//        return GuestDto.from(guestApi.get(id));
//    }
//
//    @GetMapping("/getByEmail")
//    public List<GuestDto> getByEmail(String email) {
//        log.info("attempting do get guest with email:[{}]!", email);
//        //              :: można przypisać metodę do zmiennej bez jej wywoływania
//        return guestApi.getByEmail(email).stream()
//                .map(GuestDto::from)
//                .collect(Collectors.toList());
//    }
//
//    @PostMapping(value = "/add", produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute(value = "guest") Guest guestDto) {
//        log.info("attempting do create guest with guestDto:[{}]!", guestDto);
//        guestApi.add(guestDto);

        if (guestDto.getId() == null) {
            guestDto.setId(Long.valueOf(1));
            try {
                guestDao.createGuest(guestDto);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            list.add(guestDto);
        } else {
            guestDao.updateGuest(guestDto);
            Long index = guestDto.getId();
            guestDto.setId(index);
        }

        return new ModelAndView("redirect:/getAll");
    }
//
//    @DeleteMapping("/delete")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(Long id) {
//        log.info("attempting do delete guest with Id:[{}]!", id);
//        guestApi.delete(id);
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "guest_id") String guest_id) {
        Guest guestToDelete = getGuestById(Integer.parseInt(guest_id));
        list.remove(guestToDelete);
        guestDao.delete(guestToDelete);
        return new ModelAndView("redirect:/getAll");
    }

    private Guest getGuestById(@RequestParam int guest_id) {
        return list.stream().filter(f -> f.getId() == guest_id).findFirst().get();
    }

}
