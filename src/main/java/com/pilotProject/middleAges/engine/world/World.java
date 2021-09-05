package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.model.ExitDescription;
import com.pilotProject.middleAges.engine.model.ExitDirection;
import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;
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

  public WorldState enterTheWorld(Person person) {
    players.put(person.getId(), person);

    String currentRoomId = person.getCurrentLocation();
    Room currentRoom = rooms.get(currentRoomId);

    return worldState(true, person, currentRoom);
  }

  public WorldState movePlayerTo(
      String personId,
      ExitDirection direction) {

    Person person = players.get(personId);
    String currentRoomId = person.getCurrentLocation();
    Room currentRoom = rooms.get(currentRoomId);
    Map<ExitDirection, ExitDescription> exits = currentRoom.getExits();

    ExitDescription exit = exits.get(direction);
    if (exit == null) {
      return worldState(false, person, currentRoom);
    }

    String nextRoomId = exit.getExitTo();
    Room nextRoom = rooms.get(nextRoomId);

    currentRoom.removePerson(personId);
    nextRoom.addPerson(personId, person);
    person.setCurrentLocation(nextRoomId);

    return worldState(true, person, nextRoom);
  }

  private WorldState worldState(boolean success, Person playerState, Room roomState) {
    return new WorldState(success, playerState, roomState);
  }
}