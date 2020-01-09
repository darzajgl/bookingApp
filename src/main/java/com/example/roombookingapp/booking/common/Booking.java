//package com.example.roombookingapp.booking.common;
//
//import com.example.roombookingapp.booking.guest.Guest;
//import com.example.roombookingapp.booking.room.Room;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.tomcat.jni.Local;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.time.LocalDate;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private long id;
//
//    public Room room;
//
//    public Guest guest;
//
//    private LocalDate checkIn;
//
//    private LocalDate checkOut;
//
//}
