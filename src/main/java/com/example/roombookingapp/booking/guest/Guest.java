package com.example.roombookingapp.booking.guest;

import com.example.roombookingapp.booking.room.Room;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "guest")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name =  "goldMember")
    private int goldMember;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @OneToOne(mappedBy = "guest")
    private Room room;
}
