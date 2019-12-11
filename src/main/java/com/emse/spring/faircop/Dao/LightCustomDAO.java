package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;

import java.util.List;

public interface LightCustomDAO {
    List<Light> findOnLights();
}
