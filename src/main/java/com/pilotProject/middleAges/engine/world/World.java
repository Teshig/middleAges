package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.entity.ExitDescription;
import com.pilotProject.middleAges.engine.entity.ExitDirection;
import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import java.util.Map;

public class World {
  private final Map<String, Room> rooms;
  private final Map<String, Person> players;

  public World(
      Map<String, Room> rooms,
      Map<String, Person> players) {
    this.rooms = rooms;
    this.players = players;
  }

  public WorldState movePlayerTo(
      String personId,
      ExitDirection direction) {

    Person person = players.get(personId);
    String currentRoomId = person.getCurrentLocation();
    Room currentRoom = rooms.get(currentRoomId);
    Map<ExitDirection, ExitDescription> exits = currentRoom.getExits();

    WorldState response = new WorldState();
    ExitDescription exit = exits.get(direction);
    if (exit == null) {
      response.setRoomState(currentRoom);
      response.setPlayerState(person);
      response.setSuccess(false);
      return response;
    }

    String nextRoomId = exit.getExitTo();
    Room nextRoom = rooms.get(nextRoomId);

    currentRoom.removePerson(personId);
    nextRoom.addPerson(personId, person);
    person.setCurrentLocation(nextRoomId);

    response.setRoomState(nextRoom);
    response.setPlayerState(person);
    response.setSuccess(true);
    return response;
  }
}
