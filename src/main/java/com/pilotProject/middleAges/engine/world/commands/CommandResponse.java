package com.pilotProject.middleAges.engine.world.commands;

import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;
import lombok.Data;

@Data
public class CommandResponse {
  private Room roomState;
  private Person personState;
  private String keyForDisplaying;
}
