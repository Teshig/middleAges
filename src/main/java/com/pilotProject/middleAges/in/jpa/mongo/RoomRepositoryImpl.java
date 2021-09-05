package com.pilotProject.middleAges.in.jpa.mongo;

import com.pilotProject.middleAges.engine.model.Room;
import com.pilotProject.middleAges.engine.repository.RoomRepository;
import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomDto;
import com.pilotProject.middleAges.in.jpa.mongo.mapper.RoomMapper;
import com.pilotProject.middleAges.in.jpa.mongo.repository.RoomJpaRepository;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class RoomRepositoryImpl implements RoomRepository {

  private RoomJpaRepository roomJpaRepository;

  @Override
  public Map<String, Room> findAllRoom() {
    Iterable<RoomDto> allRooms = roomJpaRepository.findAll();
    return RoomMapper.map(allRooms);
  }
}
