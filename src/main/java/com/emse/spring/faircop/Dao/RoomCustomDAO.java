package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;

import java.util.List;

public interface RoomCustomDAO {
    Room findRoombyName(String RoomName);
    List<Light> findLightByRoom(Long id);
}
