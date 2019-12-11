package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingCustomDAOImpl implements BuildingCustomDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Light> findLightByBuilding(Long id) {

        String jpql = "select lt from Light lt where lt.room.building.id= :value";
        return em.createQuery(jpql,Light.class)
                .setParameter("value", id)
                .getResultList();
    }
}
