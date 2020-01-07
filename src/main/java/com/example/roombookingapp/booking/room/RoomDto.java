package com.example.roombookingapp.booking.room;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Objects;
@Data
@Builder

public class RoomDto {

    private Long id;

    @NotNull
    private int number;

    @NotNull
    private String name;

    @NotNull
    private int capacity;

    @NotNull
    private boolean hasWindow;


    static RoomDto from(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .number(room.getNumber())
                .name(room.getName())
                .capacity(room.getCapacity())
                .hasWindow(room.isHasWindow())
                .build();
    }
}
