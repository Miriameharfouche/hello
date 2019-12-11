package com.emse.spring.faircop.Dao;

import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomCustomDAOImpl implements RoomCustomDAO {
    @PersistenceContext
    private EntityManager em;


    @Override
    public Room findRoombyName(String RoomName) {
        String jpql = "select lt from Room lt where lt.name = :value";
        return em.createQuery(jpql, Room.class)
                .setParameter("value",RoomName)
                .getSingleResult();
    }

    @Override
    public List<Light> findLightByRoom(Long id) {
        String jpql = "select lt from Light lt where lt.room.id= :value";
        return em.createQuery(jpql,Light.class)
                .setParameter("value", id)
                .getResultList();

    }
}
