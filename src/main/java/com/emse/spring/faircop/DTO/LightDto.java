package com.emse.spring.faircop.DTO;

import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;
import com.emse.spring.faircop.model.Status;

public class LightDto {

    private  Long id;
    private  Integer level;
    private Status status;
    private Long roomId;

    public LightDto() {
    }

    public LightDto(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
        this.roomId=light.getRoom().getId();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public Long getRoomId() {
        return this.roomId;
    }
}