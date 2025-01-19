package com.hms.entity;

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

    private Integer bedcount;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getBedcount() {
        return bedcount;
    }

    public void setBedcount(Integer bedcount) {
        this.bedcount = bedcount;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}