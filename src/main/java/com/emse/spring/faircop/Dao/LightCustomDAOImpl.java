package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LightCustomDAOImpl implements LightCustomDAO {

        @PersistenceContext
        private EntityManager em;

        @Override
        public List<Light> findOnLights() {
            String jpql = "select lt from Light lt where lt.status = :value";
            return em.createQuery(jpql, Light.class)
                    .setParameter("value", Status.ON)
                    .getResultList();
        }

}
