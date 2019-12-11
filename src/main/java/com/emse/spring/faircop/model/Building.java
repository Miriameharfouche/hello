package com.emse.spring.faircop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity()
@Table(name = "Building")
public class Building {
    @Id // 3.
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    public Building() {

    }

    public Building(Long id) {
        this.id = id;
        this.rooms = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
