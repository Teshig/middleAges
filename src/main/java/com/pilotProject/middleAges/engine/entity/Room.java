package com.pilotProject.middleAges.engine.entity;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

  private String id;
  private String title;
  private String description;

  private Map<ExitDirection, ExitDescription> exits;
  private HashMap<String, Person> peopleInside;

  public boolean removePerson(String personId) {
    Person person = peopleInside.remove(personId);
    return person != null;
  }

  public boolean addPerson(String personId, Person person) {
    peopleInside.put(personId, person);
    return true;
  }
}
