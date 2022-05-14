package com.pilotProject.middleAges.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Room {

  private String id;
  private String title;
  private String description;

  private Map<ExitDirection, ExitDescription> exits;
  private HashMap<String, Player> peopleInside;

  public boolean removePerson(String personId) {
    Player person = peopleInside.remove(personId);
    return person != null;
  }

  public boolean addPerson(String personId, Player person) {
    peopleInside.put(personId, person);
    return true;
  }
}
