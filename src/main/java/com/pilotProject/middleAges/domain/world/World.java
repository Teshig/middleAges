package com.pilotProject.middleAges.domain.world;

import com.pilotProject.middleAges.domain.entity.ExitDescription;
import com.pilotProject.middleAges.domain.entity.ExitDirection;
import com.pilotProject.middleAges.domain.entity.Player;
import com.pilotProject.middleAges.domain.entity.Room;

import java.util.Map;

public class World {
  private final Map<String, Room> rooms;
  private final Map<String, Player> players;

  public World(
      Map<String, Room> rooms,
      Map<String, Player> players) {
    this.rooms = rooms;
    this.players = players;
  }

  public WorldState enterTheWorld(Player person) {
    players.put(person.getName(), person);

    String currentRoomId = person.getLocation();
    Room currentRoom = rooms.get(currentRoomId);

    return worldState(true, person, currentRoom);
  }

  public WorldState movePlayerTo(
      String personId,
      ExitDirection direction) {

    Player person = players.get(personId);
    String currentRoomId = person.getLocation();
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
    person.setLocation(nextRoomId);

    return worldState(true, person, nextRoom);
  }

  private WorldState worldState(boolean success, Player playerState, Room roomState) {
    return new WorldState(success, playerState, roomState);
  }
}