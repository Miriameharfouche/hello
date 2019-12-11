package com.emse.spring.faircop.DTO;

import com.emse.spring.faircop.model.Building;
import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private List<LightDto> lights;
    // private Building building;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        //  this.building = room.getBuilding();
        if (room.getLights() != null) {
            this.lights = room.getLights().stream().map(LightDto::new).collect(Collectors.toList());
        }else{
            this.lights=new ArrayList<>();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public List<LightDto> getLights() {
        return lights;
    }

   /* public Building getBuilding() {
        return building;
    }*/
}
