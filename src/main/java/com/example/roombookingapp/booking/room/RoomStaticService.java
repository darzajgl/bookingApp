package com.example.roombookingapp.booking.room;

import com.example.roombookingapp.booking.room.exception.RoomNotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RoomStaticService implements RoomApi {

    private static List<Room> roomLista = new ArrayList<Room>();

    public RoomStaticService() {
        roomLista.add(new Room(999L, 1001, "Poznan", 30, true));
        roomLista.add(new Room(888L, 1411, "Bialystok", 13, false));
    }

    @Override
    public List<Room> getAll() {
        log.info("attempting do get all rooms - static");
        return roomLista;
    }

    @Override

    public Room get(Long id) {
        log.info("attempting do get room with Id:[{}] - static", id);
        for (Room room : roomLista) {
            if (room.getId() == id) {
                return room;
            }
        }
        log.info("nonono room with Id:[{}] - static", id);
        return null;
    }

    @Override
    public List<Room> getByNumber(Integer number) {
        log.info("attempting do get room with number:[{}] - static", number);
        List<Room> roomLista = new ArrayList<>();
        for (Room room : roomLista) {
            if (room.getNumber() == number) {
                roomLista.add(new Room(room.getId(), room.getNumber(), room.getName(), room.getCapacity(), room.isHasWindow()));
            }
            return roomLista;
        }
        log.info("no room with number:[{}] - static", number);
        return null;
    }

    @Override
    public Room create(RoomDto roomDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        for (Room room : roomLista) {
            if (room.getId() == id) {
                roomLista.remove(room);
                break;
            }
        }
    }

}
