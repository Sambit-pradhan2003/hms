package com.hms.repo;

import com.hms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE " +
            "(:minPrice IS NULL OR r.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR r.price <= :maxPrice) AND " +
            "(:bedCount IS NULL OR r.bedcount = :bedCount) AND " +
            "(:type IS NULL OR r.type = :type) AND " +
            "(:startDate IS NULL OR :endDate IS NULL OR (r.avl_date BETWEEN :startDate AND :endDate))")
    List<Room> searchRooms(
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("bedCount") Integer bedCount,
            @Param("type") String type,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}