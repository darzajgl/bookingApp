package com.example.roombookingapp.booking.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Room {

    @Id
    private Long id;

    private int number;

    private String name;

    private int capacity;

    private boolean hasWindow;

}
