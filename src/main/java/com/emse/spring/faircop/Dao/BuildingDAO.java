package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDAO extends JpaRepository<Building, String>, BuildingCustomDAO {
}
