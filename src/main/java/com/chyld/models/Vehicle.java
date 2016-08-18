package com.chyld.models;


import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "vehicles")
public class Vehicle {
    private int id;
    private String make;
    private String model;
    private String year;

    public Vehicle() {
    }

    public Vehicle(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
}
