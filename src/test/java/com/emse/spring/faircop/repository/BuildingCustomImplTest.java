package com.emse.spring.faircop.repository;

import com.emse.spring.faircop.Dao.BuildingDAO;
import com.emse.spring.faircop.model.Light;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingCustomImplTest {
    @Autowired
    BuildingDAO buildingDAO;

    @Test
   public void shouldFindLightByBuildingId()
    {
        List<Light> li = buildingDAO.findLightByBuilding(-10L);
        Assertions.assertThat(li.size() == 2);
    }
}
