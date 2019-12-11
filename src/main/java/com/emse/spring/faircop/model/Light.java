package com.emse.spring.faircop.model;

import javax.persistence.*;

@Entity // 1.
@Table(name = "Light") // 2.
public class Light {
    @Id // 3.
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255, name = "Level") //4.
    private Integer level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "Status") //5.
    private Status status;
    @ManyToOne
    private Room room;

    public Light() {
    }

    public Light(Integer level, Status status, Room room) {
        this.level = level;
        this.status = status;
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }
}
