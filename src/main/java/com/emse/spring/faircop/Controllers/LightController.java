package com.emse.spring.faircop.Controllers;

import com.emse.spring.faircop.DTO.LightDto;
import com.emse.spring.faircop.Dao.LightDAO;
import com.emse.spring.faircop.Dao.RoomDAO;
import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController  // 1.
@RequestMapping("/api/lights") // 2.
@Transactional // 3.
public class LightController {
    @Autowired
    private LightDAO lightDao; // 4.
    @Autowired
    private RoomDAO roomDao;


    @GetMapping // 5.
    public List<LightDto> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());
    }
    @GetMapping(path = "/on")
    public List<LightDto> findonLight(){
        return lightDao.findOnLights().stream().map(LightDto::new).collect(Collectors.toList());
    }
    @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public LightDto switchStatus(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
        return new LightDto(light);
    }
    @PostMapping
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
            light = lightDao.save(new Light(dto.getLevel(), dto.getStatus(), roomDao.getOne(dto.getRoomId())));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }
}
