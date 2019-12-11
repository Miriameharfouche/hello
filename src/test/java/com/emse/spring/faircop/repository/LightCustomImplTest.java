package com.emse.spring.faircop.repository;

import com.emse.spring.faircop.Dao.LightDAO;
import com.emse.spring.faircop.model.Status;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LightCustomImplTest {
    @Autowired
    private LightDAO lightDao;

    @Test
    public void shouldFindOnLights() {
        Assertions.assertThat(lightDao.findOnLights())
                .hasSize(1)
                .extracting("id", "status")
                .containsExactly(Tuple.tuple(-1L, Status.ON));
    }
}
