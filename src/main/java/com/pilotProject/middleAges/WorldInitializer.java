package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import com.pilotProject.middleAges.mongo.entity.RoomEntity;
import com.pilotProject.middleAges.mongo.entity.RoomId;
import com.pilotProject.middleAges.mongo.repository.RoomRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorldInitializer {

  private final RoomRepository roomRepository;

  @Autowired
  public WorldInitializer(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public World createWorld() {
    Iterable<RoomEntity> roomSet = roomRepository.findAll();
    Map<String, Room> rooms = new TreeMap<>();
    for (RoomEntity roomEntity : roomSet) {
      RoomId roomId = roomEntity.getId();

      rooms.put(roomId.getZoneId() + roomId.getRoomId(), new Room(roomEntity));
    }

    Map<String, Person> players = new HashMap<>();
    players.put("firstPerson", new Person("firstPerson", "00010000"));
    return new World(rooms, players);
  }

}
