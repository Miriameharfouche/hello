package com.emse.spring.faircop.repository;

import com.emse.spring.faircop.Dao.RoomDAO;
import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;
import com.emse.spring.faircop.model.Status;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomCustomDAOImplTest {
    @Autowired
    RoomDAO roomDAO;

    @Test
    public void shouldFindRoomByName() {
        Room room = roomDAO.findRoombyName("Room1");
        Assertions.assertThat(room.getName())
                .isEqualTo("Room1");
    }

    @Test
    public void shouldFindLightsByRoomId() {
        List<Light> li = roomDAO.findLightByRoom(-10L);
        Assertions.assertThat(li.size() == 2);


    }
}
