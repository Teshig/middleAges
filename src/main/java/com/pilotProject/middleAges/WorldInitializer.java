package com.pilotProject.middleAges;

import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import com.pilotProject.middleAges.engine.world.World;
import com.pilotProject.middleAges.mongo.entity.RoomEntity;
import com.pilotProject.middleAges.mongo.repository.RoomRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WorldInitializer {

  private final RoomRepository roomRepository;

  public WorldInitializer(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public World createWorld() {
    Iterable<RoomEntity> roomSet = roomRepository.findAll();
    Map<String, Room> rooms = mapRoomEntityToDto(roomSet);

    Map<String, Person> players = generatePlayers();
    return new World(rooms, players);
  }

  private Map<String, Person> generatePlayers() {
    Map<String, Person> players = new HashMap<>();
    players.put("firstPerson", new Person("firstPerson", "00010000"));
    return players;
  }

  private Map<String, Room> mapRoomEntityToDto(Iterable<RoomEntity> roomSet) {
    Map<String, Room> rooms = new TreeMap<>();
    RoomMapper roomMapper = new RoomMapper();
    for (RoomEntity roomEntity : roomSet) {
      Room room = roomMapper.map(roomEntity);
      rooms.put(room.getId(), room);
    }
    return rooms;
  }

}
