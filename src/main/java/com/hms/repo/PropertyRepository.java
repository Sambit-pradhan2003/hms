package com.hms.repo;

import com.hms.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("SELECT DISTINCT p FROM Property p " +
            "JOIN p.rooms r " +
            "JOIN p.city c " +
            "WHERE r.roomstatus = false " +
            "AND r.avl_date BETWEEN :startDate AND :endDate " +
            "AND (:cityName IS NULL OR c.name = :cityName) " +
            "AND (:propertyName IS NULL OR p.name = :propertyName)")
    List<Property> searchProperties(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("cityName") String cityName,
            @Param("propertyName") String propertyName
    );
}