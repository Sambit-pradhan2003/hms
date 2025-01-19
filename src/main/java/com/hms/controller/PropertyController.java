package com.hms.controller;

import com.hms.entity.Property;
import com.hms.service.PropertyService;
import org.springframework.web.bind.annotation.*;

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
}
