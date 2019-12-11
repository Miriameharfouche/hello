package com.emse.spring.faircop.Controllers;
import com.emse.spring.faircop.DTO.LightDto;
import com.emse.spring.faircop.DTO.RoomDto;
import com.emse.spring.faircop.Dao.LightDAO;
import com.emse.spring.faircop.Dao.RoomDAO;
import com.emse.spring.faircop.model.Light;
import com.emse.spring.faircop.model.Room;
import com.emse.spring.faircop.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    @Autowired
    private LightDAO lightDao; // 4.
    @Autowired
    private RoomDAO roomDao;

    @GetMapping // 5.
    public List<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> new RoomDto(room)).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public List<LightDto> switchStatus(@PathVariable Long id) {
       RoomDto roomDto=findById(id);
        List<LightDto> lightD = new ArrayList<>();
        for(LightDto l:roomDto.getLights())
        {
            Light light=lightDao.findById(l.getId()).orElseThrow(IllegalArgumentException::new);
            light.setStatus(l.getStatus() == Status.ON ? Status.OFF: Status.ON);
       lightD.add(new LightDto(light));
        }
        return lightD;
    }
    @PutMapping(path = "/{id}/switch/light/{id}")
    public List<LightDto> switchLight(@PathVariable Long id) {
        RoomDto roomDto=findById(id);
        List<LightDto> lightD = new ArrayList<>();
        for(LightDto l:roomDto.getLights())
        {
            Light light=lightDao.findById(l.getId()).orElseThrow(IllegalArgumentException::new);
            light.setStatus(l.getStatus() == Status.ON ? Status.OFF: Status.ON);
            lightD.add(new LightDto(light));
        }
        return lightD;
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId() != null) {
            room = roomDao.findById(dto.getId()).orElse(null);
        }

        if (room == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getFloor()));
        } else {
            room.setName(dto.getName());
            room.setFloor(dto.getFloor());
            roomDao.save(room);

        }

        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        RoomDto roomDto=findById(id);
        for(LightDto l:roomDto.getLights())
        {
            lightDao.deleteById(l.getId());
        }

        roomDao.deleteById(id);
    }
}
