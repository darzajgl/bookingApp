package com.example.roombookingapp.booking.room;

import com.example.roombookingapp.booking.room.exception.RoomNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class RoomService implements RoomApi {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAll() {
        log.info("attempting do get all rooms");
        return StreamSupport.stream(roomRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Room get(Long id) {
        log.info("attempting do get room with Id:[{}]", id);
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
    public Room create(RoomDto roomDto) {
        log.info("attempting do create new room: ", roomDto);
        return roomRepository.save(Room.builder()
                .id(roomDto.getId())
                .number(roomDto.getNumber())
                .name(roomDto.getName())
                .capacity(roomDto.getCapacity())
                .hasWindow(roomDto.isHasWindow())
                .build());
    }




    @Override
    public void delete(Long id) {
        log.info("attempting do delete room with Id:[{}]", id);
        Room roomToDelete = this.get(id);
        roomRepository.delete(roomToDelete);

    }
}
