package com.hms.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "roomcount")
    private Integer roomcount;

    @Column(name = "name")
    private String name;

    @Column(name = "booking_date")
    private LocalDate booking_date;

    private LocalDateTime cheackinDate;

    @Column(name = "cheackout_date")
    private LocalDateTime cheackoutDate;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheackoutDate() {
        return cheackoutDate;
    }

    public void setCheackoutDate(LocalDateTime cheackoutDate) {
        this.cheackoutDate = cheackoutDate;
    }

    public LocalDateTime getCheackinDate() {
        return cheackinDate;
    }

    public void setCheackinDate(LocalDateTime cheackinDate) {
        this.cheackinDate = cheackinDate;
    }

    public LocalDate getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDate booking_date) {
        this.booking_date = booking_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(Integer roomcount) {
        this.roomcount = roomcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}