package com.hms.service;

import com.hms.entity.Property;
import com.hms.repo.PropertyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PropertyService {
    private PropertyRepository  propertyRepository;
    // Constructor injection

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
       return propertyRepository.findAll();
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> searchProperties(LocalDate startDate, LocalDate endDate, String city, String propertyName) {
        return propertyRepository.searchProperties(startDate, endDate, city, propertyName);
    }
}

