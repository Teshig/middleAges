package com.pilotProject.middleAges.engine;

import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;
import lombok.Data;

@Data
public class GameResponse {
  private String message;
  private Person personState;
  private Room roomState;
}
