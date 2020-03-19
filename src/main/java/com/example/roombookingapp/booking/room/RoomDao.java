package com.example.roombookingapp.booking.room;

import com.example.roombookingapp.booking.guest.Guest;
import com.example.roombookingapp.booking.room.Room;
import com.example.roombookingapp.booking.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDao {

    @Autowired
    private RoomRepository repository;

    public void createRoom(Room room) {
        repository.save(room);
    }

    public List<Room> getRoom() {
        return repository.findAll();
    }

    public void updateRoom(Room room) {
        repository.save(room);
    }

    public void delete(Room room){ repository.delete(room);}


}
