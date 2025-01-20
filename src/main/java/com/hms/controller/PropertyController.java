package com.hms.controller;

import com.hms.entity.Property;
import com.hms.entity.Room;
import com.hms.service.PropertyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    private PropertyService     propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/getall")
    public List<Property>getProperties() {
        return propertyService.getAllProperties();
    }

    @PostMapping("/addproperty")
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @GetMapping("/propertysearch")
    public ResponseEntity<List<Property>> searchProperties(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String propertyName) {

        List<Property> results = propertyService.searchProperties(startDate, endDate, city, propertyName);
        return ResponseEntity.ok(results);
    }
}
