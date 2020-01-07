package com.example.roombookingapp.booking.guest;

import java.util.List;

public interface GuestApi {

    List<Guest> getAll();

    Guest get(Long id);

    List<Guest> getByEmail(String email);

    Guest create (GuestDto guestDto);

    void delete(Long id);
}
