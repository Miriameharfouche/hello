package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;

import java.util.List;

interface BuildingCustomDAO {
   List<Light> findLightByBuilding(Long id);
}
