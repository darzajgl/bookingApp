package com.example.roombookingapp.booking.guest;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
//DAO -Data Access Object
public interface GuestApi {

//    void saveGuest(Guest guestDto);

    List<Guest> getAll();

    Guest get(Long id);

    List<Guest> getByEmail(String email);

    Guest add(Guest guestDto);

    void delete(Long id);
}
