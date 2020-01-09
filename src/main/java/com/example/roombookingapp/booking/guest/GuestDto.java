package com.example.roombookingapp.booking.guest;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class GuestDto {

    private Long id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private boolean goldMember;

    @NotNull
    private String email;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;


    static GuestDto from(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId())
                .name(guest.getName())
                .goldMember(guest.isGoldMember())
                .email(guest.getEmail())
                .checkInDate(guest.getCheckInDate())
                .checkOutDate(guest.getCheckOutDate())
                .build();
    }
}
