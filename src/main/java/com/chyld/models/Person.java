package com.chyld.models;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "person")
public class Person {
    private int id;
    private String name;
    private int age;
    private String  gender;
    private int monthly;
    //private List<Vehicle> vehicles;


    public Person() {
    }

    public Person(String name, int age, String gender, int monthly) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.monthly = monthly;
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

//    @Basic
//    @Column(name = "gender", nullable = false)
//    @Enumerated(EnumType.STRING)
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getMonthly() { return monthly; }
    public void setMonthly(int monthly) { this.monthly = monthly; }


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicles")
//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
}
