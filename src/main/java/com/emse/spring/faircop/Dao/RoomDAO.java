package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.Dao.RoomCustomDAO;
import com.emse.spring.faircop.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDAO extends JpaRepository<Room, Long>, RoomCustomDAO {

}
