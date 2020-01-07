package com.example.roombookingapp.booking.room;

import java.util.List;

public interface RoomApi {

    List<Room> getAll();

    Room get(Long id);

    List<Room> getByNumber(Integer number);

    Room create(RoomDto roomDto);

    void delete(Long id);
}
