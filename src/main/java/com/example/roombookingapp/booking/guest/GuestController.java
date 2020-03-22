package com.example.roombookingapp.booking.guest;

import com.example.roombookingapp.booking.room.Room;
import com.example.roombookingapp.booking.room.RoomDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//klasa transportowa - transfer danych bez ich modyfikacji
//@Slf4j
//@RestController
//@RequestMapping("guest")
@Controller
public class GuestController {

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private RoomDao roomDao;

    private List<Room> roomList;
    private List<Guest> list = new ArrayList<>();

    public GuestController() {
    }

//    private final GuestApi guestApi;
//    public GuestController(GuestApi guestApi) {
//        this.guestApi = guestApi;
//    }

    @RequestMapping("/")
    public String indexGet() {
        return "index";
    }

    @RequestMapping(value = "/guestform", method = RequestMethod.GET)
    public String showform(Model model) {
        roomList = roomDao.getRoom();
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : roomList) {
            if ( room.getGuest() == null ){
                freeRooms.add(room);
            }
        }

        model.addAttribute("guest", new Guest());
        model.addAttribute("roomList", freeRooms);
//        model.addAttribute("roomId", new ArrayList<>());
        return "guestform";
    }

    @GetMapping("/getAll")
//    public List<GuestDto> getAll()
    public ModelAndView viewguests(Model model) {
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
    public ModelAndView add(@ModelAttribute(value = "guest") Guest guestDto,
                            @ModelAttribute(value = "roomId") String roomId)
    {
//        log.info("attempting do create guest with guestDto:[{}]!", guestDto);
//        guestApi.add(guestDto);
        int room_id = Integer.parseInt(roomId);
        List<Room> roomList = roomDao.getRoom();
        List<Guest> guestList = guestDao.getGuests();
        int size = guestList.size();
        Long lastId = guestList.get(size-1).getId();
        guestDto.setRoom(roomList.get(room_id-201));
        if (guestDto.getId() == null) {
            guestDto.setId(lastId + 1);
            guestDao.createGuest(guestDto);
            guestDto.setId((long) list.size());
            list.add(guestDto);
        } else {
            roomList = roomDao.getRoom();
            int index = Math.toIntExact(guestDto.getId());
            guestDto.setRoom(roomList.get(index));
            guestDao.updateGuest(guestDto);
            list.set((int) (guestDto.getId() - 1), guestDto);
            updateGuestInList(guestDto);
        }
        return new ModelAndView("redirect:/getAll");
    }


    private void updateGuestInList(Guest guest) {
        Guest guestTemp = getGuestById(Math.toIntExact(guest.getId()));
        guestTemp.setName(guest.getName());
        guestTemp.setEmail(guest.getEmail());
        guestTemp.setGoldMember(guest.getGoldMember());
        guestTemp.setCheckInDate(guest.getCheckInDate());
        guestTemp.setCheckOutDate(guest.getCheckOutDate());

    }

//
//    @DeleteMapping("/delete")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(Long id) {
//        log.info("attempting do delete guest with Id:[{}]!", id);
//        guestApi.delete(id);
//    }

    @RequestMapping(value = "/delete_guest", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "guest_id") String guest_id) {
        Guest guestToDelete = getGuestById(Integer.parseInt(guest_id));
        list.remove(guestToDelete);
        guestDao.delete(guestToDelete);
        return new ModelAndView("redirect:/viewguest");
    }
    @RequestMapping(value = "/edit_guest")
    public ModelAndView edit(@RequestParam(value = "guest_id") String guest_id) {
        System.out.printf("get guest with id:", guest_id);
       Guest guest = getGuestById(Integer.parseInt(guest_id));

        return new ModelAndView("guestform", "guest", guest);
    }



    private Guest getGuestById(@RequestParam int guest_id) {
        return list.stream().filter(f -> f.getId() == guest_id).findFirst().get();
    }

}
