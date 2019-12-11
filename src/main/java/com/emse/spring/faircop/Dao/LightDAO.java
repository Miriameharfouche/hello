package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDAO extends JpaRepository<Light, Long>, LightCustomDAO {
}
