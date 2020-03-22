package com.example.roombookingapp.booking.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RoomDto {

    @NotNull
    private int number;

    @NotNull
    private String name;

    @NotNull
    private int capacity;

    @NotNull
    private int hasWindow;

    static RoomDto from(Room room) {
        return RoomDto.builder()
                .number(room.getNumber())
                .name(room.getName())
                .capacity(room.getCapacity())
                .hasWindow(room.getHasWindow())
                .build();
    }
}