package com.pilotProject.middleAges.engine.repository;

import com.pilotProject.middleAges.engine.model.Room;

import java.util.Map;

public interface RoomRepository {

  public Map<String, Room> findAllRoom();

}
