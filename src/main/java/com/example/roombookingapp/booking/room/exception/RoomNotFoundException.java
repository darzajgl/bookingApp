package com.example.roombookingapp.booking.room.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {super("Room with id: ["+id+"] not found");}

    public RoomNotFoundException(Integer number) {super("Room with number: ["+number+"] not found");}
}
