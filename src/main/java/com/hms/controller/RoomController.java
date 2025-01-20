package com.hms.controller;

import com.hms.entity.Room;
import com.hms.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
    private RoomService     roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/getall")
    public List<Room> getAllRooms() {
        return roomService.findAllroom();
    }
    @PostMapping("/addroom")
    public Room addRoom(@RequestBody Room room,@RequestParam Long id) {
        return roomService.createroom(room, id);
    }

//    @GetMapping("/search")
//    public List<Room> searchRooms(
//            @RequestParam(required = false) Double minPrice,
//            @RequestParam(required = false) Double maxPrice,
//            @RequestParam(required = false) Integer avilrooms,
//            @RequestParam(required = false) String type,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
//
//        return roomService.searchroom( minPrice, maxPrice, avilrooms, type, startDate, endDate);
//    }

}
