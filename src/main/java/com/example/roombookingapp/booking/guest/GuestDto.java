package com.example.roombookingapp.booking.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {

    @NotNull
    private String name;

    @Email
    @NotNull
    private int goldMember;

    @NotNull
    private String email;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;


    static GuestDto from(Guest guest) {
        return GuestDto.builder()
                .name(guest.getName())
                .goldMember(guest.getGoldMember())
                .email(guest.getEmail())
                .checkInDate(guest.getCheckInDate())
                .checkOutDate(guest.getCheckOutDate())
                .build();
    }
}
