package com.hms.service;

import com.hms.entity.Bookings;
import com.hms.repo.BookingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    private BookingsRepository  bookingsRepository;
    public BookingsService(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }


    public List<Bookings> getAllBookings() {
        return bookingsRepository.findAll();
    }

    public Bookings createBooking(Bookings bookings,Long roomid) {
        return bookingsRepository.save(bookings);
    }
}
