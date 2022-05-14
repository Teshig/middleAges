package com.pilotProject.middleAges.domain.world;

import com.pilotProject.middleAges.domain.entity.Player;
import com.pilotProject.middleAges.domain.entity.Room;
import com.pilotProject.middleAges.domain.external.service.RoomService;

import java.util.HashMap;
import java.util.Map;

public class WorldInitializer {

  private final RoomService roomService;

  public WorldInitializer(RoomService roomService) {
    this.roomService = roomService;
  }

  public World createWorld() {
    Map<String, Room> allRoom = roomService.findAllRoom();
    Map<String, Player> players = new HashMap<>();
    return new World(allRoom, players);
  }
}
