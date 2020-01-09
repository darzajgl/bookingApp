package com.example.roombookingapp.booking.guest.exception;

public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException(Long id) {
        super("Guest with id: [" + id + "] not found");
    }

    public GuestNotFoundException(String email) {
        super("Guest with email: [" + email + "] not found");
    }

}
