package com.example.roombookingapp.booking.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    private Long id;

    private String name;

    private String email;

    private boolean goldMember;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

}
