package com.emse.spring.faircop.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity() // 1.
@Table(name = "Room") // 2.
public class Room {
    @Id // 3.
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length=255, name = "Name") //4.
    private String name;
    @Column(nullable = false, length=255, name = "Floor") //4.
    private Integer floor;

    @OneToMany(mappedBy = "room")
    private List<Light> lights;
    @ManyToOne
    private Building building;
    public Room() {

    }

    public Room( String name, Integer floor, Building building) {

        this.name=name;
        this.floor = floor;
        this.lights = new ArrayList<>();
        this.building=building;
    }

    public Room( String name, Integer floor) {

        this.name = name;
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Light> getLights() {
        return lights;
    }


}
