package com.example.roombookingapp.booking.room;

import lombok.*;

import javax.persistence.*;


@Data
@Table(name = "room")
@Entity
@Builder
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    @NonNull
    private int number;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "capacity")
    @NonNull
    private int capacity;

    @Column(name = "has_window")
    @NonNull
    private int hasWindow;

}

