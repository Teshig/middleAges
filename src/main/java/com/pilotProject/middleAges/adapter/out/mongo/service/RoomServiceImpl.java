package com.pilotProject.middleAges.adapter.out.mongo.service;

import com.pilotProject.middleAges.adapter.out.mongo.mapper.RoomMapper;
import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import com.pilotProject.middleAges.domain.entity.Room;
import com.pilotProject.middleAges.domain.external.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

  private RoomMongoRepository repository;

  @Override
  public Map<String, Room> findAllRoom() {
    return RoomMapper.map(repository.findAll());
  }
}
