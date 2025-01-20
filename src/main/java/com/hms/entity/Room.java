package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    private LocalDate avl_date;

    private Double price;

    private Integer  maxguestAllowed;

    @Column(name = "roomstatus", nullable = false)
    private boolean roomstatus;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonIgnore
    private Property property;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getAvl_date() {
        return avl_date;
    }

    public void setAvl_date(LocalDate avl_date) {
        this.avl_date = avl_date;
    }

    public Integer getMaxguestAllowed() {
        return maxguestAllowed;
    }

    public void setMaxguestAllowed(Integer maxguestAllowed) {
        this.maxguestAllowed = maxguestAllowed;
    }

    public boolean isRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(boolean roomstatus) {
        this.roomstatus = roomstatus;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}