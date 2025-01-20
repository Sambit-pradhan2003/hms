package com.hms.service;

import com.hms.entity.Property;
import com.hms.entity.Room;
import com.hms.repo.PropertyRepository;
import com.hms.repo.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private PropertyRepository propertyRepository;

    public RoomService(RoomRepository roomRepository, PropertyRepository propertyRepository) {
        this.roomRepository = roomRepository;
        this.propertyRepository = propertyRepository;
    }

    public List<Room> findAllroom() {
       return roomRepository.findAll();

    }

    public Room createroom(Room room,Long p_id) {
        Property property = propertyRepository.findById(p_id).orElse(null);
        if(property!=null){
            room.setProperty(property);
        }
        return roomRepository.save(room);
    }


//    public List<Room> searchroom(Double minPrice, Double maxPrice, Integer avilrooms, String type,LocalDate startDate, LocalDate endDate) {
//       return roomRepository.searchRooms(minPrice, maxPrice, avilrooms, type, startDate, endDate);
//    }
}
