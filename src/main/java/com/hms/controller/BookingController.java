package com.hms.controller;

import com.hms.entity.Bookings;
import com.hms.service.BookingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private BookingsService bookingsService;

    public BookingController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @GetMapping("/allbookings")
    public List<Bookings> getAllBookings() {
        return bookingsService.getAllBookings();
    }

    @PostMapping("/createbook")
    public Bookings createBooking(Bookings bookings,Long roomid) {
        return bookingsService.createBooking(bookings,roomid);
    }
}
