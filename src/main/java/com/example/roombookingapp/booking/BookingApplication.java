package com.example.roombookingapp.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.roombookingapp.booking.guest",
        "com.example.roombookingapp.booking.room",
//        "com.example.roombookingapp.booking.common"
})
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

}
