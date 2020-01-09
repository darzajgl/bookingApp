package com.example.roombookingapp.booking.guest;

import com.example.roombookingapp.booking.guest.exception.GuestNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class GuestService implements GuestApi {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> getAll() {
        log.info("attempting do get all guests");
        return StreamSupport.stream(guestRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Guest get(Long id) {
        log.info("attempting do get guest with Id:[{}]", id);
        return guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException(id));
    }

    @Override
    public List<Guest> getByEmail(String email) {
        log.info("attempting do get guest with email:[{}]", email);
        List<Guest> guestList = guestRepository.findGuestByEmail(email);

        if (guestList.isEmpty()) {
            throw new GuestNotFoundException(email);
        }

        return guestList;
    }

    @Override
    public Guest create(GuestDto guestDto) {
        log.info("attempting do create new guest");
        return guestRepository.save(Guest.builder()
                .id(guestDto.getId())
                .name(guestDto.getName())
                .email(guestDto.getEmail())
                .checkInDate(guestDto.getCheckInDate())
                .checkOutDate(guestDto.getCheckOutDate())
                .build());
    }

    @Override
    public void delete(Long id) {
        log.info("attempting do delete guest with id:[{}]", id);
        Guest guestToDelete = this.get(id);
        guestRepository.delete(guestToDelete);

    }
}
