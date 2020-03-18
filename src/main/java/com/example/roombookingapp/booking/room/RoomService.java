package com.example.roombookingapp.booking.room;

//import com.example.roombookingapp.booking.common.HibernateConfiguration;
import com.example.roombookingapp.booking.room.exception.RoomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//klasa- modyfikacja transferowanych danych
@Slf4j
@Service
public class RoomService implements RoomApi {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

//    @Override
//    public List<Room> getRoom() {
//        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
//            return session.createQuery(" FROM Room", Room.class).list();
//        }
//    }

    @Override
    public List<Room> getAll() {
        log.info("attempting do get all rooms");
        return StreamSupport.stream(roomRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Room get(Long id) {
        log.info("attempting do get room with Id:[{}]", id);
//        CRUD Repository
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Override
    public List<Room> getByNumber(Integer number) {
        log.info("attempting do get room with number:[{}]", number);
        List<Room> roomList = roomRepository.findRoomByNumber(number);

        if (roomList.isEmpty()) {
            throw new RoomNotFoundException(number);
        }
        return roomList;
    }

    @Override
    public Room add(Room roomDto) {
        log.info("attempting to add new room", roomDto);
        return roomRepository.save(roomDto);
    }

    @Override
    public void delete(Long id) {
        log.info("attempting do delete room with Id:[{}]", id);
        Room roomToDelete = this.get(id);
        roomRepository.delete(roomToDelete);

    }
}
