package com.example.roombookingapp.booking.room;

import java.util.List;

//DAO -Data Access Object
public interface RoomApi {

//    List<Room> getRoom();

    List<Room> getAll();

    Room get(Long id);

    List<Room> getByNumber(Integer number);

    Room add(Room roomDto);

    void delete(Long id);
}
