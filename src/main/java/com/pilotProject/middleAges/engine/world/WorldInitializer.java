package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;
import com.pilotProject.middleAges.engine.repository.RoomRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WorldInitializer {

  private final RoomRepository roomRepository;

  public WorldInitializer(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public World createWorld() {
    Map<String, Room> allRoom = roomRepository.findAllRoom();
    Map<String, Person> players = new HashMap<>();
    return new World(allRoom, players);
  }
}
