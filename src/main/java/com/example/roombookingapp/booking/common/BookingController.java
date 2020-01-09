//package com.example.roombookingapp.booking.common;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.sql.SQLOutput;
//@Slf4j
//@RestController
//@RequestMapping("booking")
//public class BookingController {
//
//    private BookingService bookingService;
//
//    public BookingController(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }
//
//    @PostMapping(value = "/add")
//    public ModelAndView saveBooking(@ModelAttribute(value = "booking") Booking booking) {
//        log.info("attempting do add anew booking()!");
//
//        Booking bookingToAdd = new Booking();
//        bookingToAdd.setId(booking.getId());
//        return new ModelAndView("/add_booking", "bookingToAdd", bookingToAdd);
//    }
//}
